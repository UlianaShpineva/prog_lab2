package Moves.StatusMoves;

import ru.ifmo.se.pokemon.*;

public class GrassWhistle extends StatusMove {
    public GrassWhistle() {
        super(Type.GRASS, 0, 55);
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        Effect eff = new Effect().condition(Status.SLEEP);
        p.addEffect(eff);
    }
    @Override
    protected String describe(){
        return "применяет Grass Whistle";
    }
}
