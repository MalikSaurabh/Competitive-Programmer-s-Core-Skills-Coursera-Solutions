import java.util.*;
import java.io.*; 
  
class  LongestCommonSubsequence 
{ 
  
    static void lcs(String X, String Y, int m, int n) 
    { 
        int[][] L = new int[m+1][n+1]; 
   
      
        for (int i=0; i<=m; i++) 
        { 
            for (int j=0; j<=n; j++) 
            { 
                if (i == 0 || j == 0) 
                    L[i][j] = 0; 
                else if (X.charAt(i-1) == Y.charAt(j-1)) 
                    L[i][j] = L[i-1][j-1] + 1; 
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]); 
            } 
        } 
   
       
        int index = L[m][n]; 
        int temp = index; 
    
        int[] lcs = new int[index]; 
             int[] lcs1 = new int[index]; 
        //lcs[index] = ''; 
        int i = m, j = n; 
        while (i > 0 && j > 0) 
        { 
           
            if (X.charAt(i-1) == Y.charAt(j-1)) 
            { 
           
                lcs[index-1] = i-1;  
                  lcs1[index-1]=j-1;
               
                i--;  
                j--;  
                index--;      
            } 
   
            
            else if (L[i-1][j] > L[i][j-1]) 
                i--; 
            else
                j--; 
        } 
   
        
        System.out.println(temp); 
        for(int k=0;k<temp;k++) 
            System.out.print(lcs[k]+" "); 
    
    System.out.println();
           for(int k=0;k<temp;k++) 
            System.out.print(lcs1[k]+" "); 
    
    }
    // driver program 
    public static void main (String[] args)  
    {  Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    String X = ""; 
        String Y = ""; 
    for(int i=0;i<n;i++){
        int t=sc.nextInt();
        t=t+48;
        X=X+(char)t;
    }
      for(int i=0;i<n;i++){
        int t=sc.nextInt();
        t=t+48;
        Y=Y+(char)t;
    }
        
         
        lcs(X, Y, n, n); 
    } 
} 