package week3;

public class myStar {
	
    public static void main(String[] args) {
    	
    	int screenWidth = 1200;
    	int screenHeight= 800;
    	int howManyTriangles = 10;
    	int triangleMaxSize = 50;
  
        // Triangles SR = new Triangles(screenWidth, screenHeight, howManyStars, starMaxSize); // none recurcive
        
    	Triangles_Recursion SR = new Triangles_Recursion(screenWidth, screenHeight, howManyTriangles, triangleMaxSize);
       
        SR.start(); 
    }

}
