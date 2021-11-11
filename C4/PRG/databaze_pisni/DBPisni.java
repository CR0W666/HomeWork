package databaze_pisni;

import java.util.Scanner;

public class DBPisni {
    /*
    Napište aplikaci, která na vstupu dostane počet písní a poté pro každou píseň dostane interpreta, název a délku ve vteřinách.
    Program si tyto písně uloží.

    Poté nabídne uživateli možnost 3 operací:
    průměrnou délku písniček pro interpreta (uživatel zadá jméno interpreta, pro kterého chce průměr)
    počet písní pro interpreta (uživatel zadá jméno interpreta, pro kterého chce počet písní)
    počet písní, které obsahují určitou frázi (uživatel tuto frázi zadá)
    Uživatele varujte, pokud si vybere neznámou operaci, program ale můžete ukončit.
    Program by neměl nikdy dělit 0.
    S inputy počítejte, že jsou vždy validní (délky budou čísla).
    Každou píseň reprezentujte třídou.
    Každou operaci proveďtě v nové metodě.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Song[] songs = insertSongs(sc);

        while (sc.hasNext()) {
            String choice = choice(sc);
            switch(choice) {
                case"1":
                    getAvgSongLengthOfAuthor(songs, sc);
                    break;
                case"2":
                    getNumOfSongsOfAuthor(songs, sc);
                    break;
                case"3":
                    getNumOfSongsContainingWord(songs, sc);
                    break;
                default:
                    if(invalidChoice(sc)) System.exit(1);
                    break;
            }

        }
        
    }

    public static Song[] insertSongs(Scanner sc) {

        System.out.println("Kolik chcete zadat pisni do databaze?");
        int numOfSongs = sc.nextInt();

        Song[] songs = new Song[numOfSongs];
        String author;
        String name;
        double length;
        //sc.nextLine();
        for (int i = 0; i < numOfSongs; i++) {
            author = sc.nextLine();
            System.out.println("Zadejte nazev interpreta");
            author = sc.nextLine();
            System.out.println("Zadejte nazev pisnicky");
            name = sc.nextLine();
            System.out.println("Zadejte delku pisnicky v sekundach");
            length = sc.nextDouble();
            songs[i] = new Song(name, author, length);
        }

        return songs;
    }

    public static String choice(Scanner sc) {
        String choice;
        System.out.println("Zadejte jakou operaci chcete provest.\n1) Prumerna delka pisne interpreta\n2) Pocet pisni interpreta\n3) Pocet pisni obsahujici frazi\n\"END\") konec");
        choice = sc.nextLine();
        return choice;
    }

    public static void getAvgSongLengthOfAuthor(Song[] songs, Scanner sc) {
        System.out.println("Zadejte nazev autora.");
        String author = sc.nextLine();
        double totalLength = 0;
        int numOfSongs = 0;
        for(Song song : songs) {
            if(song.getAuthor().equals(author)) {
                totalLength += song.getLength();
                numOfSongs++;
            }
        }
        if(numOfSongs == 0) {
            System.out.println("Neznamy autor");
            return;
        }
        System.out.println("Prumerna delka pisnicek autora " + author + ": " + (totalLength/numOfSongs));
    }

    public static void getNumOfSongsOfAuthor(Song[] songs, Scanner sc) {
        System.out.println("Zadejte nazev autora.");
        String author = sc.nextLine();
        int numOfSongs = 0;
        for(Song song : songs) if(song.getAuthor().equals(author)) numOfSongs++;
        if(numOfSongs == 0) {
            System.out.println("Neznamy autor");
            return;
        }
        System.out.println("Pocet pisnicek autora " + author + ": " + numOfSongs);
    }

    public static void getNumOfSongsContainingWord(Song[] songs, Scanner sc) {
        System.out.println("Zadejte frazi, kterou hledate.");
        String word = sc.nextLine();
        int numOfSongs = 0;
        for(Song song : songs) if(song.getName().contains(word)) numOfSongs++;
        if(numOfSongs == 0) {
            System.out.println("Zadny nazev pisne neobsahuje " + word + ".");
            return;
        }
        System.out.println("Pocet pisnicek obsahujici " + word + ": " + numOfSongs);

    }

    public static boolean invalidChoice(Scanner sc) {
        System.out.println("Neplatna funkce, chcete program ukoncit? Y/N");
        if(sc.nextLine().equals("Y")) return true;
        else return false;
    }
}
