import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Knapsack {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n, W;
        n = in.nextInt();
        W = in.nextInt();

        int[] wt = new int[n];
        int[] val = new int[n];
        for (int i = 0; i < n; ++i) {
            wt[i] = in.nextInt();
            val[i] = in.nextInt(); 
        }

        ArrayList<Integer> result = printknapSack(W, wt, val, n); 
        out.println(result.size());
        for (int i = result.size()-1; i >=0; i--) {
            if (i != result.size()-1) out.print(' ');
            out.print(result.get(i));
        }
        out.println();

        out.close();
    }
 public static int max(int a, int b)  
    { 
        return (a > b) ? a : b; 
    } 
  
    // Prints the items which are put  
    // in a knapsack of capacity W 
    public static  ArrayList<Integer>  printknapSack(int W, int wt[],  
                             int val[], int n) 
    { 
ArrayList<Integer> result=new ArrayList<Integer>();
        int i, w; 
        int K[][] = new int[n + 1][W + 1]; 
  
        // Build table K[][] in bottom up manner 
        for (i = 0; i <= n; i++) { 
            for (w = 0; w <= W; w++) { 
                if (i == 0 || w == 0) 
                    K[i][w] = 0; 
                else if (wt[i - 1] <= w) 
                    K[i][w] = Math.max(val[i - 1] +  
                              K[i - 1][w - wt[i - 1]], K[i - 1][w]); 
                else
                    K[i][w] = K[i - 1][w]; 
            } 
        } 
  
        // stores the result of Knapsack 
        int res = K[n][W]; 
        //System.out.println(res); 
  
        w = W; 
        for (i = n; i > 0 && res > 0; i--) { 
  
            // either the result comes from the top 
            // (K[i-1][w]) or from (val[i-1] + K[i-1] 
            // [w-wt[i-1]]) as in Knapsack table. If 
            // it comes from the latter one/ it means 
            // the item is included. 
            if (res == K[i - 1][w]) 
                continue; 
            else { 
  
                // This item is included. 
            result.add(i);
  
                // Since this weight is included its 
                // value is deducted 
                res = res - val[i - 1]; 
                w = w - wt[i - 1]; 
            } 
        } 
return result;
    } 

}