package movement;


import Model.Resident;
import java.util.Scanner;


public class Kitchen extends Room {
    private boolean fryingPanFound = false;
    private final Resident resident;
    private Scanner scanner;

    public Kitchen(Resident resident, Scanner scanner) {
        super("kitchen");
        this.resident = resident;
        this.scanner = scanner;
    }

    @Override
    public void enter() {
        if (!roomCompletion()) {
            System.out.println("As you enter the kitchen you see a frying pan on the stove. Do you want to pick it up?");
            while (true) {
                System.out.println("yes or no ?");
                String fryingPanChoice = scanner.nextLine().toLowerCase().trim();

                if (fryingPanChoice.equals("yes")) {
                    System.out.println("You picked up the frying pan");
                    resident.addDamage();
                    fryingPanFound = true;
                    break;
                } else if (fryingPanChoice.equals("no")) {
                    System.out.println("You left the frying pan....");
                    fryingPanFound = false;
                    break;
                } else {
                    System.out.println("Invalid choice");
                }
            }
        }
        else {
            System.out.println("There is nothing here");
        }
    }
    @Override
    public boolean roomCompletion() {
        return fryingPanFound;
    }
}
