package Moves.StatusMoves;

import ru.ifmo.se.pokemon.*;

public class Tickle extends StatusMove {
    public Tickle() {
        super(Type.NORMAL, 0, 100);
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        p.setMod(Stat.ATTACK, -1);
        p.setMod(Stat.DEFENSE, -1);
    }
    @Override
    protected String describe(){
        return "применяет Tickle";
    }
}
