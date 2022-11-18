import lab3.*;

public class Main {
    public static void main (String[] args) {
        Neznayka neznayka = new Neznayka("Neznayka");
        neznayka.memorise("days", 10);
        neznayka.memorise("people", 48);
        neznayka.memorise("days_in_month", 30);
        neznayka.memorise("days_in_year", neznayka.getMemory("days_in_month") * (Months.DECEMBER.ordinal() + 1));
        neznayka.multiplication(neznayka.getMemory("days"), neznayka.getMemory("people"));
        neznayka.DivisionToYears(neznayka.getMemory("days_for_one"), neznayka.getMemory("days_in_year"), neznayka.getMemory("days_in_month"));
    }
}
