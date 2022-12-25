package lab4;

public enum Months {
    JANUARY("JANUARY"),
    FEBRUARY("FEBRUARY"),
    MARCH("MARCH"),
    APRIL("APRIL"),
    MAY("MAY"),
    JUNE("JUNE"),
    JULY("JULY"),
    AUGUST("AUGUST"),
    SEPTEMBER("SEPTEMBER"),
    OCTOBER("OCTOBER"),
    NOVEMBER("NOVEMBER"),
    DECEMBER("DECEMBER");
    private final String month;
    Months(String mon){
        this.month = mon;
    }
    public String getMonth(){
        return this.month;
    }
}

