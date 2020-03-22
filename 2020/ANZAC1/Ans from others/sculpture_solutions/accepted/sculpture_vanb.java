import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution to Sculpture
 * 
 * @author vanb
 */
public class sculpture_vanb
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
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        // Read the sculpture
        int sculpture[][] = new int[r][c];
        for( int i=0; i<r; i++ ) for( int j=0; j<c; j++ ) sculpture[i][j] = sc.nextInt();
        
        // Print the top row, which will never have a drain
        for( int j=0; j<c; j++ ) ps.print( j==0?"0":" 0");
        ps.println();
        
        for( int i=1; i<r-1; i++ )
        {
            // Print the first column which will never have a drain
            ps.print( "0" );
            
            // Go through the other columns
            for( int j=1; j<c-1; j++ )
            {
                // A test for the judges to make sure the data is clean
                if(sculpture[i][j]==sculpture[i-1][j]
                    || sculpture[i][j]==sculpture[i+1][j]
                    || sculpture[i][j]==sculpture[i][j-1]
                    || sculpture[i][j]==sculpture[i][j+1]) System.err.println( "PANIC!!" );
                
                // Look up, down, left, right
                ps.print( (sculpture[i][j]<sculpture[i-1][j]
                    && sculpture[i][j]<sculpture[i+1][j]
                    && sculpture[i][j]<sculpture[i][j-1]
                    && sculpture[i][j]<sculpture[i][j+1] ? " 1" : " 0" ) ); 
            }
            
            // The last columns will never have a drain
            ps.println( c>1 ? " 0" : "" );
        } 
        
        // The last row will never have a drain
        if( r>1 ) for( int j=0; j<c; j++ ) ps.print( j==0?"0":" 0");
        if( r>1 ) ps.println();    
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
        
        new sculpture_vanb().doit();
    }

}
