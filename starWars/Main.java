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

        toString(Prelogie);

        Personnage perso1 = new Personnage("Vador", "Dark");
        Personnage perso2 = new Personnage("Skywalker", "Luke");

        ArrayList<Personnage> Personnages = new ArrayList();

        Personnages.add(perso1);
        Personnages.add(perso2);

        int k = 1;
        for (Personnage Personnage : Personnages) {
            System.out.println("[Personnage " + k + "]" + Personnage.toString());
            k++;
        }

    }

    public static void toString(ArrayList<Film> Prelogie) {
        int y = 1;
        for (Film Film : Prelogie) {
            System.out.println("[Film " + y + "]" + Film.toString());
            y++;
        }

    }

}
