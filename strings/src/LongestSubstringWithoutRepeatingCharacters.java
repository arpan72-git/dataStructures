import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(findLongestSubstring("pwqewpstuvio"));
    }

    private static int findLongestSubstring(String s){
        int freq[] = new int[128];
        Arrays.fill(freq, 0);
        int i=0, ans=0;
        for(int j=0;j<s.length();j++){
            freq[s.charAt(j)]++;
            while(freq[s.charAt(j)]>1)
                freq[s.charAt(i++)]--;
            ans = Math.max(ans,j-i+1);
        }
        return ans;
    }
}
