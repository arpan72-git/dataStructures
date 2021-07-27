//Static inner class: Defining the related or helper classes is possible inside the class by making it static.
//It can access the private member of the enclosing class through the object reference.
//The static class provides a nice namespace for the nested class.
//If the enclosing class gets updated, we are able to update the static class as well at the same location.
//In JVM, Classloader loads the static class at the time of the first usage only, not when its enclosing class gets loaded.
//Static class can only be an inner class or a nested class.
//Static classes can use any type of access modifier (private, protected, public, or default) like any other static member.
//Static classes are able to access only the static members of their enclosing class.
//Static class can interact with the non-static member only through the object of its enclosing class only, as it cannot access the non-static members of its enclosing class directly.

public class Output5 {
    private int v;
    private static Integer d;
    public static void main(String[] args) {
//        new Output4().display(null);
        N n = new N(); // or
        n = new Output5.N();  // both are same... a nested static class can ne created via a static context
        M m = new Output5().new M();
        n.m(); int c= N.g;
        m.m();
    }

    public void display(String s){
        System.out.println();
    }
    public void display(StringBuffer sb){
        System.out.println();
    }

    public static class N extends Output2{
        static int g;
        int u;
        void m(){  int s = x;
//            int m = v; // a static inner class can not access its enclosing class members directly
            int m = new Output5().v; // a static inner class can access enclosing class members via object reference only
            int db = d; // a static inner class can access enclosing class static members directly
        }
    }

    public class M extends Output2{
        void m(){ int s = x;
            int k = v; // an inner class can access its enclosing class variable directly
//            int m = new Output5().v;
            int db= d; // an inner class can access its encloing class static variables directly
        }
    }

    static Output5 o = new Output5(){};
}
