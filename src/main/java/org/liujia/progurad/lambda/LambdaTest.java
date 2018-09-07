package org.liujia.progurad.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liujia on 2018/7/31.
 */
public class LambdaTest {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("123","fasdf", "1dfsfa", "gf");

        System.out.println("test method reference");
        list.forEach(A::print);

        System.out.println("test map function");
        List<String> collect = list.stream().map(v -> v + "12").collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }

        System.out.println("test interface implement");
        B b = () -> A.print("123");
        b.print();

        print("1", "2", "3");
    }


    public static void print(String... aaa) {
        for (String s : aaa) {
            System.out.println("not specified length array print: " + s);
        }
    }

}

class A {
    static void print(String str) {
        System.out.println(str);
    }
}

interface B {
    void print();
}