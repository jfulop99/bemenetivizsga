package hu.nive.ujratervezes.pokebag;

import hu.nive.ujratervezes.pokebag.pokemon.Pokemon;

import java.util.*;

public class Pokebag {

    private List<Pokemon> pokemonList;

    public Pokebag() {
            pokemonList = new ArrayList<>();
    }

    public int getNumberOfPokemons() {
        return pokemonList.size();
    }

    public void add(Pokemon pokemon) {
        if (pokemon == null) {
            throw new IllegalArgumentException("Wrong input!");
        }
        pokemonList.add(pokemon);
    }

    public Pokemon getByIndex(int index) {
        return pokemonList.get(index);
    }

    public Pokemon getStrongest() {
        return pokemonList.stream()
                .max(Comparator.comparing(Pokemon::getStrength))
                .orElseThrow(() -> new NoSuchElementException("List is empty!"));
    }

    public Pokemon fight(int firstFighter, int secondFighter) {
        if (firstFighter == secondFighter) {
            throw new IllegalArgumentException("Same warrior");
        }
        Pokemon winner;
        if (getByIndex(firstFighter).getStrength() > getByIndex(secondFighter).getStrength()) {
            winner = getByIndex(firstFighter);
            getByIndex(secondFighter).decreaseHealth();
        }
        else {
            winner = getByIndex(secondFighter);
            getByIndex(firstFighter).decreaseHealth();
        }
        System.out.println(winner.speak());
        return winner;
    }
}
