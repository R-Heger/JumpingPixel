import graphics.graphicalElements.Ground;
import graphics.graphicalElements.Pixel;
import graphics.View;
import ledControl.BoardController;
import ledControl.LedConfiguration;

public class Main {
    private static View view;
    private static Control control;
    public static BoardController controller;

    public static void main(String[] args){
        controller  = BoardController.getBoardController(LedConfiguration.LED_20x20_EMULATOR);
        //controller  = BoardController.getBoardController(LedConfiguration.LED_12x12_3x48);
        view = new View(controller);

        int[] blue = {0, 0, 127};

        Pixel pixel = new Pixel((int)(View.RIGHT_BORDER/2),  View.LOWER_BORDER - 1, blue);
        Ground ground = new Ground();
        view.addDrawable(pixel);
        view.addDrawable(ground);
        Thread viewThread = new Thread(view);
        viewThread.start();

        control = new Control(pixel);

        Thread controlThread = new Thread(control);
        controlThread.start();
    }

}
