package starWars;

public class Acteur {
    String nom;
    String prenom;

    public Acteur() {
    }

    public Acteur(int id, String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    void setNom(String nom) {
        this.nom = nom;
    }

    void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String toString() {
        return "Nom : " + this.nom + "\n Prénom: " + this.prenom;
    }

}