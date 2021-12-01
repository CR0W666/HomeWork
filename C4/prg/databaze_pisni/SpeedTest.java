package C4.prg.databaze_pisni;

public class SpeedTest {
    static final String PRUMERNY_AUTOR = "prumerny autor";

    public static void main(String[] args) {
        long trials = 100000000;// Long.MAX_VALUE;
        Song[] songs = new Song[1];

        long startTime = System.nanoTime();
        martin(trials, songs);
        long endTime = System.nanoTime();

        System.out.println("Martin: " + (endTime - startTime));

        startTime = System.nanoTime();
        lukas(trials, songs);
        endTime = System.nanoTime();

        System.out.println("Lukas: " + (endTime - startTime));

        startTime = System.nanoTime();
        martin(trials, songs);
        endTime = System.nanoTime();

        System.out.println("Martin2: " + (endTime - startTime));


        startTime = System.nanoTime();
        lukas(trials, songs);
        endTime = System.nanoTime();

        System.out.println("Lukas2: " + (endTime - startTime));

        startTime = System.nanoTime();
        martin(trials, songs);
        endTime = System.nanoTime();

        System.out.println("Martin3: " + (endTime - startTime));

    }



    public static void martin(long trials, Song[] songs) {

        for (int i = 0; i < trials; i++) {

            // System.out.println("Zadejte nazev interpreta");
            final String author = PRUMERNY_AUTOR;

            // System.out.println("Zadejte nazev pisnicky");
            final String name = PRUMERNY_AUTOR;

            // System.out.println("Zadejte delku pisnicky v sekundach");
            final Double length = Double.valueOf("326");

            songs[0] = new Song(name, author, length);
        }
    }

    public static void lukas(long trials, Song[] songs) {
        String author;
        String name;
        Double length;
        for (int i = 0; i < trials; i++) {

            // System.out.println("Zadejte nazev interpreta");
            author = PRUMERNY_AUTOR;

            // System.out.println("Zadejte nazev pisnicky");
            name = PRUMERNY_AUTOR;

            // System.out.println("Zadejte delku pisnicky v sekundach");
            length = Double.valueOf("326");

            songs[0] = new Song(name, author, length);
        }
    }
}
