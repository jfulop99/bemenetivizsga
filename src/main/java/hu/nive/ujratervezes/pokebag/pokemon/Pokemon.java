package hu.nive.ujratervezes.pokebag.pokemon;

public abstract class Pokemon {
    private int health;
    private int strength;
    private String name;

    public Pokemon(int strength, String name) {
        this.strength = strength;
        this.name = name;
        health = 10;
    }

    public abstract String speak();

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

    public void decreaseHealth() {
        health -= 1;
    }
}
