package week3;

import java.awt.Graphics;

public class Circle_Recursion extends Circle {
    public static final int depth = 3;

    Circle_Recursion(int screenWidth, int screenHeight, int howManyStars, int starSize) {
        super(screenWidth, screenHeight, howManyStars, starSize);
    }

    @Override // i just need to add ,depth param and change the exit condition
    public void drawCircle(Graphics g, int cx, int cy, int radius, int angle, int angleSpeed) {
        if (radius < 10){
            return;
        }
        super.drawCircle(g, cx, cy, radius, angle, angleSpeed);
        this.drawCircle(g, cx, cy+radius, radius/2, angle, angleSpeed);
        this.drawCircle(g, cx, cy-radius, radius/2, angle, angleSpeed);
        this.drawCircle(g, cx+radius, cy, radius/2, angle, angleSpeed);
        this.drawCircle(g, cx-radius, cy, radius/2, angle, angleSpeed);
    }
}
