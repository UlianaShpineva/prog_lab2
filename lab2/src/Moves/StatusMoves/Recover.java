package Moves.StatusMoves;

import ru.ifmo.se.pokemon.*;

public class Recover extends StatusMove {
    public Recover() {
        super(Type.NORMAL, 0, 0);
    }
    @Override
    protected boolean checkAccuracy(Pokemon att, Pokemon def){
        return true;
    }
    @Override
    protected void applySelfEffects(Pokemon p){
        double hp_now = p.getHP();
        double max_hp = p.getStat(Stat.HP);
        double new_hp = hp_now + 0.5 * max_hp;
        if (new_hp > max_hp) {
            p.setMod(Stat.HP, (int) max_hp);
        } else {
            p.setMod(Stat.HP, (int) new_hp);
        }
    }
    @Override
    protected String describe(){
        return "применяет Recover";
    }
}
