public class SuperClass1 {
    public void get(Number n){
        System.out.println("Superclass method");
    }
}

class SubClass1 extends SuperClass1{
    //Note that this method is not an overridden method. The parameters must be same datatype
    public void get(Double d){
        System.out.println("SubClass method");
    }

    public static void main(String[] args) {
        SubClass1 s = new SubClass1();
        //the methods in subclass and superclass are different. They are not overridden as datatype is different
        s.get(1323);
    }
}
