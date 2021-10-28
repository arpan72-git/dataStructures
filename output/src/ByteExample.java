public class ByteExample {
    public static void main(String[] args) {
        byte b1 = (byte)110.0;
        byte b2 = (byte) 30.0;
        byte b3 = (byte)(double)(b1 + b2);
        System.out.println(b3);
    }
}
