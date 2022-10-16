import Pokemons.*;

import ru.ifmo.se.pokemon.*;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        b.addAlly(new Pyukumuku("a1", 1));
        b.addAlly(new Budew("a2", 1));
        b.addAlly(new Camerupt("a3", 1));
        b.addFoe(new Numel("b1", 1));
        b.addFoe(new Roselia("b2", 1));
        b.addFoe(new Roserade("b3", 1));
        b.go();
    }
}
