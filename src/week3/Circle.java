package week3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;


class CircleInfo {
    int cx; // center
    int cy;
    int radius;
    int maxRadius;
    int zoom;
    int speedX;
    int speedY;
    int angle;
    int angleSpeed;
    Color color;
}

public class Circle extends Canvas implements Runnable {
    private Thread starThread;
    private boolean running = false;
    private static ArrayList<CircleInfo> myCircle = new ArrayList<>();
    static int width; // screen
    static int height; // screen
    public static int boardTop;
    static Random rand = new Random();
    static int R, G, B;

    Circle(int width, int height, int howManyCircle, int circleSize) {
        JFrame frame = new JFrame("CS211: Circle - inheritance & recursion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);
        this.width = width; // screen width & height
        this.height = height;
        // double buffering
        createBufferStrategy(2);
        for (int i = 0; i < howManyCircle; i++) {
            CircleInfo s = new CircleInfo();
            R = rand.nextInt(256);
            G = rand.nextInt(256);
            B = rand.nextInt(256);
            s.color = new Color(R, G, B);
            s.cx = rand.nextInt(width); // center of the circle
            s.cy = rand.nextInt(height);
            s.radius = rand.nextInt(circleSize) + 15;
            s.maxRadius = s.radius; // keep the original max size
            s.zoom = 1;
            s.speedX = rand.nextInt(5) + 1;
            s.speedY = rand.nextInt(5) + 1;
            s.angle = rand.nextInt(30);
            s.angleSpeed = rand.nextInt(2) + 1;
            if (rand.nextInt(2) == 0) {
                s.angleSpeed *= -1;
            }
            myCircle.add(s);
        }
    }

    public synchronized void start() {
        running = true;
        starThread = new Thread(this);
        starThread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            starThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (running) {
            render();
            try {
                Thread.sleep(32); // org 16
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        for (int i = 0; i < myCircle.size(); i++) {
            g.setColor(myCircle.get(i).color);
            if (myCircle.get(i).radius > myCircle.get(i).maxRadius *
                    1.5 || myCircle.get(i).radius < 1) {
                myCircle.get(i).zoom *= -1;
            }
            myCircle.get(i).radius += myCircle.get(i).zoom;
            myCircle.get(i).cx += myCircle.get(i).speedX;
            if (myCircle.get(i).cx > width - myCircle.get(i).radius) {
                myCircle.get(i).cx = width - myCircle.get(i).radius;
                myCircle.get(i).speedX = -myCircle.get(i).speedX;
            }
            if (myCircle.get(i).cx < myCircle.get(i).radius) {
                myCircle.get(i).cx = myCircle.get(i).radius;
                myCircle.get(i).speedX = -myCircle.get(i).speedX;
            }
            myCircle.get(i).cy += myCircle.get(i).speedY;
            if (myCircle.get(i).cy > height - myCircle.get(i).radius) {
                myCircle.get(i).cy = height - myCircle.get(i).radius;
                myCircle.get(i).speedY = -myCircle.get(i).speedY;
            }
            if (myCircle.get(i).cy < boardTop + myCircle.get(i).radius) {
                myCircle.get(i).cy = boardTop + myCircle.get(i).radius;
                myCircle.get(i).speedY = -myCircle.get(i).speedY;
            }
            myCircle.get(i).angle += myCircle.get(i).angleSpeed;
            if (myCircle.get(i).angle >= 360 || myCircle.get(i).angle <= -360) {
                myCircle.get(i).angle = 0;
            }
            drawCircle(g, myCircle.get(i).cx, myCircle.get(i).cy,
                    myCircle.get(i).radius, myCircle.get(i).angle, myCircle.get(i).angleSpeed);
        }
        // Dispose the graphics context
        g.dispose();
        // Show the back buffer on the screen
        bs.show();
    }

    public void drawCircle(Graphics g, int cx, int cy, int radius, int angle,
            int angleSpeed) {
        // Calculate the top-left corner of the bounding box for the circle
        int x = cx - radius;
        int y = cy - radius;
        int diameter = radius * 2;
        // outlined circle
        g.drawOval(x, y, diameter, diameter);
        // filled circle
        // g.fillOval(x, y, diameter, diameter);
    }
}
