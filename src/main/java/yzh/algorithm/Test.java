package yzh.algorithm;

public class Test {
    public static void main(String[] args) {
        System.out.println(User.str == Person.str);
    }
}

class User {
    public static final String str = "123";
}

class Person {
    public static final String str = "123";
}