# Inheritance Notes
>
> note: you cannot extend **final** classes.

For later usage if you want to have addition to program. Always use words superclass and subclass.

Let us have an example super Area class with only two area formulas.

```java
public class Area {
    public double rect(double width, double height) {
        return width * height;
    }

    public double tri(double base, double height) {
        return base * height / 2.0;
    }
}
```

What if I want to extend and include circle area while also having access to the same methods from the superclass.

If you want to change how it used, you can override it.

```java
class Area {
    public double rect(double width, double height) {
        return width * height;
    }

    public double tri(double base, double height) {
        return base * height / 2.0;
    }
}

class CircleExtension extends Area {
    public double circle(double radius) {
        return Math.PI * radius * radius;
    }
}

public class inheritance  {
    public static void main(String[] args) {
        CircleExtension c = new CircleExtension();
        System.out.println(c.tri(1.2, 5)); // this still runs 3.0
    }
    
}
```

# Fields are not polymorphic but methods are

Example of field variable:

```java
class Area {
    public int test = 0;

    public void print() {
        System.out.println(this.test); // this.test refers to area THIS.
    }
}

class CircleExtension extends Area {
    public int test = 1;

    // when print() is inherited, it doesn't print circlextension.test.
}

public class inheritance  {
    public static void main(String[] args) {
        CircleExtension c = new CircleExtension();
        c.print(); //prints 0?
    }
    
}
```

Example of method.

```java
class Area {
    public int test = 0;

    public int getValue(){
        return this.test;
    }

    public void print() {
        System.out.println(this.getValue()); // this.test refers to the class's getvalue method.
    }
}

class CircleExtension extends Area {
    public int test = 1;

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
```

# Field Hiding: super & this variables

