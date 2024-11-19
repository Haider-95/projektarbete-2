package movement;

public class Bedroom extends Room {
    public Bedroom() {
        super ("Bedroom");
    }
    @Override
    public void enter(){
        System.out.println("There is no one here and nothing to do");
    }

    @Override
    public boolean roomCompletion() {
        return true;
    }
}
