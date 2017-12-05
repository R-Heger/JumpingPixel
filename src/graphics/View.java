package graphics;

import graphics.graphicalElements.IDrawable;
import ledControl.BoardController;

import java.util.ArrayList;

public class View implements Runnable{
    public static int RIGHT_BORDER;
    public static int LOWER_BORDER;

    private static final int INTER_FRAME_TIME = 20; //milliseconds

    public BoardController controller;
    private ArrayList<IDrawable> drawables;

    public View(BoardController controller) {
        this.controller = controller;
        this.drawables = new ArrayList<>();
        LOWER_BORDER = controller.getHeight() - 1;
        RIGHT_BORDER = controller.getWidth() -1;
    }

    @Override
    public void run() {
        long lastUpdate = 0;
        while (true){
            if(System.currentTimeMillis() - lastUpdate >= INTER_FRAME_TIME){
                lastUpdate = System.currentTimeMillis();
                updateView();
            }
        }
    }

    private void updateView(){
        controller.resetColors();

        for(IDrawable d : drawables){
            draw(d);
        }

        controller.updateLedStripe();
    }

    private void draw(IDrawable d) {
        int xPos = d.getDrawInfo().getPosition()[0];
        int yPos = d.getDrawInfo().getPosition()[1];

        int[][][] pattern = d.getDrawInfo().getGraphicalPattern();

        for(int x = 0; x < pattern.length; ++x ){
            for (int y = 0; y < pattern[x].length; y++) {
                controller.setColor(xPos + x, yPos + y, pattern[x][y]);
            }
        }
    }

    public void addDrawable(IDrawable d){
        drawables.add(d);
    }


}
