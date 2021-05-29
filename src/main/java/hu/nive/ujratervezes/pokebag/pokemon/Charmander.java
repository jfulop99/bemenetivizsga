package hu.nive.ujratervezes.pokebag.pokemon;

public class Charmander extends Pokemon {
    public Charmander() {
        super(8, "Charmander");
    }

    public Charmander(String name) {
        super(8, name);
    }

    @Override
    public String speak() {
        return "Char-char";
    }
}
