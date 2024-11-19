package movement;

import java.util.Scanner;
import Model.Burglar;
import Model.Resident;


public class Game {
    private final Hallway hallway;
    private final Office office;
    private final Bedroom bedroom;
    private final Kitchen kitchen;

    private boolean running = true;
    private boolean hasEnteredRoom = false;
    private final DirectionHandler directionHandler;
    private final Scanner scanner;
    private final Resident resident;
    private final Burglar burglar;


    public Game() {
        scanner = new Scanner(System.in);

        resident = new Resident("Resident", 12, 3);
        burglar = new Burglar("Burglar", 12, 4);
        directionHandler = new DirectionHandler();

        kitchen = new Kitchen(resident,scanner);
        office = new Office(scanner,burglar);
        hallway = new Hallway(resident, burglar,scanner);
        bedroom = new Bedroom();
    }

    public void start() {
        System.out.println("Starting the game!\n");
        System.out.println("Good Evening!\nYou wake up after a nap on the couch in the living room to some strange sounds in the hallway!!");

        while (running && resident.isConscious()) {
            if (hasEnteredRoom) {
                System.out.print("Do you want to go back or exit the game\n");
            } else {
                System.out.println("Choose which room you want to go to: Kitchen,Hallway,Bedroom,Office or exit the game");
            }

            String roomChoice = scanner.nextLine().toLowerCase().trim();

            switch (roomChoice) {
                case "kitchen":
                    directionHandler.moveToKitchen();
                    kitchen.enter();
                    if (kitchen.roomCompletion()){
                        System.out.println("You have done your task in the kitchen\n");
                    }
                    hasEnteredRoom = true;
                    break;
                case "hallway":
                    hallway.enter();
                    directionHandler.moveToHallway();
                    if (hallway.roomCompletion()){
                        System.out.println("You have done your task in the hallway\n");
                    }
                    hasEnteredRoom = true;
                    break;
                case "bedroom":
                    bedroom.enter();
                    directionHandler.moveToBedroom();
                    hasEnteredRoom = true;
                    break;
                case "office":
                    office.enter();
                    directionHandler.moveToOffice();
                    if (office.roomCompletion()){
                        System.out.println("You have finished the game succefully =D");
                        running = false;
                    }
                    hasEnteredRoom = true;
                    break;
                case "back":
                    if (hasEnteredRoom) {
                        directionHandler.moveBack();
                        hasEnteredRoom = false;
                    } else {
                        System.out.println("You can't go back yet because you haven't left the Living Room.");
                    }
                    continue;

                case "exit":
                    System.out.println("Thank you for playing! Exiting the game");
                    running = false;
                    break;
                default:
                    System.out.println("invalid input, try again");
                    break;

            }
        }
        scanner.close();
    }
}