import java.text.NumberFormat;

public class USD implements Comparable<USD> {

    private int dollars;
    private int cents;
    private String name;

    public USD() {
        this(0, 0, "USD");
    }

    public USD(int dollars, int cents, String name) {
        setDollars(dollars);
        setCents(cents);
        setName(name);
    }

    public USD(USD copy) {
        setDollars(copy.getDollars());
        setCents(copy.getCents());
        setName(copy.getName());
    }

    public void add(USD curr) {
        if (!isSameCurrency(curr)) {
            return;
        }
        int cents = (getCents() + curr.getCents()) % 100;
        int dollars = getDollars() + curr.getDollars() + (getCents() + curr.getCents()) / 100;
        setDollars(dollars);
        setCents(cents);
    }

    public void sub(USD curr) {
        if (!isSameCurrency(curr)) {
            return;
        }
        if (compareTo(curr) < 0) {
            return;
        }
        int myTotal = getTotalInCents();
        int currTotal = curr.getTotalInCents();
        int newVal = myTotal - currTotal;
        setCents(newVal % 100);
        setDollars(newVal / 100);

    }


    public boolean equals(USD curr) {
        return isSameCurrency(curr) && getDollars() == curr.getDollars() && getCents() == curr.getCents();
    }


    public int getDollars() {
        return dollars;
    }

    public void setDollars(int dollar) {
        this.dollars = dollar;
    }

    public int getCents() {
        return cents;
    }

    public void setCents(int cents) {
        this.cents = cents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.println("\t"+ getName() + ":  " + this);
    }


    protected int getTotalInCents() {
        return getCents() + getDollars() * 100;
    }

    protected double getTotalInDollars(){
        return getDollars() + getCents()/100.0;
    }

    protected boolean isSameCurrency(USD curr) {
        return getName().equals(curr.getName());
    }

    @Override
    public int compareTo(USD curr)  {
        if(!isSameCurrency(curr)){
            return -2;
        }
        if (getTotalInCents() < curr.getTotalInCents()) {
            return -1;
        }
        if (getTotalInCents() > curr.getTotalInCents()) {
            return 1;
        }
        return 0;
    }


    @Override
    public String toString() {
        return NumberFormat.getCurrencyInstance().format(getTotalInDollars());

    }
}
