package Oving_8;

public final class Person {
    private final String fName;
    private final String sName;
    private final int bDay;

    public Person(String fName, String sName, int bDay) {
        this.fName = fName;
        this.sName = sName;
        this.bDay = bDay;
    }

    public String getfName() {
        return fName;
    }

    public String getsName() {
        return sName;
    }

    public int getbDay() {
        return bDay;
    }
}
