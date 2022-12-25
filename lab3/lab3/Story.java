package lab3;

public class Story {
    private final Neznayka neznayka;

    public Story() {
        neznayka = new Neznayka("Neznayka");
    }

    public void go() {
        neznayka.memorise("days", 10);
        neznayka.memorise("people", 48);
        neznayka.memorise("days_in_month", 30);
        neznayka.memorise("days_in_year", neznayka.getMemory("days_in_month") * (Months.DECEMBER.ordinal() + 1));
        neznayka.multiplication(neznayka.getMemory("days"), neznayka.getMemory("people"));
        neznayka.divisionToYears(neznayka.getMemory("days_for_one"), neznayka.getMemory("days_in_year"), neznayka.getMemory("days_in_month"));
    }
}
