package Model;

public abstract class Entity {
    private String role;
    private int health;
    protected int damage;

    public Entity(String role, int health, int damage) {
        this.role = role;
        this.health = health;
        this.damage = damage;
    }

    public String getRole() {
        return role;
    }

    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
    }

    public void punch(Entity toPunch) {
        toPunch.takeHit(this.damage);
        System.out.println(this.role + " attacked " + toPunch.getRole() + " for " + this.damage + " damage");
    }


    public void takeHit(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;

    }
    public boolean isConscious(){
        return this.health > 0;
    }
}
