package hu.nive.ujratervezes.pokebag.pokemon;

public class Pikachu extends Pokemon {
    public Pikachu() {
        super(10, "Pikachu");
    }

    public Pikachu(String name) {
        super(10, name);
    }

    @Override
    public String speak() {
        return "Pika-pika";
    }
}
