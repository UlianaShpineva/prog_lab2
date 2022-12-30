package lab4;

public final class Neznayka extends Human {
    public Neznayka(String name) {
        super(name);
    }


    @Override
    public void memorise(String s, Integer i) {
        class IllegalMemoryArgumentException extends RuntimeException{
            public IllegalMemoryArgumentException(String message) {
                super(message);
            }
        }
        if (i <= 999) {
            super.memorise(s, i);
        } else {
            throw new IllegalMemoryArgumentException("Neznayka can't remember this number");
        }
    }

    public void checkSomeone(Human human){
        if(human.dieWithoutFood(this.getMemory("days_for_one"))){
            System.out.println(this.toString() + " made sure that " + human.toString() + " will die without food");
        } else {
            System.out.println(this.toString() + " made sure that " + human.toString() + " won't die without food");
        }
    }
}
