package starWars;

import java.text.ParseException;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;

public class Film {
    // Variables
    private int id;
    private String titre;
    private String annee_sortie;
    private int nb_episode;
    private double cout;
    private double recette;
    private ArrayList<Acteur> acteurs;

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

    public Film(String titre, String annee_sortie, int nb_episode, double cout, double recette) {
        this.titre = titre;
        this.annee_sortie = annee_sortie;
        this.nb_episode = nb_episode;
        this.cout = cout;
        this.recette = recette;
        this.acteurs = new ArrayList();
    }

    public Film new_film() {

        System.out.println("Creation Nouveau film :");
        Scanner scan = new Scanner(System.in);
        System.out.println("- Titre du film : ");
        String titreFilm = scan.nextLine();

        this.titre = titreFilm;
        System.out.println("- Annee du film : ");
        String anneeSortiFilm = scan.next();
        this.annee_sortie = anneeSortiFilm;
        System.out.println("- Numero du film : ");
        int numeroFilm = scan.nextInt();

        this.nb_episode = numeroFilm;
        System.out.println("- Cout du film : ");
        int coutFilm = scan.nextInt();

        this.cout = coutFilm;
        System.out.println("- Recette du film : ");
        int recetteFilm = scan.nextInt();

        this.recette = recetteFilm;

        System.out.println(" Nouveau film enregistré dans l'Array ! ");
        Film new_film = new Film(titreFilm, anneeSortiFilm, numeroFilm, coutFilm, recetteFilm);
        return new_film;

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

    public int getNombreActeurs() {
        return !this.acteurs.isEmpty() && this.acteurs.size() > 0 ? this.acteurs.size() : 0;
    }

    public int getNombrePersonnages() {
        int i = 0;
        for (Acteur acteur : this.acteurs) {
            i += acteur.getNombrePersonnages();
        }
        return i;
    }

    public ArrayList calculBenefice() {

        double diff = this.recette - this.cout;
        ArrayList result = new ArrayList();

        if (diff >= 0) {

            result.add(true);
            result.add(diff);

        } else {
            result.add(false);
            result.add(diff);
        }
        return result;
    }

    public boolean isBefore(String anneeInserted) throws ParseException {
        DateFormat format = new SimpleDateFormat("YYYY", Locale.FRANCE);
        Date anneeDeSortieToDate = format.parse(this.annee_sortie);

        Date anneeInsertedToDate = format.parse(anneeInserted);
        return anneeDeSortieToDate.compareTo(anneeInsertedToDate) < 0;
    }

    public ArrayList tri() {
        ArrayList<Acteur> Tries = new ArrayList();
        if (this.acteurs != null && !this.acteurs.isEmpty()) {

            Collections.sort(this.acteurs, new Comparator<Acteur>() {

                public int compare(Acteur acteur1, Acteur acteur2) {
                    return acteur1.getNom().compareTo(acteur2.getNom());
                }
            });

            Tries.addAll(this.acteurs);

        } else {
            Tries = null;

        }
        return Tries;
    }

    // Fonctions ToString pour afficher les valeurs des attributs

    public String toString() {
        return "[Film]" +
                "- Titre du film: " + this.titre + "\n - Numero " + this.nb_episode + "\n - Date de Sortie : "
                + this.annee_sortie + "\n - Cout " + this.cout + "\n - Recette : " + this.recette + "\n- nb acteurs : "
                + this.getNombreActeurs() + "\n- nb personnages : " + this.getNombrePersonnages() + "\n- bénéfice : "
                + this.calculBenefice();

    }

}