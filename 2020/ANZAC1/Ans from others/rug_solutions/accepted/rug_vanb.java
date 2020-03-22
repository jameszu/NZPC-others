import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution to Square Counting
 * 
 * @author vanb
 */
public class rug_vanb
{
    
    /** Input. */
    private static Scanner sc;
    
    /** Output. */
    private static PrintStream ps;
    
    /** sums[i][j] is the count of all dirty squares in the rectangle from (0,0) to (i,j) */
    private int sums[][];
    
    /**
     * Get sum[i][j], or 0 if i or j are out of bounds.
     *
     * @param i row
     * @param j column
     * @return sum[i][j], or 0 if i or j are out of bounds
     */
    private int sum( int i, int j )
    {
        return i<0 || j<0 ? 0 : sums[i][j];
    }
    
    /**
     * Do it.
     */
    private void doit()
    {
        int n = sc.nextInt();
        int s = sc.nextInt();
        
        // Read the grid
        char grid[][] = new char[n][];
        for( int i=0; i<n; i++ ) grid[i] = sc.next().toCharArray();
        
        // Compute sums
        // Remember, sums[i][j] is the sum of all dirty squares from (0,0) to (i,j)
        sums = new int[n][n];
        for( int i=0; i<n; i++ ) 
        {
            Arrays.fill( sums[i], 0 );
            for( int j=0; j<n; j++ )
            {
                sums[i][j] = sum(i-1,j) + sum(i,j-1) - sum(i-1,j-1);
                if( grid[i][j]=='D' ) ++sums[i][j];
            }
        }
        
        // Here are the counts
        int counts[] = new int[s*s+1];
        Arrays.fill( counts, 0 );
        
        // Compute the counts
        for( int i=s-1; i<n; i++ ) for( int j=s-1; j<n; j++ )
        {
            ++counts[sums[i][j] - sum(i-s,j) - sum(i,j-s) + sum(i-s,j-s)];
        }

        for( int i=0; i<counts.length; i++ ) if( counts[i]>0 ) ps.println( i + " " + counts[i] );       
    }
        
    /**
     * The main method.
     *
     * @param args the arguments
     * @throws Exception the exception
     */
    public static void main( String[] args ) throws Exception
    {
        sc = new Scanner( System.in );
        ps = System.out;
        
        new rug_vanb().doit();
    }

}
