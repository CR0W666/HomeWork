import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Fuel {
    
    public static void main(String[] args) throws IOException{
            
            BufferedReader reader;

            try {

                reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\Desktop\\skola\\prg\\POP\\aoc2019\\day 1\\input.txt"));
                String line = reader.readLine();	
                int finalFuel = 0;
                double massToFuel;

                while (line != null) {

                    massToFuel = Integer.parseInt(line);
                    massToFuel = Math.floor(massToFuel/3) - 2;
                    finalFuel += massToFuel;
                    //System.out.println(massToFuel);
                    line = reader.readLine();
                }

                reader.close();
                System.out.println(finalFuel);
                
            } catch (IOException e) {

                e.printStackTrace();

            }
        
    }
}