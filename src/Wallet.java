import java.util.ArrayList;

public class Wallet {
    private ArrayList<USD> currencies;

    public Wallet(){
        currencies = new ArrayList<>(2);
        currencies.add(new USD());
        currencies.add(new C2D());

    }

    /**
     * Adds curr to its specific currency in the wallet
     * @param curr USD to add
     */
    public void add(USD curr){

        for(USD currency: currencies){
            currency.add(curr);//if currencies don't match, curr doesn't get added
        }
    }

    /**
     * Subtracts curr from its currency in the wallet
     * @param curr USD to subtract
     */
    public void sub(USD curr){
        for(USD currency: currencies){
            currency.sub(curr);
        }
    }

    /**
     * Compares usd to its given currency
     *  -2 = usd's currency (name) is not in the array
     *  -1 =  wallet curr is less than usd
     *  0 = they are the same value
     *  1 = wallet curr is greater than usd
     * @param usd
     * @return
     */
    public int compare(USD usd){
        for(USD currency: currencies){
            int val = currency.compareTo(usd);
            if(val > -2){ // -2= not same currency,
                return val;
            }
        }
        return -2;
    }

    /**
     * Call's currency's specific printInfo method
     */
    public void printInfo(){
        for(USD currency: currencies){
            currency.printInfo();
        }
    }


}
