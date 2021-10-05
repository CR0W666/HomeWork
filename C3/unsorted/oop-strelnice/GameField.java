/**
 * GameField
 */
public class GameField {
    int length, height;
    String model;
    String[][] field; 
    public GameField(int height, int length, String model) {
        this.length = length;
        this.height = height;
        this.model = model;
        this.field = new String[height+1][length+1];
    }

    public String[][] generateField() {

        for (int i = 0; i < height; i++) {
            
            for (int y = 0; y < length; y++) {
                
                this.field[i][y] = model;
            }
        }
        

        return field;
    }

    public void printField() {

        for (int i = 0; i < height; i++) {
            System.out.println("\n");
            for(int y = 0; y < length; y++) {
                System.out.print(field[i][y]);
            }
        }

    }

    public String[][] resetField() {
        for (int i = 0; i < height; i++) {
            
            for (int y = 0; y < length; y++) {
                
                this.field[i][y] = "";
            }
        }

        return field;
    }
}