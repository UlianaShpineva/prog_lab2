package Pokemons;

import Moves.StatusMoves.*;
import ru.ifmo.se.pokemon.*;

public class Roserade extends Roselia {
    public Roserade(String name, int level) {
        super(name, level);
        setType(Type.GRASS, Type.POISON);
        setStats(60, 70, 65, 125, 105, 90);
        this.addMove(new DoubleTeam());
    }
}
