public class USD {
    private int dollars;
    private int cents;
    private String name;

    public USD(){

    }

    public USD(int dollars, int cents, String name){
        setDollars(dollars);
        setCents(cents);
        setName(name);
    }

    public USD(USD copy){
        setDollars(copy.getDollars());
        setCents(copy.getCents());
        setName(copy.getName());
    }

    public



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
}
