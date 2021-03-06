package cz.jcu.prf.volby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class ElectionDaoImplementaion implements ElectionDao {

    private static final String URL = "jdbc:mysql://db4free.net:3306/volby_2018?verifyServerCertificate=false&useSSL=true";
    private static final String USER = "babis_2018";
    private static final String PASSWORD = "capihnizdo";

    private static final int TRUE = 1;
    private static final int FALSE = 2;
    private static final int ERROR = 3;
    private static final int VOTED = 4;

    private static Connection con = null;
    private static ResultSet rs = null;
    private static Statement st = null;
    public static ElectionDaoImplementaion self = null;
    
    
        private ElectionDaoImplementaion() {};
    
     public static ElectionDaoImplementaion getInstance() {
        if (self == null) {
            self = new ElectionDaoImplementaion();
        }
        return self;
    }


    @Override
    public int verifyUser(String hashOP, String passwd) {
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Osoby WHERE cisloOP='" + hashOP + "'");
            if (rs.next()) {
                if (passwd.equals(rs.getString(3))) {
                    con.close();
                    return TRUE;
                } else {
                    con.close();
                    return FALSE;
                }
            } else {
                con.close();
                return FALSE;
            }
        } catch (SQLException ex) {
            return ERROR;
        }
    }

    @Override
    public int vote(int personId, int candId, int voteDate) {
        try {
                con = DriverManager.getConnection(URL, USER, PASSWORD);
                st = con.createStatement();

                    st.executeUpdate("INSERT INTO Hlasy (idOsoby, idKandidat, datum) VALUES ('" + personId + "', '" + candId + "', '" + voteDate + "')");
                    return TRUE;
                  
            } catch (SQLException ex) {
                System.out.println(ex);
                return ERROR;
            }
    }

    @Override
    public int verifyVote(int personId, int date) {
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Hlasy WHERE idOsoby='" + personId + "' AND datum='" + date + "'");
            if(rs.next()){
                return VOTED;
            }
            else {
                con.close();
                return TRUE;
            }
        } catch (SQLException ex) {
            return ERROR;
        }
    }

    @Override
    public String[] getPerson(String hashOP) {
        String[] result = new String[3];
        try {

            con = DriverManager.getConnection(URL, USER, PASSWORD);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Osoby WHERE cisloOP='" + hashOP + "'");
            rs.next();
            result[0] = rs.getString(1);
            result[1] = rs.getString(4);
            result[2] = rs.getString(5);
            con.close();
            return result;

        } catch (SQLException ex) {
            result[0] = Integer.toString(ERROR);
            return result;
        }
    }

    @Override
    public String[] getCandidatesId(int voteDateId) {
        String[] result;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            st = con.createStatement();

            rs = st.executeQuery("SELECT * FROM Kandidat k WHERE idObdobi='" + voteDateId + "'");

            if (rs == null) {
                result = new String[1];
                result[0] = Integer.toString(FALSE);
                return result;
            }

            rs.last();
            int k = rs.getRow();
            result = new String[k];
            rs.beforeFirst();
            int i = 0;
            while (rs.next()) {
                result[i] = rs.getString(1);
                i++;
            }
            con.close();
            return result;
        } catch (SQLException ex) {
            result = new String[1];
            result[0] = Integer.toString(ERROR);
            return result;
        }
    }

    @Override
    public String[] getCandidateName(long candId) {
        String[] result = new String[2];
        try {

            con = DriverManager.getConnection(URL, USER, PASSWORD);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Osoby JOIN Kandidat ON Osoby.id = Kandidat.idOsoby WHERE Kandidat.id = '" + candId + "'");
            rs.next();
            result[0] = rs.getString(4);
            result[1] = rs.getString(5);
            return result;

        } catch (SQLException ex) {
            result[0] = Integer.toString(ERROR);
            return result;
        }
    }

    @Override
    public int getCandidateVotes(long candId, int voteDate) {
         int result;
     try {

         con = DriverManager.getConnection(URL, USER, PASSWORD);
         st = con.createStatement();
         rs = st.executeQuery("SELECT COUNT(id) AS NumberOfVotes FROM Hlasy WHERE idKandidat='" + candId + "' AND datum='" + voteDate + "'");
         rs.next();
         return result = rs.getInt(1);

     } catch (SQLException ex) {
         return result = ERROR;
     }
}
   
    

}
