import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

class AOC {

    public static void main(String[] args) {
        String path = "C:\\Users\\Admin\\Desktop\\skola\\HomeWork\\C4\\prg\\aoc2015\\DayThree\\input.txt";
        File input = new File(path);
        try (Scanner sc = new Scanner(input)) {
            char[] dirs = sc.nextLine().toCharArray();
            HashSet<Coordinate> uniqueVisited = new HashSet<>();

            Coordinate santa = new Coordinate(0,0);
            Coordinate roboSanta = new Coordinate(0,0);
            boolean robo = false;

            uniqueVisited.add(new Coordinate(santa.getCoords()));

            for(char dir : dirs) {
                if(robo) {
                    santa.move(dir);
                    uniqueVisited.add(new Coordinate(santa.getCoords()));
                } else {
                    roboSanta.move(dir);
                    uniqueVisited.add(new Coordinate(roboSanta.getCoords()));
                }
                robo = !robo;
                
            }
            System.out.println("Pohnuli jsme se: " + dirs.length);
            System.out.println("Unikatnich domu navstiveno: " + uniqueVisited.size());

        } catch (FileNotFoundException e) {
            System.out.println("Santa neexistuje, nikdo nedostal darky");
        }
        
    }


    
}

class Coordinate {
    int x = 0;
    int y = 0;
    
    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    Coordinate(int[] xy) {
        this.x = xy[0];
        this.y = xy[1];
    } 

    public int[] getCoords() {
        return new int[] {x, y};
    }

    public void move(char dir) {
             if(dir == '<') this.x--;
        else if(dir == '>') this.x++;
        else if(dir == '^') this.y++;
        else                this.y--;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;

        if (that == null || getClass() != that.getClass()) return false;

        Coordinate coordinate = (Coordinate) that;
        return Arrays.equals(this.getCoords(), coordinate.getCoords());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }


    
}