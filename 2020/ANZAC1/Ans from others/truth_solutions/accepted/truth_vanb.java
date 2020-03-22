import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution to Liars
 * 
 * @author vanb
 */
public class truth_vanb
{
    
    /** The Input. */
    private static Scanner sc;
    
    /** The Output. */
    private static PrintStream ps;
    
    /**
     * Do it.
     */
    private void doit()
    {
        int n = sc.nextInt();
        int lo[] = new int[n];
        int hi[] = new int[n];
        
        // Read the statements
        for( int i=0; i<n; i++ )
        {
            lo[i] = sc.nextInt();
            hi[i] = sc.nextInt();
        }
        
		// The solution is the largest k for which exactly k intervals contain k
		// If there is no such k, then the answer is -1
        int solution = -1;
        for( int k=n; k>=0 && solution<0; k-- )
        {
            int count=0;
            for( int i=0; i<n; i++ ) if( lo[i]<=k && k<=hi[i] ) ++count;
            if( count==k ) solution = k;
        }
        
        ps.println( solution );
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
        
        new truth_vanb().doit();
    }

}
