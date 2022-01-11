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
            String strUrl = "jdbc:mysql://127.0.0.1:3306/" + dbName + "?verifyServerCertificate=false" +
                    "&useSSL=true" +
                    "&requireSSL=false";
            ;

            Class.forName(strClassName);
            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
            // . . .
            String queryFilm = "SELECT * FROM acces;";
            Statement log = conn.createStatement();
            ResultSet res = log.executeQuery(queryFilm);
            while (res.next()) {
                System.out.print(res.getInt(1) + " -- Pr�nom :" + res.getString(2) + " / Login :" + res.getString(3)
                        + " / Password :  "
                        + res.getString(4) + " / Age :  " + res.getString(5) + "\n \n");
            }
            res.close();

            Scanner sc = new Scanner(System.in);

            System.out.println("Vous voulez supprimez quel Film (id // 0 pour ne pas en supprimer) : \n ");
            String id = sc.nextLine();
            int verif = Integer.parseInt(id);

            if (verif == 0) {
                System.out.println("Aucun ne sera supprime \n");
            } else {
                String delQuery = "DELETE FROM acces WHERE id =" + id + ";";
                log.executeUpdate(delQuery);
                System.out.println("La ligne avec l'id : " + id + " a ete supprimer \n");
            }

            System.out.println(" \n Vous voulez update quel Statut (id  // 0 pour ne pas en supprimer) : ");
            String id2 = sc.nextLine();
            verif = Integer.parseInt(id2);

            if (verif != 0) {
                System.out.println("\nQuelle est le nouveau Statut : \n");
                String newStatut = sc.nextLine();
                String uptQuery = "UPDATE acces set statut = '" + newStatut + "' where id = " + id2 + ";";
                log.executeUpdate(uptQuery);
                System.out.println("\n Statut de l'id : " + id2 + " a ete udpdate en " + newStatut + ". \n");
            } else {
                System.out.println("Update annule");
            }
            conn.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Driver non chargé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }

    }
}
