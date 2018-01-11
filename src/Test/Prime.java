package Test;

public class Prime {
    public static void prime(int m, int n) {
        int result = 0;
        int count = 0;
        for (; m < n; m++) {
            boolean is_prime = true;
            for (int half = m / 2; half > 1; half--) {
                if (m % half == 0) {
                    is_prime = false;
                }
            }
            if (is_prime) {
                result += m;
                count++;
            }
        }
        System.out.println(result + " ----- " + count);
    }

    public static void main(String []args) {
        prime(3, 5);
    }
}
