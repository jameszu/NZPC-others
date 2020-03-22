import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Solution to Illiteracy.
 * 
 * This puzzle consists of a board with 8 positions in a row.
 * Each position holds an icon, You can 'push' an icon and it has an effect 
 * on some other icons on the board. The goal is to get all of the icons
 * the same, and repeat for each icon.
 * 
 * There are six icons, which we'll label A through F. 
 * Here's what they do:
 * A: Rotate the icon immediately to the left and right.
 * B: If not on the end, change the icon immediately to the right to be same as the one immediately to the left (do nothing on the ends).
 * C: Rotate the mirror image (if in position x, rotate 9-x. e.g. 1 rotates 8, 2 rotates 7, and so on.)
 * D: Rotate all of the icons between this one and the closest end. (e.g. 3 rotates 1 and 2, 5 rotates 6, 7 and 8. The ends do nothing.)
 * E: Rotate the closest end, and also the position which is the same distance in the opposite direction. (e.g. 1 does nothing, 2 rotates 1 and 3, 3 rotates 1 and 5, 5 rotates 8 and 2, 7 rotates 8 and 6, etc.)
 * F: Each position rotates another position with this pattern: 1->5, 2->1, 3->6, 4->2, 5->7, 6->3, 7->8, 8->4. In other words, the odd positions go to (x-1)/2+5, the evens go to x/2.
 * 
 * Note that this description assumes that the board is numbered 1-8. In the code, it'll be 0-7.
 * Also, we'll use 0-5 instead of A-F for the icons.
 * 
 * We'll use a Breadth-First Search to generate all possible board positions. 
 * There are only 6^8 of them. That's less than 1.7 million.
 */
public class illiteracy_vanb
{    
    /** Input. */
    private static Scanner sc;
    
    /** Output. */
    private static PrintStream ps;
    
    /**
     * Rotate to the next icon.
     *
     * @param board the board
     * @param pos the position to rotate
     */
    private void next( byte[] board, int pos )
    {
        if( pos>=0 && pos<board.length ) board[pos] = (byte)((board[pos]+1) % 6);    
    }
    
    /**
     * 'Push' an icon at the given position.
     *
     * @param original the original board layout
     * @param pos the position to push
     * @return A new board layout
     */
    private byte[] push( byte[] original, int pos )
    {
        // The result of the push
        byte result[] = Arrays.copyOf( original, 8 );
        
        switch( original[pos] )
        {
            // Icon A: Rotate the icon immediately to the left and right.
            case 0: 
            {
                next( result, pos-1 );
                next( result, pos+1 );
                break;
            }
            
            // Icon B: If not on the end, change the icon immediately to the right to be same as the one immediately to the left (do nothing on the ends).
            case 1:
            {
                if( pos>0 && pos<7 ) result[pos+1] = result[pos-1];
                break;
            }
            
            // Icon C: Rotate the mirror image (if in position x, rotate 9-x. e.g. 1 rotates 8, 2 rotates 7, and so on.)
            // 0-based, that means that 0 rotates 7, 1 rotates 6, etc.
            case 2:
            {
                next( result, 7-pos );
                break;
            }
            
            // Icon D: Rotate all of the icons between this one and the closest end. 
            // (e.g. 3 rotates 1 and 2, 5 rotates 6, 7 and 8. The ends do nothing.)
            // 0-based, that means that 2 rotates 0 and 1, 4 rotates 5, 6, 7.
            case 3:
            {
                if( pos<4 ) for( int i=0; i<pos; i++ ) next( result, i );
                else for( int i=pos+1; i<result.length; i++ ) next( result, i );
                break;
            }
            
            // Icon E: Rotate the closest end, and also the position which is the same distance in the opposite direction. 
            // (e.g. 1 does nothing, 2 rotates 1 and 3, 3 rotates 1 and 5, 5 rotates 8 and 2, 7 rotates 8 and 6, etc.)
            // 0-based, that means that 0 does nothing, 1 rotates 0 and 2, 2 rotates 0 and 4, 4 rotates 7 and 1, 6 rotates 7 and 5, etc.
            case 4:
            {
                if( pos>0 && pos<4 ) { next( result, 0 ); next( result, pos+pos ); }
                else if( pos>3 && pos<7 ) { next( result, 7 ); next( result, pos+pos-7 ); }
                break;
            }
            
            // Icon F: Each position rotates another position with this pattern: 1->5, 2->1, 3->6, 4->2, 5->7, 6->3, 7->8, 8->4. 
            // In other words, the odd positions go to (x-1)/2+5, the evens go to x/2.
            // 0-based, that means that the evens go to x/2+4, the odds got to x/2 (integer math!)
            case 5:
            {
                next( result, pos%2==0 ? pos/2+4 : pos/2 );
                break;
            }
            
            default: break;
        }
        
        return result;
    }
    
    /** Which board configurations have we already seen? */
    private boolean visited[][][][][][][][] = new boolean[6][6][6][6][6][6][6][6];
    
    /**
     * Checks if a board position has already been visited.
     *
     * @param a the board
     * @return true, if visited
     */
    private boolean isvisited( byte a[] )
    {
        return visited[a[0]][a[1]][a[2]][a[3]][a[4]][a[5]][a[6]][a[7]];
    }
    
    /**
     * Mark a board position as visited.
     *
     * @param a the board position
     */
    private void visit( byte a[] )
    {
        visited[a[0]][a[1]][a[2]][a[3]][a[4]][a[5]][a[6]][a[7]] = true;
    }
    
    /** The target. */
    private byte[] target;
    
    /**
     * A State of a breadth-first search.
     */
    private class State
    {
        
        /** The board position. */
        public byte board[];
        
        /** The number of moves that got us here. */
        public int moves;
        
        /**
         * Instantiates a new state.
         *
         * @param board the board position
         * @param moves the moves that got us here
         */
        public State( byte board[], int moves )
        {
            this.board = board;
            this.moves = moves;
        }
        
        /**
         * Determine if this is a Solved board position (all icons the same).
         *
         * @return true, if solved
         */
        public boolean solved()
        {
            return board[0]==target[0] && board[1]==target[1] && board[2]==target[2] 
                && board[3]==target[3] && board[4]==target[4] && board[5]==target[5] 
                && board[6]==target[6] && board[7]==target[7];
        }
    }
    
    /** The queue. */
    private ArrayDeque<State> queue = new ArrayDeque<State>(1700000); 
   
    /**
     * Do it.
     */
    private void doit()
    {
        char s[] = sc.next().toCharArray();
        char t[] = sc.next().toCharArray();
        
        byte start[] = new byte[8];
        for( int i=0; i<8; i++ ) start[i] = (byte)(s[i]-'A');
        target = new byte[8];
        for( int i=0; i<8; i++ ) target[i] = (byte)(t[i]-'A');
        
        queue.clear();    
        
        visited = new boolean[6][6][6][6][6][6][6][6];
        
        // The starting state!
        queue.add( new State( start, 0 ) );
        visit( start );    
        
        int nmoves = -1;
        
        // Go!
        while( !queue.isEmpty() )
        {
            State state = queue.poll();    
            
            if( state.solved() )
            {
                nmoves = state.moves;
                break;
            }
                                   
            // See what happens when we 'push' the icons at each of the 8 board positions
            for( int pos=0; pos<8; pos++ )
            {
                byte newboard[] = push( state.board, pos );
                
                // If we haven't seen it before, mark it as Visited and put it on the queue
                if( !isvisited( newboard ) )
                {
                    visit( newboard );
                    queue.add( new State( newboard, state.moves+1 ) );
                }
            }
        }
        
        ps.println( nmoves );
    }
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main( String[] args )
    {
        sc = new Scanner( System.in );
        ps = System.out;
        
        new illiteracy_vanb().doit();    
    }
}
