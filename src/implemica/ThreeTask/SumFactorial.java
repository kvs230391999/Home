package implemica.ThreeTask;


import java.math.BigInteger;

/**
 * Created 22.11.2024.
 * author: Kulishov Vladyslav
 */
public class SumFactorial {

    public static void main(String[] args) {
        BigInteger m = BigInteger.valueOf(1);

        //find the factorial of number 100
        for (long i = 1; i <= 100; i++) {
            m = m.multiply(BigInteger.valueOf(i));
            System.out.println(i + "! = " + m);
        }
        //the sum of the digits
        String x = m.toString();
        int data[] = new int[x.length()];
        int sum = 0;
        for (int j = 0; j < x.length(); j++) {
            data[j] = (int) x.charAt(j) ^ 48;
            sum += data[j];
        }

        System.out.println(sum);

    }
}
