package lab4;

public final class Neznayka extends Human {
    public Neznayka(String name) {
        super(name);
    }


    @Override
    public void memorise(String s, Integer i) throws OutOfMemoryError{
        class OutOfHumanMemoryError extends Error{
            public OutOfHumanMemoryError(String text) {
                super(text);
            }
        }
        if (i > 999) {
            throw new OutOfHumanMemoryError("Neznayka doesn't have enough memory");
        }
        super.memorise(s, i);
    }

    public void checkSomeone(Human human){
        if(human.dieWithoutFood(this.getMemory("days_for_one"))){
            System.out.println(this.toString() + " made sure that " + human.toString() + " will die without food");
        } else {
            System.out.println(this.toString() + " made sure that " + human.toString() + " won't die without food");
        }
    }
}
