package physics;

public interface IMoveable {
    public double[] getPosition();
    public void setPosition(double[] pos);
    public void setXPos(double xPos);
    public void setYPos(double yPos);
    public void YMovementFinished();
    public void XMovementFinished();
    public int getXDirection();
}
