public class Output3 {
    public static void main(String[] args) {
        Object o = null;
        String s = String.valueOf(o); // overloaded method with parameter as Object will be called
        String ss = String.valueOf(null); // overloaded method with parameter as char[] will be called
    }

    public void s(int[] k){}
    public void d(int ...s){}
}
