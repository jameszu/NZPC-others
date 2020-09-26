import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int[][] dp;
    private static ArrayList<Integer>[][] path;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = 1;
        int[] subtraction = new int[201], plus = new int[201];
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        while (n != 0 && m != 0) {
            dp = new int[21][];
            path = new ArrayList[21][];
            for (int i = 0; i < 21; i++) {
                dp[i] = new int[801];
                path[i] = new ArrayList[801];
                for (int j = 0; j < 801; j++) {
                    dp[i][j] = -1;
                    path[i][j] = new ArrayList<>();
                }
            }
            int d, p;
            for (int i = 0; i < n; i++) {
                d = sc.nextInt();
                p = sc.nextInt();
                subtraction[i] = d-p;
                plus[i] = d+p;
            }
            int fix = 20*m;
            dp[0][fix] = 0;
            for (int k = 0; k <= n; k++) {
                for (int i = m-1; i >= 0; i--) {
                    for (int j = 0; j <= 2*fix; j++) {
                        if (dp[i][j] >= 0) {
                            if (dp[i+1][j+subtraction[k]] <= dp[i][j] + plus[k]) {
                                dp[i+1][j+subtraction[k]] = dp[i][j] + plus[k];
                                path[i+1][j+subtraction[k]] = path[i][j];
                                path[i+1][j+subtraction[k]].add(k);
                            }
                        }
                    }
                }
            }
            int i = 0;
            while (dp[m][fix+i] == -1 && dp[m][fix-i] == -1) {
                i++;
            }
            int temp;
            if (dp[m][fix+i] > dp[m][fix-i])
                temp = i;
            else
                temp = -i;

            int sumD = ( dp[m][fix+temp] + temp )/2;
            int sumP = ( dp[m][fix+temp] - temp )/2;
            System.out.println("Jury #" + times);
            times++;
            System.out.println("Best jury has value " + sumD + " for prosecution and value " + sumP +  " for defence:");
            for( i=0; i < m; i++ )
                System.out.print(" " + (path[m][fix+temp].get(i) + 1));
            System.out.print("\n\n");

            n = sc.nextInt();
            m = sc.nextInt();
        }
    }
}
