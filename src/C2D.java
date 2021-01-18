public class C2D extends USD{
    private double convFactor = 1.36;

    public C2D(){

    }
    public C2D(int dollars, int cents, String name, double convFactor){
        super(dollars, cents, name);
        this.convFactor = convFactor;
    }

    public double getConvFactor() {
        return convFactor;
    }

    public void setConvFactor(double convFactor) {
        this.convFactor = convFactor;
    }
}
