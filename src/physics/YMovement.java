package physics;

public class YMovement implements Runnable {
    private static final double SPEED = 0.0075; //dots per millisecond
    private static final int UPPER_TURN = 10; //dots
    private IMoveable toMove;

    public YMovement(IMoveable toMove) {
        this.toMove = toMove;
    }

    @Override
    public void run() {
        double startPos = toMove.getPosition()[1];
        double shift = Math.sqrt(UPPER_TURN);
        double y = 0;
        double yDiff = 0;
        long startTime = System.currentTimeMillis();
        while(y >= -0.1){
            y = -Math.pow((System.currentTimeMillis() - startTime)*SPEED - shift, 2) + UPPER_TURN;
            yDiff = (y < 0)? 0 : y;
            toMove.setYPos(startPos - yDiff);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        toMove.YMovementFinished();
    }
}
