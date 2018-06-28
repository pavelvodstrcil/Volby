/*        NEFUNGUJE POUZE TEST      */

package cz.jcu.prf.volby;

import java.sql.*;

public class DatabaseConnect {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    
    public static void main(String[] args) throws SQLException {
     DatabaseConnect pokus = DatabaseConnect(); 
    }
    public DatabaseConnect() {
        try {
           con = DriverManager.getConnection("jbdc:mysql://db4free.net:3306/volby_2018", "babis_2018","capihnizdo");
        } catch (Exception ex) {

        }

    }
}
