package Test;

public class StringIndex {
    public static void main(String []args) {
        String s1 = "egg";
        for (int i = 0; i < s1.length(); i++)
            System.out.println(s1.charAt(i));
        System.out.println(longestPalindrome("bbacceedd"));
    }

    private static int longestPalindrome(String s) {
        boolean odd = false;
        int []counts = new int[256];
        for (char c : s.toCharArray()) {
//            System.out.println(++counts[c]);
            counts[c]++;
        }
        int sum = 0;
        for (int count : counts) {
            if ((count & 1) == 1)
                odd = true;
            sum += (count >> 1) << 1;
        }
        return odd ? sum + 1 : sum;
    }
}
