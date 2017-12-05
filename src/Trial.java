public class Trial {
    private static final int UPPER_TURN = 10;
    private static final double SPEED = 0.02;
    public static void main(String[] args){
        double b = Math.sqrt(UPPER_TURN);
        double y = 0;
        long startTime = System.currentTimeMillis();


        System.out.println(UPPER_TURN-Math.pow(0-b, 2));
        while(y >= -1){
            y = -Math.pow((System.currentTimeMillis() - startTime)*SPEED - b, 2) + UPPER_TURN;

            System.out.println(y);

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
