/*
 * A slower solution but still one in the strikezone.
 *
 * Idea: Precompute some row sums for each row.
 * Use the precomputed row sums to compute column sums.
 * 
 * Runtime: O(S*N^2)
 *
 */

import java.util.*;
import java.io.*;

public class Rug_font
{
   public static void main(String[] args) throws Exception
   {
      PrintWriter out = new PrintWriter(System.out);
      new Rug_font(new FastScanner(System.in), out);
      out.close();
   }

   public Rug_font(FastScanner in, PrintWriter out)
   {
      int N = in.nextInt();
      int S = in.nextInt();

      char[][] grid = new char[N][];
      for (int i=0; i<N; i++)
         grid[i] = in.next().toCharArray();
   
      int[][] rowSums = new int[N][N-S+1];
      for (int i=0; i<N; i++)
      {
         for (int j=0; j+S<=N; j++)
         {
            for (int k=0; k<S; k++)
            {
               int c = grid[i][j+k] == 'D' ? 1 : 0;
               rowSums[i][j] += c;
            }
         }
      }

      int[] squareSums = new int[S*S+1];
      for (int i=0; i+S<=N; i++)
      {
         for (int j=0; j+S<=N; j++)
         {
            int count = 0;
            for (int k=0; k<S; k++)
               count += rowSums[i+k][j];
            squareSums[count]++;
         }
      }

      for (int k=0; k<squareSums.length; k++)
         if (squareSums[k] > 0)
            out.printf("%d %d%n", k, squareSums[k]);
   }
}

class FastScanner
{
   private InputStream stream;
   private byte[] buf = new byte[1024];
   private int curChar;
   private int numChars;
    
   public FastScanner(InputStream stream)
   {
      this.stream = stream;
   }
    
   int read()
   {
      if (numChars == -1)
         throw new InputMismatchException();
      if (curChar >= numChars)
      {
         curChar = 0;
         try
         {
            numChars = stream.read(buf);
         } 
         catch (IOException e) 
         {
            throw new InputMismatchException();
         }
         
         if (numChars <= 0)
            return -1;
      }
      return buf[curChar++];
   }
    
   boolean isSpaceChar(int c)
   {
      return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;
   }
   
   boolean isEndline(int c)
   {
      return c=='\n'||c=='\r'||c==-1;
   }
   
   int nextInt()
   {
      return Integer.parseInt(next());
   }
   
   long nextLong()
   {
      return Long.parseLong(next());
   }
   
   double nextDouble()
   {
      return Double.parseDouble(next());
   }
   
   String next()
   {
      int c = read();
      while (isSpaceChar(c))
         c = read();
      StringBuilder res = new StringBuilder();
      do
      {
         res.appendCodePoint(c);
         c = read();
      } while(!isSpaceChar(c));
      return res.toString();
   }
   
   String nextLine()
   {
      int c = read();
      while (isEndline(c))
         c = read();
      
      StringBuilder res = new StringBuilder();
      do
      {
         res.appendCodePoint(c);
         c = read();
      } while(!isEndline(c));
      return res.toString();
   }
}
