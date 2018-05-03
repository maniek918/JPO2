package japplet;
public class SimEngine {
    private static double G=9.81f; // przyspieszenie ziemskie
    private double Masa; // masa
    private double K; // wspolczynnik sprezystosci
    private double C; // wspolczynnik tlumienia
    private double L; // dlugosc swobodna sprezyny
    private double X0; // polozenie punktu x zaczepienia sprezyny
    private double Y0; // polozenie punktu y zaczepienia sprezyny
    private double X0m; // polozenie poczatkowe x masy
    private double Y0m; // polozenie poczatkowe y masy
    private double Vxm; // predkosc x masy
    private double Vym; // predkosc y masy
    public double a;
    public double t;

    public void setMasa(float m)
    {
        Masa=m;
    }
    public void setK(float k)
    {
        K=k;
    }
    public void setC(float c)
    {
        C=c;
    }
    public void setL(float l)
    {
        L=l;
    }
    public void setX0(float x0)
    {
        X0=x0;
    }
    public void setY0(float y0)
    {
        Y0=y0;
    }
    public void setX0m(float x0m)
    {
        X0m=x0m;
    }
    public void setY0m(float y0m)
    {
        Y0m=y0m;
    }
    public void setVxm(float vxm)
    {
        Vxm=vxm;
    }
    public void setVym(float vym)
    {
        Vym=vym;
    }
    public void setG(float m)
    {
        Masa=m;
    }
    public double getG() {
        return G;
    }
    public double getMasa()
    {
        return Masa;
    }
    public double getK() {
        return K;
    }
    public double getC() {
        return C;
    }
    public double getL() {
        return L;
    }
    public double getX0() {
        return X0;
    }
    public double getY0() {
        return Y0;
    }
    public double getX0m() {
        return X0m;
    }
    public double getY0m() {
        return Y0m;
    }
    public double getVxm() {
        return Vxm;
    }
    public double getVym() {
        return Vym;
    }
    public Vector2D polozenie;
    public SimEngine(double Masa, double K, double C, double L, double X0, double Y0, double X0m, double Y0m)
    {
        this.Masa=Masa;
        this.K=K;
        this.C=C;
        this.L=L;
        this.X0=X0;
        this.Y0=Y0;
        this.X0m=X0m;
        this.Y0m=Y0m;
        this.Vym=0;
        this.a=0;
        polozenie = new Vector2D(X0m,Y0m);
    }
    public double getPolozenieX()
    {
        return polozenie.x;
    }
    public double getPolozenieY()
    {
        System.out.println(polozenie.y);
        return polozenie.y;
    }
    public void setPolozenie(double x, double y)
    {
        this.polozenie = new Vector2D(x,y);
    }
    public void Simulate(double refresh) // metoda obliczajaca przyspieszenie i polozenie y masy
    {
        t=refresh;
        a=(1/Masa)*(-K*polozenie.y-C*Vym+Masa*G);
        Vym=Vym+a*t;
        polozenie.y=(double) (polozenie.y+(Vym*t+a*t*t/2));
    }
    public void zeruj() // metoda resetujaca symulacje
    {
        Vym=0;
        this.a=0;
    }
}

