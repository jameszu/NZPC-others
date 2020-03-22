
import java.util.*;
import java.io.*;

public class Sculpture_font
{
   public static void main(String[] args) throws Exception
   {
      PrintWriter out = new PrintWriter(System.out);
      new Sculpture_font(new FastScanner(System.in), out);
      out.close();
   }

   int N, M;
   int[][] grid;
   int[] dr = {-1, 0, 1, 0};
   int[] dc = {0, 1, 0, -1};

   public Sculpture_font(FastScanner in, PrintWriter out)
   {
      N = in.nextInt();
      M = in.nextInt();
      grid = new int[N][M];

      for (int i=0; i<N; i++)
         for (int j=0; j<M; j++)
            grid[i][j] = in.nextInt();
   
      for (int i=0; i<N; i++)
      {
         StringBuilder sb = new StringBuilder();
         for (int j=0; j<M; j++)
         {
            int neighborCount = 0;
            for (int u=0; u<4; u++)
            {
               int ni = i+dr[u];
               int nj = j+dc[u];
               if (0 <= ni && ni < N &&
                   0 <= nj && nj < M &&
                   grid[ni][nj] > grid[i][j])
               {
                  neighborCount++; 
               }
            }
            
            if (neighborCount == 4)
               sb.append(1);
            else
               sb.append(0);
            
            sb.append(' '); 
         }
         out.println(sb.toString().trim());
      }
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
