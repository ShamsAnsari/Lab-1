import java.util.ArrayList;

public class Wallet {
    private ArrayList<USD> wallet;

    public Wallet(){
        wallet = new ArrayList<>(2);
        wallet.add(new USD());
        wallet.add(new C2D());

        new USD().sub(new C2D());

    }

    public void add(USD curr){
        for(USD currency: wallet){
            currency.add(curr);
        }
    }

    public void sub(USD curr){
        for(USD currency: wallet){
            currency.sub(curr);
        }
    }

    public int compare(USD usd){
        for(USD currency: wallet){
            int val = currency.compareTo(usd);
            if(val > -2){
                return val;
            }
        }
        return -2;
    }

    public void printInfo(){
        for(USD currency: wallet){
            currency.printInfo();
        }
    }


}
