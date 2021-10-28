import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StringExample {
    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "ABC";
        String s3 = new String("ABC");
        String s4 = s1;
        String s5 = s1.intern();
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s4));
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1==s5);
    }
}
