package japplet;
import java.util.TimerTask;

public class SimTask extends TimerTask{
    private SimEngine simEngine;
    private SpringApplet springApplet;
    private double space;
    public SimTask (SimEngine simEngine, SpringApplet springApplet, double space)
    {
        this.simEngine=simEngine;
        this.springApplet=springApplet;
        this.space=space;
    }
    public void run()

    {
        simEngine.Simulate(space);
        springApplet.repaint();
    }

}
