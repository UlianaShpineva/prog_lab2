package Pokemons;

import Moves.StatusMoves.Confide;
import Moves.StatusMoves.*;
import ru.ifmo.se.pokemon.*;

public class Roselia extends Budew {
    public Roselia(String name, int level) {
        super(name, level);
        setType(Type.GRASS, Type.POISON);
        setStats(50, 60, 45, 100, 80, 65);
        this.addMove(new GrassWhistle());
    }
}
