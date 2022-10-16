package Moves.PhysicalMoves;

import ru.ifmo.se.pokemon.*;

public class RockSlide extends PhysicalMove {
    public RockSlide() {
        super(Type.ROCK, 75, 90);
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        Effect eff = new Effect().chance(0.3);
        p.addEffect(eff);
        if(eff.success()) {
            Effect.flinch(p);
        }
    }
    @Override
    protected String describe(){
        return "применяет Rock Slide";
    }
}
