package japplet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import java.util.Timer;


public class SpringApplet extends JApplet implements MouseMotionListener, MouseListener, ActionListener{
    int szer=500;
    int wys=500;
    boolean przeciaganie; // wartosc logiczna przeciagania myszki
    double polx;
    double poly;

    private SimEngine simEngine;
    private SimTask simTask;
    private Timer space;
    private Button buttonReset;
    private TextField Masa,K,C,G,L;

    public void init()
    {
        przeciaganie=false;
        addMouseListener(this);
        addMouseMotionListener(this);
        setSize(szer,wys);
        simEngine= new SimEngine(15,5,2,150,250,100,250,150);
        simTask= new SimTask(simEngine, this, 0.1);
        space= new Timer();
        space.scheduleAtFixedRate(simTask, 0, 15);
        // utworzenie przycisku
        buttonReset= new Button("Reset");
        buttonReset.addActionListener(this);
        add(buttonReset);
        // utworzenie obiektow
        Masa= new TextField("15",1);
        K= new TextField("5",1);
        C= new TextField("2",1);
        G= new TextField("9,81",1);
        L= new TextField("150",1 );
        // dodanie elementow GUI
        add(Masa);
        add(K);
        add(C);
        add(G);
        add(L);
}
public void mousePressed(MouseEvent e)
{
    polx=e.getX();
    poly=e.getY();
    if((polx>=(int)simEngine.getPolozenieX()-25 && polx<=(int)simEngine.getPolozenieX()+25)
            && (poly>=(int)simEngine.getPolozenieY() && poly<=(int)simEngine.getPolozenieY()+50))
    {
        space.cancel();
        simEngine.zeruj();
        przeciaganie=true;
    }
    e.consume();
}
public void mouseReleased(MouseEvent e)
{
    if(przeciaganie=true)
    {
        simEngine.zeruj();
        simTask= new SimTask(simEngine, this, 0.1);
        space= new Timer();
        space.scheduleAtFixedRate(simTask,0,15);
        przeciaganie=false;
    }
    e.consume();
}
public void mouseDragged(MouseEvent e)
{
    if(przeciaganie=true)
    {
        int pol_x=e.getX();
        int pol_y=e.getY();
        simEngine.setPolozenie(simEngine.getPolozenieX(), pol_y);
        repaint();
    }
    e.consume();
    }

    public void paint(Graphics g)
    {
        Vector2D wychylenie = simEngine.polozenie;
        //czyszczenie ekranu
        g.setColor(Color.WHITE);
        g.fillRect(0 ,0, szer, wys);
        // rysowanie zamocowania
        g.setColor(Color.RED);
        g.fillRect(210, 85, 80, 15);
        // rysowanie linki
        g.setColor(Color.BLACK);
        g.drawLine((int)simEngine.getPolozenieX(), 100, (int)simEngine.getPolozenieX(),
                (int) ((int) (wychylenie.y)+simEngine.getL()));
        // rysowanie masy
        g.setColor(Color.BLUE);
        g.fillOval((int)simEngine.getPolozenieX()-25,
                (int) (simEngine.getPolozenieY()+simEngine.getL()), 50, 50);
        // rysowanie przyciskow
        g.setColor(Color.GRAY);
        g.drawString("Masa",30,40 );
        Masa.setBounds(30,40,40,20);
        g.drawString("K",30,90);
        K.setBounds(30,100,40,20);
        g.drawString("C",30,150);
        C.setBounds(30,160,40,20);
        g.drawString("L",30,210);
        L.setBounds(30,220,40,20);
        g.drawString("G", 30,270);
        G.setBounds(30,280,40,20);
        buttonReset.setBounds(30,340,60,40);
    }
    @Override
    public void mouseMoved(MouseEvent e) {

    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonReset) {
            space.cancel();
            double m = Double.parseDouble(Masa.getText());
            double k = Double.parseDouble(K.getText());
            double c = Double.parseDouble(C.getText());
            double g = Double.parseDouble(G.getText());
            double l = Double.parseDouble(L.getText());
            simEngine = new SimEngine(m, k, c, 10, 300, 10, 300, 100);
            simEngine.setG((float) g);
            simTask = new SimTask(simEngine, this, 0.1);
            space = new Timer();
            space.scheduleAtFixedRate(simTask, 0, 15);
        }

        }
}

