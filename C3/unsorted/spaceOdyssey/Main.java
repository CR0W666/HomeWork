import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Main {
    static double personMass;
    static int sShip;
    static int sPlanet;
    
    public static void main(String[] args) {
        

        Planet Saturn = new Planet("Saturn", 1498.2, 10.4, -228);
        Planet Uranus = new Planet("Uranus", 2920.6, 8.8, 225);
        Planet Mars = new Planet("Mars", 321.05, 3.7, -80);
        Planet Jupiter = new Planet("Jupiter", 927.3, 24.79, 145);
        Planet Venus = new Planet("Venus", 185.67, 8.9, 462);

        SpaceShip Enterprise = new SpaceShip("Enterprise", 5000, 10000);
        SpaceShip Hope = new SpaceShip("Hope", 2500, 1000);
        SpaceShip Basic = new SpaceShip("Basic", 500, 100);

        
        SpaceShip selectedShip = Basic;
        Planet selectedPlanet = Mars;

        System.out.println("GOOD DAY(OR NIGHT), WELCOME TO SPACE TAXI. \nINPUT YOUR WEIGHT IN KGS(on Earth): ");
        input("weight");
        System.out.println("--------------\nSELECT YOUR SPACESHIP: \n1. Enterprise | Range & speed: " + Enterprise.getRange() + "Mkm | " + Enterprise.getSpeed() 
                + "Mkm/s\n2. Hope       | Range & speed: " + Hope.getRange() + "Mkm | " + Hope.getSpeed() + " Mkm/s\n3. Basic      | Range & speed: " + Basic.getRange() + " Mkm | " + Basic.getSpeed()
                + "  Mkm/s\n--------------\nRange is set in millions of kms");

        input("ship");  

        System.out.println("--------------\nSELECT YOUR PLANETARY DESTINATION: \n1. Venus   | Distance: "
                + Venus.getDist() + " Mkm\n2. Mars    | Distance: " + Mars.getDist() + " Mkm\n3. Jupiter | Distance: "
                + Jupiter.getDist() + "  Mkm\n4. Saturn  | Distance: " + Saturn.getDist() + " Mkm\n5. Uranus  | Distance: "
                + Uranus.getDist() + " Mkm\n--------------\nDistance is in millions of kms and is measured from the Earth");

        input("planet");

        switch (sShip) {
        case 1:

            selectedShip = Enterprise;
            System.out.println("You selected ship:   " + selectedShip.getName());
            break;
        case 2:

            selectedShip = Hope;
            System.out.println("You selected ship:   " + selectedShip.getName());
            break;
        case 3:
            selectedShip = Basic;
            System.out.println("You selected ship:   " + selectedShip.getName());
            break;

        default:
            System.out.println("wtf");
            break;
        }

        switch (sPlanet) {
        case 1:
            selectedPlanet = Venus;
            System.out.println("You selected planet: " + selectedPlanet.getName());
            break;
        case 2:
            selectedPlanet = Mars;
            System.out.println("You selected planet: " + selectedPlanet.getName());
            break;
        case 3:
            selectedPlanet = Jupiter;
            System.out.println("You selected planet: " + selectedPlanet.getName());
            break;
        case 4:
            selectedPlanet = Saturn;
            System.out.println("You selected planet: " + selectedPlanet.getName());
            break;
        case 5:
            selectedPlanet = Uranus;
            System.out.println("You selected planet: " + selectedPlanet.getName());
            break;

        default:
            System.out.println("wtf");
            break;
        }

        if (rangeCheck(selectedShip, selectedPlanet)) {

            System.out.println("estimated travel time: " + travelTime(selectedShip, selectedPlanet) + " seconds");
            System.out.println("Your weight on the planet: " + newWeightOnPlanet(personMass, selectedPlanet) + "kg");
            System.out.println("The temperature of the planet is: " + selectedPlanet.getTemp() + " Celsius");
        } else {
            System.out.println("Ship wont reach");
        }

    }

    public static boolean rangeCheck(SpaceShip selectedShip, Planet selectedPlanet) {
        if (selectedShip.getRange() < selectedPlanet.getDist()) {
            return false;
        } else {
            return true;
        }
    }

    public static double travelTime(SpaceShip selectedShip, Planet selectedPlanet) {
        return selectedPlanet.getDist() / selectedShip.getSpeed();
    }

    public static double newWeightOnPlanet(double personMass, Planet selectedPlanet) {
        return (personMass / 9.81) * selectedPlanet.getGrav();
    }

    public static void input(String type) {
        
        Scanner sc = new Scanner(System.in);
        switch (type) {
            case "weight":
                
                try {

                    do {

                        personMass = sc.nextDouble();

                    } while (personMass <= 0.0 || personMass > 200.0);
                    
                } catch (InputMismatchException e) {
                    System.err.println("input a valid number");
                    personMass = 0.0;
                    sc.reset();
                    input("weight");
                } catch (NoSuchElementException ee) {
                    sc.reset();
                }
                sc.reset();
                break;
            case "ship":
               
                try {
                    do {
                        
                        sShip = sc.nextInt();
                        
                    } while(sShip > 3 || sShip < 1);
                } catch (InputMismatchException e) {
                    System.err.println("input a valid number");
                    sShip = 0;
                    sc.reset();
                    input("ship");
                } catch (NoSuchElementException ee) {
                    sc.reset();
                }
                sc.reset();
                break;
            case "planet":
                
                try {
                    do {
                        
                        sPlanet = sc.nextInt();
                        
                        
                    } while(sPlanet > 5 || sPlanet < 1);
                } catch (InputMismatchException e) {
                    System.err.println("input a valid number");
                    sPlanet = 0;
                    sc.reset();
                    input("planet");

                } catch (NoSuchElementException ee) {
                    sc.reset();
                }
                sc.close();
                break;
            
            default:
                System.err.println("invalid type");
                break;
        }
    }
}