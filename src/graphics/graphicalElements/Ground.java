package graphics.graphicalElements;

import graphics.DrawInfo;
import graphics.View;

public class Ground implements IDrawable {
    @Override
    public DrawInfo getDrawInfo() {
        int[] pos = {0, View.LOWER_BORDER};
        int[][][] pattern = new int[View.RIGHT_BORDER + 1][1][3];
        for (int i = 0; i < pattern.length; i++) {
            pattern[i][0] = new int[]{0, 127, 0};
        }
        return new DrawInfo(pos, pattern);
    }
}
