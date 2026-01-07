class Area {
    public int test = 0;

    public int getValue(){
        return this.test;
    }

    Area() {
        int a = 0;
    }
    public void print() {
        System.out.println(this.getValue()); // this.test refers to the class's getvalue method.
    }
}

class CircleExtension extends Area {
    public int test = 1;

    CircleExtension() {
        super();
        int i = 0;
    }
    public int getValue(){
        return this.test;
    }
}

public class inheritance  {
    public static void main(String[] args) {
        CircleExtension c = new CircleExtension();
        c.print(); //prints 1
    }
    
}