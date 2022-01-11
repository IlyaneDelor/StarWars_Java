package starWars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOAcces {
    String bddName = "bdd";
    String Login = "root";
    String mdp = "root";
    String IP = "localhost";
    String Port = "3306";
    String Url = "jdbc:mysql://" + this.IP + ":" + this.Port + "/" + this.bddName;

    String driver = "com.mysql.jdbc.Driver";
    Statement statement;
    Connection conn;

    public DAOAcces(String bddName, String Login, String mdp, String IP, String Port) {
        try {

            this.bddName = bddName;
            this.Login = Login;
            this.mdp = mdp;
            this.IP = IP;
            this.Port = Port;
            this.conn = DriverManager.getConnection(
                    "jdbc:mysql://" + IP + ":" + Port + "/" + bddName + "?autoReconnect=true&useSSL=false", Login, mdp);
            Class.forName(this.driver);
            this.statement = conn.createStatement();

        } catch (ClassNotFoundException e) {
            System.err.println("Driver non chargé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }

    }

    public void Close() {
        try {
            this.conn.close();
            System.out.println("\nConnection Fermee !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] arg) {
        DAOAcces dao = new DAOAcces("bdd", "root", "root", "localhost", "3306");
        System.out.println("Connection Reussie !\n");
        dao.Close();

    }

}
