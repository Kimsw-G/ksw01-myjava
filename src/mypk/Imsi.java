package mypk;

import java.util.Arrays;
import java.util.List;

public class Imsi{
    public static void main(String[] args) {
        

        B b = new B();
        // b.hello();
        // b.hi();

        int[] a= {1,2,3,4};
        List<Integer> list = Arrays.asList(new Integer[] {1,2,3,4,5});
        list.add(6);

    }
}

class A{
    void hello(){
        System.out.println("I'm a");
    }
}
class B extends A{

    void hi(){
        System.out.println("I'm b");
    }
}