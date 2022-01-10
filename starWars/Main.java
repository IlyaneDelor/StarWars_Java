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
        Personnage perso4 = new Personnage("Padme", "Amidala");

        ArrayList<Personnage> Personnages = new ArrayList();

        Personnages.add(perso1);
        Personnages.add(perso2);
        Personnages.add(perso3);
        Personnages.add(perso4);

        Acteur acteur1 = new Acteur("Ford", "Harrison");
        Acteur acteur2 = new Acteur("Portman", "Natalie");
        Acteur acteur3 = new Acteur("Morrison", "Temuira");

        ArrayList<Personnage> personnagesActeur1 = new ArrayList(1);
        personnagesActeur1.add(perso1);
        personnagesActeur1.add(perso3);
        acteur1.setDuetPersonnages(personnagesActeur1);

        ArrayList<Acteur> acteursList1 = new ArrayList();
        acteursList1.add(acteur1);
        film1.setActeurs(acteursList1);

        ArrayList<Acteur> acteursList2 = new ArrayList();
        acteursList2.add(acteur2);
        acteursList2.add(acteur3);

        ArrayList<Personnage> personnagesActeur2 = new ArrayList(1);
        personnagesActeur2.add(perso4);
        acteur2.setDuetPersonnages(personnagesActeur2);

        ArrayList<Personnage> personnagesActeur3 = new ArrayList(1);
        personnagesActeur3.add(perso2);
        acteur3.setDuetPersonnages(personnagesActeur3);

        toString(Prelogie);

        int k = 1;
        for (Personnage Personnage : Personnages) {
            System.out.println("\n [Personnage " + k + "]" + Personnage.toString());
            k++;
        }

        System.out.println("\n L'acteur " + acteur1.nom + " " + acteur1.prenom + " joue "
                + acteur1.getNombrePersonnages() + " personnages");

        Boolean avant = film1.isBefore("1995");
        System.out.println("\n Star Wars 1 est-il avant 1995 : " + avant);

        System.out.println(" \n \n Liste avant l'ordre Chronologique :\n");

        list_actor(acteursList2);

        film2.tri();

        System.out.println(" \n \n Liste apres l'ordre Chronologique : \n");
        list_actor(acteursList2);

    }

    public static void list_actor(ArrayList<Acteur> List) {
        int y = 1;

        for (Acteur Acteur : List) {
            System.out.println("[Acteur " + y + "]" + Acteur.toString());
            y++;
        }
    }

    public static void toString(ArrayList<Film> Trilogie) {
        int y = 1;
        for (Film Film : Trilogie) {
            System.out.println("[Film " + y + "]" + Film.toString());
            y++;
        }

    }

}
