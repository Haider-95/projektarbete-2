package movement;

public class DirectionHandler {
    private int x;
    private int y;

    public DirectionHandler() {
        this.x = 0;
        this.y = 0;
        //starting pos
    }

    private boolean isAtstartPosition(){
        return  x==0 && y==0;
    }

    public void moveToKitchen() {
        if (isAtstartPosition()) {
            this.y++;
        } else {
            System.out.println("You can only move back from here\n ");
            return;
        }
    }

    public void moveToBedroom() {
        if (isAtstartPosition()) {
            this.y--;
        } else {
            System.out.println("You can only move back from here\n ");
            return;
        }
    }

    public void moveToHallway() {
        if (isAtstartPosition()) {
            this.x++;
        } else {
            System.out.println("You can only move back fom here\n ");
            return;
        }
    }

    public void moveToOffice() {
        if (isAtstartPosition()) {
            this.x--;
        } else {
            System.out.println("You can only move back from here\n ");
            return;

        }

    }  public void moveBack () {
        x = 0;
        y = 0;
        System.out.println("You have entered the livingroom");
    }
}