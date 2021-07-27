public class SuperClass
{
    Object superClassMethod()
    {
        return new Object();
    }
}

class SubClass extends SuperClass{

    @Override
    SubClass superClassMethod() {
        return new SubClass();
    }

    public static void main(String[] args) {
        SuperClass s = new SubClass();
        Object o = s.superClassMethod();
        System.out.println(o.getClass().getName());
    }
}
