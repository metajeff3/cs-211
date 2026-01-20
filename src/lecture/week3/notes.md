# Recursion (calling itself)

3 important conditions of recursion:

* call it self (recursion)
* exit condition
* changing/update condition

Software developers are not allowed to use recursion due to memory stack
conditions. You should try to do everything iteratively as it has a faster
timer complexity.

Trade offs:

* Recursion has much shorter and elegant code solutions but slower time complexity. Code size needs to be small due to stack memory restrictions.
* Iterative solutions are larger but have faster time complexity.


You can use `return;` to break out of a function.`

# JVM stack

In a method, the ending `}` ends the method and disconnects the pointer to all the stack memory of method essentially "freeing" it up to be rewritten.

This is why you can't access variables in the method because scope and also null pointer.