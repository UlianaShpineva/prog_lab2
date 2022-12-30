package lab4;

import java.util.ArrayList;

public class Story {
    private final Rocket rocket;
    private final Rocket.Shelf shelf;
    private final Neznayka neznayka;
    private final Rat rat1;
    private final Rat rat2;
    private final Donut donut;
    private final ArrayList<Human> shorties;
    private final Human shorty;
    private final Time time;

    private static class Time{
        Time(){
        }
        public void timeAgo(){
            System.out.println("Some time ago:");
        }
    }
    public Story() {
        rocket = new Rocket("Rocket");
        neznayka = new Neznayka("Neznayka");
        rat1 = new Rat("Rat1");
        rat2 = new Rat("Rat2");
        donut = new Donut("Donut");
        shorty = new Human("some shorties");
        shorties = new ArrayList<Human>();
        shelf = rocket.new Shelf();
        time = new Time();
    }

    public void go(){
        try {
            rocket.addToRocket(rat1);
            rocket.addToRocket(rat2);
            rocket.addToRocket(neznayka);
            rocket.addToRocket(donut);
            rocket.addToRocket(neznayka);
        } catch (CreatureAlreadyInRocketException e){
            System.out.println(e.getMessage());
        }
        shorties.add(shorty);
        rat1.run();
        rat1.stop();
        rat1.glance(neznayka);
        rat2.run();
        rat2.moveNose();
        shelf.isLayableFor(neznayka);
        neznayka.seeSuffering("cold", shorties);
        neznayka.seeSuffering("cough", shorties);
        neznayka.seeSuffering("nightmares", shorties);

        new Advice(){
            @Override
            public void giveAdviceTo(Human human, String advice) {
                human.followTheAdvice(advice);
            }
        }.giveAdviceTo(neznayka, "lie still");

        try {
            neznayka.memorise("days", 1000);
        } catch (Exception e){

        }
        neznayka.memorise("days", 10);
        neznayka.memorise("people", 48);
        neznayka.memorise("days_in_month", 30);
        neznayka.memorise("days_in_year", neznayka.getMemory("days_in_month") * (Months.DECEMBER.ordinal() + 1));


        neznayka.multiplication(neznayka.getMemory("days"), neznayka.getMemory("people"));
        neznayka.divisionToYears(neznayka.getMemory("days_for_one"), neznayka.getMemory("days_in_year"), neznayka.getMemory("days_in_month"));
        neznayka.checkSomeone(donut);
        time.timeAgo();
        donut.goToMoonCave(neznayka);
        donut.loseBoot();
    }
}
