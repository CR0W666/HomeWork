import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Reciever.Reciever;
import Sender.Sender;

public class Mess {

    private static boolean isRunning = true;
    private static Sender sd;
    private static Reciever rc;

    public static void main(String[] args) throws IOException {

        if (args.length < 3) {
            howTo();
        }

        try {
            rc = new Reciever(Integer.parseInt(args[1]));
            sd = new Sender(args[0], args[2], Integer.parseInt(args[3]));
        } catch (InterruptedException e) {
            howTo();
        }

        // Read user input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("started. '\\exit' to quit.");

        while (isRunning) {
            String input = br.readLine();

            if (input.equals("\\exit")) {
                rc.stop();
                sd.stop();
                isRunning = false;
            } else {
                sd.sendMessage(input);
            }
        }
    }

    static void howTo() {
        System.out.println("how to use -> java Mess listening_port target_IP target_port");
        System.exit(1);
    }

}