import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ChainMatrix {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n;
        n = in.nextInt();
        int[] m = new int[n + 1];
        for (int i = 0; i <= n; ++i)
            m[i] = in.nextInt();

        long result = MatrixChainOrder(m, n+1);
        // your code

        out.println(result);

        out.close();
    }
 static long MatrixChainOrder(int p[], int n) 
    { 
       
        long m[][] = new long[n][n]; 
  
        int i, j, k, L;
        long q;
  
      

        for (i = 1; i < n; i++) 
            m[i][i] = 0; 
  
      
        for (L = 2; L < n; L++) { 
            for (i = 1; i < n - L + 1; i++) { 
                j = i + L - 1; 
                if (j == n) 
                    continue; 
                m[i][j] = Integer.MAX_VALUE; 
                for (k = i; k <= j - 1; k++) { 
                    // q = cost/scalar multiplications 
                    q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j]; 
                    if (q < m[i][j]) 
                        m[i][j] = q; 
                } 
            } 
        } 
  
        return m[1][n - 1]; 
    } 
}