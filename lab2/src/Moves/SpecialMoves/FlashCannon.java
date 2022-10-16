package Moves.SpecialMoves;

import ru.ifmo.se.pokemon.*;

public class FlashCannon extends SpecialMove {
    public FlashCannon() {
        super(Type.STEEL, 80, 100);
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        Effect eff = new Effect().chance(0.1).stat(Stat.SPECIAL_DEFENSE, -1);
        p.addEffect(eff);
    }
    @Override
    protected String describe(){
        return "применяет Flash Cannon";
    }
}
