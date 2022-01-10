package starWars;

import java.util.ArrayList;

public class Film {

    // Variables
    private int id;
    private String titre;
    private String annee_sortie;
    private int nb_episode;
    private double cout;
    private double recette;
    private ArrayList<Acteur> acteurs;

    public Film() {
    }

    /**
     * Constructor
     * 
     * Film(String titre, String annee_sortie, String nb_episode, String cout,
     * String recette)
     * 
     * @param id
     * @param titre
     * @param annee_sortie
     * @param nb_episode
     * @param cout
     * @param recette
     */

    public Film(int id, String titre, String annee_sortie, int nb_episode, double cout, double recette) {
        this.id = id;
        this.titre = titre;
        this.annee_sortie = annee_sortie;
        this.nb_episode = nb_episode;
        this.cout = cout;
        this.recette = recette;
        this.acteurs = new ArrayList();
    }

    // Get
    public int getId() {
        return this.id;
    }

    public String getTitre() {
        return titre;
    }

    public String getAnnee_sortie() {
        return annee_sortie;
    }

    public int getNb_episode() {
        return nb_episode;
    }

    public double getCout() {
        return cout;
    }

    public double getRecette() {
        return recette;
    }

    public ArrayList<Acteur> getActeurs() {
        return acteurs;
    }

    // Set

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAnnee_sortie(String annee_sortie) {
        this.annee_sortie = annee_sortie;
    }

    public void setNb_episode(int nb_episode) {
        this.nb_episode = nb_episode;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public void setRecette(double recette) {
        this.recette = recette;
    }

    public void setActeurs(ArrayList<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

    // Fonctions ToString pour afficher les valeurs des attributs

    public String toString() {
        return "[Film]" +
                "Titre du film: " + this.titre + "\n Numéro " + this.nb_episode + "\n Date de Sortie : "
                + this.annee_sortie + "\n Coût " + this.cout + "\n Recette : " + this.recette;

    }
}