import java.util.ArrayList;

public class Wallet {
    private ArrayList<USD> currencies;

    public Wallet(){
        currencies = new ArrayList<>(2);
        currencies.add(new USD());
        currencies.add(new C2D());

        new USD().sub(new C2D());

    }

    public void add(USD curr){
        for(USD currency: currencies){
            currency.add(curr);
        }
    }

    public void sub(USD curr){
        for(USD currency: currencies){
            currency.sub(curr);
        }
    }

    public int compare(USD usd){
        for(USD currency: currencies){
            int val = currency.compareTo(usd);
            if(val > -2){
                return val;
            }
        }
        return -2;
    }

    public void printInfo(){
        for(USD currency: currencies){
            currency.printInfo();
        }
    }


}
