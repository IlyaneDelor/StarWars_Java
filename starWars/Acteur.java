package starWars;

import java.util.ArrayList;

public class Acteur {
    String nom;
    String prenom;
    private ArrayList<Personnage> duetPersonnages = new ArrayList(1);

    public Acteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    // Get

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public ArrayList getDuetPersonnages() {
        return duetPersonnages;
    }

    public int getNombrePersonnages() {
        return this.duetPersonnages.size();
    }

    // Set
    void setNom(String nom) {
        this.nom = nom;
    }

    void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDuetPersonnages(ArrayList duetPersonnages) {
        this.duetPersonnages = duetPersonnages;
    }

    public String toString() {
        return "Nom : " + this.nom + "\n Prénom: " + this.prenom;
    }

}