package lab4;

import java.util.ArrayList;
import java.util.HashMap;

public class Human extends Creature implements Memorisable, Countable {
    public Human(String name) {
        super(name);
    }

    private final HashMap<String, Integer> memory = new HashMap<>();
    public boolean status;

    public int getMemory(String s) {
        return memory.get(s);
    }

    public void memorise(String s, Integer i) {
        memory.put(s, i);
    }

    public void followTheAdvice(String advice){
        System.out.println(this.toString() + " follow the advice: " + advice);
    }

    public boolean dieWithoutFood(Integer days) {
        if (days < 480) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }

    public void goToMoonCave(Human human) {
        System.out.println(this.toString() + ", " + human.toString() + " went to moon cave");
    }

    public void loseBoot() {
        System.out.println(this.toString() + " lost space boot");
    }

    public void seeSuffering(String reason, ArrayList<Human> humans) {
        System.out.println(humans.toString() + " suffer from " + reason);
    }

    @Override
    public void multiplication(int days, int people) {
        memorise("days_for_one", days * people);
        System.out.println(this.toString() + " multiplied " + people + " by " + days);
        System.out.println(this.toString() + " got food for " + days * people + " days");
    }

    @Override
    public void divisionToYears(int days, int days_in_year, int days_in_month) {
        int years = days / days_in_year;
        int months = (days % days_in_year) / days_in_month;
        memorise("years_for_one", years);
        memorise("months_for_one", months);
        System.out.println(this.toString() + " divided " + days + " by " + days_in_year);
        System.out.println(this.toString() + " divided " + days % days_in_year + " by " + days_in_month);
        System.out.println(this.toString() + " got food for " + years + " year and " + months + " months");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
