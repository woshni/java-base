package com.yinc.demo;

public class ClassTest {
    public static void main(String[] args) {

        System.out.println("String :"+String.class.isEnum());
        System.out.println("ClassTest :"+ClassTest.class.isEnum());
        System.out.println("EnumTest :"+EnumTest.class.isEnum());
    }

     enum EnumTest{
    }
}
