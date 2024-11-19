package Model;

public class Resident extends Entity {
    public Resident(String role, int health, int damage) {
        super(role, health, damage);
    }

    public void addDamage() {
        this.damage += 3;

    }
}
