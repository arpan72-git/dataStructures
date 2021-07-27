public class XX
{
    int method(int i)
    {
        return i *= i;
    }
}

class YY extends XX
{
    double method(double d)
    {
        return d /= d;
    }
}

class ZZ extends YY
{
    float method(float f)
    {
        return f += f;
    }
}

class MainClass
{
    public static void main(String[] args)
    {
        ZZ z = new ZZ();

        System.out.println(z.method(21.12));
    }
}