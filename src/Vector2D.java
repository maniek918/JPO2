public class Vector2D {
public double x,y; // wspolrzedne x, y

    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Vector2D dodWekt(Vector2D w) // dodawanie wektorow
    {
        return new Vector2D(this.x + w.x, this.y + w.y);
    }
    public Vector2D odeWekt(Vector2D w) // odejmowanie wektorow
    {
        return new Vector2D(this.x - w.x, this.y - w.y);
    }
    public Vector2D mnozWekt(int k) // mnozenie wektora przez stala
    {
        return new Vector2D(this.x * k, this.y * k);
    }
    public double dlWekt() // dlugosc wektora
    {
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }
    public Vector2D normWekt() // wersor
    {
        if((this.x!=0) && (this.y!=0))
        {
            return new Vector2D(this.x / this.dlWekt(), this.y / this.dlWekt());
        }
        else
        {
            System.out.println("Dlugosc wektora jest rowna 0");
            return null;
        }
    }
    public void opis()
    {
        System.out.println("x: "+ this.x);
        System.out.println("y: "+ this.y);
        System.out.println("dlugosc: "+ this.dlWekt());
        if(this.dlWekt()!=0) {
            System.out.println("wersor: "  );
            System.out.println("x: "+ this.x / this.dlWekt());
            System.out.println("y: "+ this.y / this.dlWekt());
        }

    }
}
