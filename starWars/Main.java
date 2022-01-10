package starWars;

import java.util.ArrayList;
import java.util.HashMap;
import java.text.ParseException;

public class Main {
    public static void main(String[] arg) throws ParseException {

        Film film1 = new Film("Star wars 1", "1977", 1, 15000, 50000);
        Film film2 = new Film("Star wars 2", "1980", 2, 20000, 75000);
        Film film3 = new Film(null, null, 0, 0, 0);
        film3.new_film();
        ArrayList<Film> Prelogie = new ArrayList();
        Prelogie.add(film1);
        Prelogie.add(film2);
        Prelogie.add(film3);

        Personnage perso1 = new Personnage("Han", "Solo");
        Personnage perso2 = new Personnage("Skywalker", "Luke");
        Personnage perso3 = new Personnage("Boba", "Fett");

        ArrayList<Personnage> Personnages = new ArrayList();

        Personnages.add(perso1);
        Personnages.add(perso2);
        Personnages.add(perso3);

        Acteur acteur1 = new Acteur("Ford", "Harrison");
        ArrayList<Personnage> personnagesActeur1 = new ArrayList(1);
        personnagesActeur1.add(perso1);
        personnagesActeur1.add(perso2);
        acteur1.setDuetPersonnages(personnagesActeur1);

        ArrayList<Acteur> acteursList1 = new ArrayList();
        acteursList1.add(acteur1);
        film1.setActeurs(acteursList1);
        System.out.println("\n" + film1.toString());

        toString(Prelogie);

        int k = 1;
        for (Personnage Personnage : Personnages) {
            System.out.println("\n [Personnage " + k + "]" + Personnage.toString());
            k++;
        }

        System.out.println("\n L'acteur " + acteur1.nom + " " + acteur1.prenom + " joue "
                + acteur1.getNombrePersonnages() + " personnages");

        film1.toString();

    }

    public static void toString(ArrayList<Film> Trilogie) {
        int y = 1;
        for (Film Film : Trilogie) {
            System.out.println("[Film " + y + "]" + Film.toString());
            y++;
        }

    }

}
