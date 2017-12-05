package graphics.graphicalElements;

import graphics.DrawInfo;
import graphics.View;
import physics.IMoveable;
import physics.XMovment;
import physics.YMovement;

public class Pixel implements IDrawable, IMoveable {
    public static final int LEFT = -1;
    public static final int RIGHT = 1;
    public static final int STOP = 0;

    private double xPos;
    private double yPos;
    private int[] color;
    private boolean isJumping;
    private int xDirection;

    public Pixel(double xPos, double yPos, int[] color) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
        this.isJumping = false;
        this.xDirection = 0;
        startXMovment();
    }

    public int getXDirection() {
        return xDirection;
    }

    private void startXMovment() {
        Thread xMoveThread = new Thread(new XMovment(this));
        xMoveThread.start();

    }

    public void jump(){
        if(!isJumping) {
            Thread jumpThread = new Thread(new YMovement(this));
            jumpThread.start();
            isJumping = true;
        }
    }

    @Override
    public void YMovementFinished() {
        this.isJumping = false;
    }

    @Override
    public double[] getPosition() {
        double[] pos = {xPos, yPos};
        return pos;
    }

    @Override
    public void setPosition(double[] pos) {
        xPos = pos[0];
        yPos = pos[1];
    }

    @Override
    public void setXPos(double xPos) {
        if(xPos > View.RIGHT_BORDER){
            this.xPos = View.RIGHT_BORDER;
        } else if (xPos < 0){
            this.xPos = 0;
        } else {
            this.xPos = xPos;
        }
    }

    @Override
    public void setYPos(double yPos) {
        this.yPos = yPos;
    }

    @Override
    public DrawInfo getDrawInfo() {
        int[] position = {(int) xPos, (int) yPos};
        int[][][] pattern = {{color}};
        return new DrawInfo(position, pattern);
    }

    public void moveLeftStart() {
        xDirection = LEFT;
    }

    public void moveRightStart() {
        xDirection = RIGHT;
    }

    @Override
    public void XMovementFinished() {
        xDirection = STOP;
    }
}
