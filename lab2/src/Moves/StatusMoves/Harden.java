package Moves.StatusMoves;

import ru.ifmo.se.pokemon.*;

public class Harden extends StatusMove {
    public Harden() {
        super(Type.NORMAL, 0, 0);
    }
    @Override
    protected boolean checkAccuracy(Pokemon att, Pokemon def){
        return true;
    }
    @Override
    protected void applySelfEffects(Pokemon p){
        p.setMod(Stat.DEFENSE, 1);
    }
    @Override
    protected String describe(){
        return "применяет Harden";
    }
}
