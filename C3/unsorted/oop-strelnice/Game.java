import java.io.IOException;
import java.util.Scanner;

/**
 * Game
 */
public class Game {

    public static void main(String[] args) {
        int fieldHeight = 4;
        int fieldLength = 50;
        int targetHeight = 3;
        int win, loss, pocetKol, random;
        win = loss = pocetKol = random = 0;

        String[] targetModel = {" _", "|-|","|=|","\"^\""};
        Scanner sc = new Scanner(System.in);
        GameField gameField = new GameField(fieldHeight, fieldLength, " ");
        String[][] field = gameField.generateField();
        NumGenerator gen = new NumGenerator(0, 50);
        Target target = new Target(targetHeight, targetModel);
        Raketa raketa = new Raketa(0, 0, ">");

        pocetKol = pocetKol(sc);
        System.err.println(pocetKol);
        for (int i = 0; i < pocetKol; i++) {

            if(game(random, gen, targetHeight, target, field, gameField, raketa, sc)) {
                win++;
                System.out.println("round won: " + win);
            } else {
                loss++;
                System.out.println("round lost: " + loss);
            }

        }

        didWin(win, loss, pocetKol);

    }

    public static boolean game(int random, NumGenerator gen, int targetHeight, Target target, String[][]field, GameField gameField, Raketa raketa, Scanner sc) {
        random = gen.generate();
        clear();
        
        for (int i = 0; i < targetHeight; i++) {
           field[i][random] = target.generateTarget(i); 
        }

        gameField.printField();
        System.out.println("\nJak daleko je datove centrum? (cislo)");
        raketa.setDolet(sc.nextInt());
        
        raketa.vystrel();
        System.out.print(random);
        reset(gameField, target);
        if (didHit(raketa, random)) {
            return true;
        } else {
            return false;
        }


    }

    public static boolean didHit(Raketa raketa, int random) {

        if (raketa.getSpec("dolet") != random) {

            System.out.println("you missed");
            return false;

        } else {

            System.out.println("HIT!");
            return true;

        }
    }

    public static void didWin(int win, int loss, int pocetKol) {
        System.out.println("w: " + win + " | l: " + loss);
        if(win > loss) {
            if(win == pocetKol) {
                System.out.println("DOMINATION");
            } else {
                System.out.println("You have won");
            }
        } else {
            System.out.println("You have lost");
        }
    }

    public static int pocetKol(Scanner sc) {
        System.out.println("Kolik kol chcete hrát?");

        return sc.nextInt();

    }

    public static void reset(GameField gameField, Target target) {
        target.resetLayer();
        gameField.resetField();
        gameField.generateField();
    }

    public static void clear() {
        try {
            Thread.sleep(2000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
    
        } catch (IOException ee) {

        }
    }
}