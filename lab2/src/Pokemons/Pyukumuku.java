package Pokemons;

import Moves.StatusMoves.*;
import ru.ifmo.se.pokemon.*;

public class Pyukumuku extends Pokemon {
    public Pyukumuku(String name, int level) {
        super(name, level);
        this.setType(Type.WATER);
        this.setStats(55, 60, 130, 30, 130, 5);
        this.addMove(new Tickle());
        this.addMove(new Recover());
        this.addMove(new Harden());
        this.addMove(new DoubleTeam());
    }
}
