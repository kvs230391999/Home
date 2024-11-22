package implemica.OneTask;

import java.util.Scanner;

/**
 * Created 22.11.2024.
 */
public class Ukrainian {

    Scanner scanner = new Scanner(System.in);

    int ukrainianNum(int n){
        System.out.println("Enter the number ");
        n = scanner.nextInt();
        return ((factorial(2*n))/((factorial(n+1)*factorial(n))));
    }

    int factorial(int n){
        int m =1;
        for (int i = 1; i <= n; i++) {
            m *= i;
        }
        return m;
    }
}
