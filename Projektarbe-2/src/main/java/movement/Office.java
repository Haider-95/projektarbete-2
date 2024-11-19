package movement;

import java.util.Scanner;
import Model.Burglar;

public class Office extends Room {
    private Scanner scanner;
    private Burglar burglar;
    private boolean callMade = false;

    public Office( Scanner scanner, Burglar burglar) {
        super("Office");
        this.scanner = scanner;
        this.burglar = burglar;
    }


    @Override
    public void enter() {
        if (!burglar.isConscious()) {
            while (true) {
                System.out.println("You enter the office and see a phone on the desk, you can call the police: yes or no ?");
                String callChoice = scanner.nextLine().toLowerCase().trim();

                if (callChoice.equals("yes")) {
                    callMade = true;
                    System.out.println("You call the police and they arrest the burglar!!");
                    System.out.println("Good job defeating the burglar");
                    break;
                } else if (callChoice.equals("no")) {
                    System.out.println("You didn't call the police");
                    break;
                }
                else {
                    System.out.println("Invalid input");
                }
            }
        }
        else {
            System.out.println("You have to defeat the burglar first before continuing the office");
        }
    }

    @Override
    public boolean roomCompletion() {
        return callMade;
    }
}
