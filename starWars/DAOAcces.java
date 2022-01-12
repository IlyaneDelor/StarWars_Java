package starWars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public void Lister() {
        try {
            String query = "SELECT * FROM Acces";
            ResultSet users = this.statement.executeQuery(query);
            while (users.next()) {

                System.out.println("Id : " + users.getInt(1) + " / Prenom : " + users.getString(2)
                        + " / Login : "
                        + users.getString(3) + " / Password : " + users.getString(4) + " / Statut : "
                        + users.getString(5)
                        + " / Age : " + users.getInt(6) + "\n");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void Ajout(String prenom, String login, String password, String statut, int age) {
        try {

            String queryAdd = "INSERT INTO Acces (prenom,login,password,statut,age) VALUES (?,?,?,?,?);";

            PreparedStatement statementP = conn.prepareStatement(queryAdd);
            statementP.setString(1, prenom);
            statementP.setString(2, login);
            statementP.setString(3, password);
            statementP.setString(4, statut);
            statementP.setInt(5, age);
            statementP.execute();

        } catch (

        SQLException e) {
            System.out.println(e);
        }
    }

    public void Delete(int id) {
        try {

            String queryDel = "DELETE FROM Acces WHERE id = " + id + ";";

            PreparedStatement statementP = conn.prepareStatement(queryDel);
            statementP.executeUpdate();
            System.out.println("Delete reussi !\n \n");

        } catch (

        SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] arg) {
        DAOAcces dao = new DAOAcces("bdd", "root", "root", "localhost", "3306");
        System.out.println("Connection Reussie !\n");
        System.out.println("Liste Avant : !\n");

        dao.Lister();

        dao.Ajout("Ilyane", "Delor", "ok", "Admin", 21);
        dao.Delete(3);

        System.out.println("Liste Apres : !\n");
        dao.Lister();

        dao.Close();

    }

}
