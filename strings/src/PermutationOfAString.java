public class PermutationOfAString {
    public static void main(String[] args) {
        permutation("abc", "");
    }

    public static void permutation(String word, String ans){
        if (word.length() == 0){
            System.out.println(ans);
            return;
        }
        for (int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            String s = word.substring(0,i) + word.substring(i+1);
            permutation(s, ans + ch);
        }
    }
}
