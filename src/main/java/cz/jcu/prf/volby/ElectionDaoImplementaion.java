package cz.jcu.prf.volby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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

    private static Connection con = null;
    private static ResultSet rs = null;
    private static Statement st = null;
    private static PreparedStatement pst;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int verifyVote(int personId, int date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            rs = st.executeQuery("SELECT * FROM 'Osoby' JOIN 'Kandidat' ON Osoby.id = Kandidat.idOsoby WHERE Kandidat.id = '" + candId + "'");
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
    public List getCandidateVotes(long candId, int voteDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String currentVoteDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
