package lab3;

public class Story {
    private final Neznayka neznayka;
    private final Rat rat1;
    private final Rat rat2;

    public Story() {
        neznayka = new Neznayka("Neznayka");
        rat1 = new Rat("Rat1");
        rat2 = new Rat("Rat2");
    }

    public void go() {
        rat1.run();
        rat1.stop();
        rat1.glance(neznayka);
        rat2.run();
        rat2.moveNose();
        neznayka.memorise("days", 10);
        neznayka.memorise("people", 48);
        neznayka.memorise("days_in_month", 30);
        neznayka.memorise("days_in_year", neznayka.getMemory("days_in_month") * (Months.DECEMBER.ordinal() + 1));
        neznayka.multiplication(neznayka.getMemory("days"), neznayka.getMemory("people"));
        neznayka.divisionToYears(neznayka.getMemory("days_for_one"), neznayka.getMemory("days_in_year"), neznayka.getMemory("days_in_month"));
    }
}
