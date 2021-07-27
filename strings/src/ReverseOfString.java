public class ReverseOfString {
    public static void main(String[] args) {
        System.out.println(reverse("abcd"));
    }

    public static String reverse(String string){
        if (string.length() == 0)
            return "";
        return reverse(string.substring(1)) + string.charAt(0);
    }
}
