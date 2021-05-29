package hu.nive.ujratervezes.pokebag.pokemon;

public class Bulbasaur extends Pokemon {
    public Bulbasaur() {
        super(6, "Bulbasaur");
    }

    public Bulbasaur(String name) {
        super(6, name);
    }

    @Override
    public String speak() {
        return "Bulba-saur";
    }
}
