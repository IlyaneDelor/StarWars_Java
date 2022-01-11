package starWars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.ResultSet;


public class Select {

    public static void main(String[] args) {

        try {
            String strClassName = "com.mysql.jdbc.Driver";
            String dbName = "bdd";
            String login = "root";
            String motdepasse = "root";
            String strUrl = "jdbc:mysql://127.0.0.1:3306/" + dbName + "?verifyServerCertificate=false"+
    				"&useSSL=true"+
    				"&requireSSL=false";;

            Class.forName(strClassName);
            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
            // . . .
           String queryFilm = "SELECT * FROM acces;";
            Statement log = conn.createStatement();
            ResultSet res = log.executeQuery(queryFilm);
            while (res.next()) {
                System.out.print (res.getInt(1) + " -- Prénom :" + res.getString(2) + " / Login :" + res.getString(3) + " / Password :  "
                        + res.getString(4) + " / Age :  " + res.getString(5) + "\n \n");
            }
            res.close();

            Scanner sc = new Scanner(System.in);
            

            conn.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Driver non chargÃ© !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }

    }
}
