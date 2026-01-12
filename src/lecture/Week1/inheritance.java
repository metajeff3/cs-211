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

class CircleExtension extends Area implements tester {
    public int test = 1;

    CircleExtension() {
        super();
        int i = 0;
    }
    @Override
    public int getValue(){
        return this.test;
    }

    @Override
    public void test(){
        System.out.println("hi");
    }
}

interface tester {
    public abstract void test();
}

public class inheritance  {
    public static void main(String[] args) {
        CircleExtension c = new CircleExtension();
        c.print(); //prints 1
        c.test();
    }
    
}