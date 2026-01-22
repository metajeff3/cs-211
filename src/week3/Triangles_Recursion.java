package week3;

import java.awt.Graphics;

public class Triangles_Recursion extends Triangles {

    Triangles_Recursion(int screenWidth, int screenHeight, int howManyStars, int starSize) {
        super(screenWidth, screenHeight, howManyStars, starSize);
    }

    @Override
    public void drawTriangle(Graphics g, int tx, int ty, int size, int angle) {
        if (size < 10){
            return;
        }

        design1(g, tx, ty, size, angle);
    }

    private void design1(Graphics g, int tx, int ty, int size, int angle) {
        super.drawTriangle(g, tx, ty, size, angle);

  
        int ang = 90 - angle;
        double PI = Math.PI;

        for (int i = 0; i < 3; i++) {
            int xCoords = 0;
            int yCoords = 0;

            xCoords += (int) (size * Math.cos(PI * ang / 180.0));
            yCoords -= (int) (size * Math.sin(PI * ang / 180.0));
            ang += 180/3;
            xCoords += tx;
            yCoords += ty;
            this.drawTriangle(g, xCoords, yCoords, size/2, angle);
        }
    }
}
