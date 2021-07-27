public class Output6 {
    public static void main(String[] args) {
//        int v = 9;
//        int b = 8;
        new Output6().method(20, 30);
    }
    int method(int i, int d)
    {
        return i+d;
    }

    int method(int i, double d)
    {
        return (int)(i+d);
    }

    double method(double i, int d)
    {
        return i+d;
    }

    double method(double i, double d)
    {
        return i+d;
    }
}
