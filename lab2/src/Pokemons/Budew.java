package Pokemons;

import Moves.SpecialMoves.*;
import Moves.StatusMoves.*;
import ru.ifmo.se.pokemon.*;

public class Budew extends Pokemon {
    public Budew(String name, int level) {
        super(name, level);
        setType(Type.GRASS, Type.POISON);
        setStats(40, 30, 35, 50, 70, 55);
        this.addMove(new ShadowBall());
        this.addMove(new Confide());
    }
}
