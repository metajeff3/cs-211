package lecture.week3;

public class myCircle {

    public static void main(String[] args) {
        int screenWidth = 1200;
        int screenHeight = 800;
        int howManyCircles = 5;
        int circleMaxSize = 100;
        Circle SR = new Circle(screenWidth, screenHeight, howManyCircles,
                circleMaxSize); // none recursion
        // keep this for recursion
        // Circle_Recursion SR = new Circle_Recursion(screenWidth, screenHeight, howManyCircles, circleMaxSize);
        SR.start();
    }
}
