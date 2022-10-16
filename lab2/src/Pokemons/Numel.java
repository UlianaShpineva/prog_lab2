package Pokemons;

import Moves.PhysicalMoves.*;
import Moves.StatusMoves.*;

import ru.ifmo.se.pokemon.*;

public class Numel extends Pokemon {
    public Numel(String name, int level) {
        super(name, level);
        setType(Type.FIRE, Type.GROUND);
        setStats(60, 60, 40, 65, 45, 35);
        this.addMove(new RockSlide());
        this.addMove(new FlameCharge());
        this.addMove(new Confide());
    }
}
