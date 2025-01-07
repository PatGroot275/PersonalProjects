import java.awt.*;
import java.awt.event.InputEvent;

public class Main {
    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();
        System.out.println("hover");
        Thread.sleep(5000);

        // Important
        PointerInfo info = MouseInfo.getPointerInfo();
        Point mouseeeee = info.getLocation();



        System.out.println(mouseeeee.x + ", " + mouseeeee.y);
        System.out.println("going to press");
        Thread.sleep(5000);
        

        // Important 
        robot.mouseMove((int) mouseeeee.getX(), (int) mouseeeee.getY());
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);



        Thread.sleep(5000);
        System.out.println("Continued");

        /* 
        The user experience should be building a "sequence" that will run 
        There will be elements that the user can order in a sequence 
            1. Click at a location
            2. Scroll
            3. Type
        There will be checkpoints that the user can add 
            1. Waiting a certain time
        There will be breakpoints that the user can add
            1. Running once 
            2. 
        
        
        the 
        */

    }
}
