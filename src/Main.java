public class Main {

    public static void main(String[] args) {
       Vector2D w1 = new Vector2D(2d,5d);
       Vector2D w2 = new Vector2D(4d,6d);
       Vector2D w_dod = w1.dodWekt(w2);
       Vector2D w_odej = w1.odeWekt(w2);
       Vector2D wers1 = w1.normWekt();
       Vector2D wers2 = w2.normWekt();
       double dl1 = w1.dlWekt();
       double dl2 = w2.dlWekt();
       Vector2D mnoz = w1.mnozWekt(8);
        System.out.println("w1: ");
        w1.opis();
        System.out.println("w2: ");
        w2.opis();
        System.out.println("dodawanie: ");
        System.out.println("x: "+ w_dod.x);
        System.out.println("y: "+ w_dod.y);
        System.out.println("odejmowanie: ");
        System.out.println("x: "+ w_odej.x);
        System.out.println("y: "+ w_odej.y);
        System.out.println("mnozenie: ");
        System.out.println("x: "+ mnoz.x);
        System.out.println("y: "+ mnoz.y);
    }
}
