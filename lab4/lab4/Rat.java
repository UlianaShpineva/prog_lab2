package lab4;

public class Rat extends Creature {
    public Rat(String name) {
        super(name);
    }

    public void run(){
        System.out.println(this.toString() + " run");
    }

    public void stop(){
        System.out.println(this.toString() + " stop");
    }

    public void glance(Human human){
        System.out.println(this.toString() + " glance at " + human.toString());
    }

    public void moveNose(){
        System.out.println(this.toString() + " move it's nose");
    }
}
