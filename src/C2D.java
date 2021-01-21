public class C2D extends USD{
    //1 USD = 1.36 C2D
    private double convFactor;

    public C2D(){
        this(0,0,"C2D", 1.36);

    }
    public C2D(int dollars, int cents, String name, double convFactor){
        super(dollars, cents, name);
        setConvFactor(convFactor);
    }

    public C2D convertToC2D(USD usd){
        if(isSameCurrency(usd)){
            return (C2D) usd;
        }
        int newTotal = (int)Math.round(usd.getTotalInCents()* getConvFactor());
        int dollars = newTotal / 100;
        int cents = newTotal % 100;
        return new C2D(dollars,cents, "C2D", getConvFactor());
    }

    public USD convertToUSD(C2D c2d){
        int newTotal = (int)Math.round(c2d.getTotalInCents()* 1/getConvFactor());
        int dollars = newTotal / 100;
        int cents = newTotal % 100;
        return new USD(dollars,cents, "USD");
    }

    public double getConvFactor() {
        return convFactor;
    }

    public void setConvFactor(double convFactor) {
        this.convFactor = convFactor;
    }
}
