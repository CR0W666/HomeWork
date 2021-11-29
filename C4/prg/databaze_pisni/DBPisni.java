package databaze_pisni;

import java.util.Scanner;

public class DBPisni {
    /*
     * Napište aplikaci, která na vstupu dostane počet písní a poté pro každou píseň dostane
     * interpreta, název a délku ve vteřinách. Program si tyto písně uloží.
     * 
     * Poté nabídne uživateli možnost 3 operací: 1) průměrnou délku písniček pro interpreta
     * (uživatel zadá jméno interpreta, pro kterého chce průměr) 2) počet písní pro interpreta
     * (uživatel zadá jméno interpreta, pro kterého chce počet písní) 3) počet písní, které obsahují
     * určitou frázi (uživatel tuto frázi zadá)
     * 
     * - Uživatele varujte, pokud si vybere neznámou operaci, program ale můžete ukončit. - Program
     * by neměl nikdy dělit 0. - S inputy počítejte, že jsou vždy validní (délky budou čísla). -
     * Každou píseň reprezentujte třídou. - Každou operaci proveďtě v nové metodě.
     */
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final Song[] songs = insertSongs(sc); // initializes the database of songs based on user
                                              // input
        final String choiceInfo = """
                ---------------------------\"""
                Zadejte jakou operaci chcete provest.\"""
                1. Prumerna delka pisne interpreta\"""
                2. Pocet pisni interpreta\"""
                3. Pocet pisni obsahujici frazi\"""
                "END". konec
                """;
                
        // Main loop
        String choice;
        while (true) {
            choice = inputHandler(sc, choiceInfo, true);
            switch (choice.toUpperCase()) {
                case "1":
                    getAvgSongLengthOfAuthor(songs, sc);
                    break;
                case "2":
                    getNumOfSongsOfAuthor(songs, sc);
                    break;
                case "3":
                    getNumOfSongsContainingWord(songs, sc);
                    break;
                case "END":
                    System.out.println("Ukoncuji program");
                    exit(sc);
                    break;
                default:
                    if (invalidChoice(sc))
                        exit(sc);
                    break;
            }

        }

    }

    // User inputs songs and their info, returns array of songs
    public static Song[] insertSongs(Scanner sc) {

        final int numOfSongs =
                Integer.parseInt(inputHandler(sc, "Kolik chcete zadat pisni do databaze?", false));
        Song[] songs = new Song[numOfSongs];

        String author;
        String name;
        double length;
        for (int i = 0; i < numOfSongs; i++) {

            System.out.println("Zadejte nazev interpreta");
            author = sc.nextLine();

            System.out.println("Zadejte nazev pisnicky");
            name = sc.nextLine();

            System.out.println("Zadejte delku pisnicky v sekundach");
            length = Double.valueOf(sc.nextLine());

            songs[i] = new Song(name, author, length);
        }

        return songs;
    }

    // returns the average length of songs of desired author
    public static void getAvgSongLengthOfAuthor(Song[] songs, Scanner sc) {

        final String author = inputHandler(sc, "Zadejte nazev autora.", true);

        double totalLength = 0;
        int numOfSongs = 0;
        for (Song song : songs) {
            // Possible wrong positives due to Eminem and eMinem converting into EMINEM.
            // Despite being different, I dont think this would be a problem in reality
            if (song.getAuthor().toUpperCase().equals(author)) {
                totalLength += song.getLength();
                numOfSongs++;
            }
        }
        final double expression = (numOfSongs == 0) ? 0 : (totalLength / numOfSongs);
        final String truthy = "Prumerna delka pisnicek autora " + author + ": " + expression;
        final String falsy = "Neznamy autor.";
        messageHandler(truthy, falsy, numOfSongs);
    }

    // returns the number of songs of desired author
    public static void getNumOfSongsOfAuthor(Song[] songs, Scanner sc) {

        final String author = inputHandler(sc, "Zadejte nazev autora.", true);
        int numOfSongs = 0;

        // Oneliner, still easy to read.
        // Searches for songs made by author, increments int for every hit.
        // Same problem as elsewhere with .toUpperCase() making possible wrong positives
        for (Song song : songs)
            if (song.getAuthor().toUpperCase().equals(author))
                numOfSongs++;

        final String truthy = "Pocet pisnicek autora " + author + ": " + numOfSongs;
        final String falsy = "Neznamy autor.";
        messageHandler(truthy, falsy, numOfSongs);
    }

    // returns the number of songs containing desired phrase
    public static void getNumOfSongsContainingWord(Song[] songs, Scanner sc) {

        final String word = inputHandler(sc, "Zadejte frazi, kterou hledate.", true);
        int numOfSongs = 0;

        // Oneliner, still easy to read.
        // Searches for songs including desired phrase, increments int for every hit.
        // .toUpperCase() could be wrong here if we take U & u as different chars.
        for (Song song : songs)
            if (song.getName().toUpperCase().contains(word))
                numOfSongs++;

        final String truthy = "Pocet pisnicek obsahujici \"" + word + "\": " + numOfSongs;
        final String falsy = "Zadny nazev pisne neobsahuje \"" + word + "\".";
        messageHandler(truthy, falsy, numOfSongs);

    }

    // easier result printing
    public static void messageHandler(String truthy, String falsy, int validationNumber) {
        if (validationNumber == 0)
            System.out.println(falsy);
        else
            System.out.println(truthy);
    }

    // easier input manipulation
    public static String inputHandler(Scanner sc, String message, boolean upperCase) {
        System.out.println(message);
        return (upperCase) ? sc.nextLine().toUpperCase() : sc.nextLine();
    }

    public static boolean invalidChoice(Scanner sc) {

        final String message = "Neplatna funkce, chcete program ukoncit? Y/N";

        return inputHandler(sc, message, true).equals("Y");

    }

    public static void exit(Scanner sc) {
        sc.close();
        System.exit(0);
    }
}
