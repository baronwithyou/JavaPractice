package Algorithm.Chapter1;

public class Permute {
    public static void main(String []args) {
        permute("abc");
    }

    private static void permute(String str) {
        char[] c = str.toCharArray();
        permute(c, 0, c.length - 1);
    }

    private static void permute(char[] c, int low, int high) {
        if (low <= high) {
            System.out.print(c[low]);
            for (int i = 0; i <= high; i++) {
                if (i != low) {
                    System.out.print(c[i]);
                }
            }
            System.out.print("\n" + c[low]);
            for (int i = high; i >= 0; i--) {
                if (i != low) {
                    System.out.print(c[i]);
                }
            }
            System.out.print("\n");
            permute(c, low + 1, high);
        }
    }
}
