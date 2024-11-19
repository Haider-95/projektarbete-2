package movement;

import Model.Burglar;
import Model.Resident;
import java.util.Scanner;

public class Hallway extends Room {
    private Burglar burglar;
    private Resident resident;
    private Scanner scanner;

    public Hallway(Resident resident, Burglar burglar, Scanner scanner) {
        super("Hallway");
        this.scanner = scanner;
        this.resident = resident;
        this.burglar = burglar;
    }


    @Override
    public void enter() {
        if (burglar.isConscious()) {

            while (true) {
                System.out.println("You entered the Hallway\nYou see a burglar rummaging through your belongings, do you leave or fight?");
                String fightChoice = scanner.nextLine().toLowerCase().trim();

                if (fightChoice.equals("leave")) {
                    System.out.println("You discreetly leave without getting noticed");
                    break;
                } else if (fightChoice.equals("fight")) {
                    fight();
                    break;
                } else {
                    System.out.println("invalid input");
                }
            }
        } else {
            System.out.println("the burglar isn't conscious");
        }
    }

    private void fight() {
        System.out.println("The fight begins as you hit the burglar!!!!");
        while (resident.isConscious() && burglar.isConscious()) {
            System.out.println("You hit the burglar");
            resident.punch(burglar);
            if (!burglar.isConscious()) {
                System.out.println("the burglar falls unconscious");
                break;
            }
            System.out.println("The burglar hits back");
            burglar.punch(resident);
            if (!resident.isConscious()) {
                System.out.println("You have lost the fight and fall unconscious");
                System.out.println("Game over!");
                break;
            }
        }
    }
    @Override
    public boolean roomCompletion() {
        return !burglar.isConscious();
    }
}