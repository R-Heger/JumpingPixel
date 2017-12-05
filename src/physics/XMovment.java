package physics;

public class XMovment implements Runnable {
    private IMoveable toMove;
    private static final double SPEED = 0.12; //dots per millisecond

    public XMovment(IMoveable toMove) {
        this.toMove = toMove;
    }

    @Override
    public void run() {
        int xDirection;
        while (true){
            xDirection = toMove.getXDirection();
            if(xDirection != 0){
                toMove.setXPos(toMove.getPosition()[0] + xDirection * SPEED);
            }
            try {
                Thread.sleep((long) (1/SPEED));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
