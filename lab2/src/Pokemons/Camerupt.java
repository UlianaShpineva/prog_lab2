package Pokemons;

import Moves.SpecialMoves.*;
import ru.ifmo.se.pokemon.*;

public class Camerupt extends Numel {
    public Camerupt(String name, int level) {
        super(name, level);
        setType(Type.FIRE, Type.GROUND);
        setStats(70, 100, 70, 105, 75, 40);
        this.addMove(new FlashCannon());
    }
}