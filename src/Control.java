import graphics.graphicalElements.Pixel;
import ledControl.gui.KeyBuffer;

import java.awt.event.KeyEvent;

public class Control implements Runnable{
    private Pixel toControl;
    private KeyBuffer keyBuffer;

    public Control(Pixel toControl) {
        this.toControl = toControl;
        keyBuffer = KeyBuffer.getKeyBuffer();
    }


    @Override
    public void run() {
        while (true){
            KeyEvent input = keyBuffer.pop();

            if(input != null && input.getID() == KeyEvent.KEY_PRESSED) {
                switch (input.getKeyCode()) {
                    case KeyEvent.VK_SPACE:
                        toControl.jump();
                        break;
                    case KeyEvent.VK_LEFT:
                        toControl.moveLeftStart();
                        break;
                    case KeyEvent.VK_RIGHT:
                        toControl.moveRightStart();
                        break;
                }
            }
            if(input != null && input.getID() == KeyEvent.KEY_RELEASED) {
                if (input.getKeyCode() == KeyEvent.VK_LEFT || input.getKeyCode() == KeyEvent.VK_RIGHT) {
                    toControl.XMovementFinished();
                }
            }
            //keyBuffer.clear();

        }

    }
}
