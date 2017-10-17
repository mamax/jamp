package com.epam.innerclass;

public class InnerClass {

    private static int x = 1;

    static class A{
        private static int y = 2;
        public static int getZ(){
            return B.z+x;
        }
    }
    static class B{
        private static int z = 3;
        public static int getY(){
            return A.y;
        }
    }

    static class C{
        static int add(int aa, int bb){
           return  aa+bb;
        }
    }
}
