package lab4;


import java.util.ArrayList;
import java.util.List;

public class Rocket {
    public class Shelf implements Layable {
        public Shelf() {

        }
        @Override
        public void isLayableFor(Human human){
            System.out.println(human.toString() + " lie down on shelf");
        }
    }
    private final String name;
    private final ArrayList<Creature> passengers = new ArrayList<Creature>();

    Rocket(String n){
        name = n;
    }
    public void addToRocket(Creature creature) throws CreatureAlreadyInRocketException{

        if(passengers.contains(creature)){
            throw new CreatureAlreadyInRocketException(creature.toString() + " is already in the rocket!");
        }
        passengers.add(creature);
    }


}
