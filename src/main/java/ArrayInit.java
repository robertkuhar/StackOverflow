import java.util.*;

public class ArrayInit {
    public int[][] oneArray = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
    public int[][] twoArray = new int[4][2];
    public int[][] threeArray = new int[4][2];
    {
        // you don't usually see it done this way.
        threeArray[0][0] = 0;
        threeArray[0][1] = 0;
        threeArray[1][0] = 0;
        threeArray[1][1] = 1;
        threeArray[2][0] = 1;
        threeArray[2][1] = 0;
        threeArray[3][0] = 1;
        threeArray[3][1] = 1;
    }

    public ArrayInit() {
        twoArray[0][0] = 0;
        twoArray[0][1] = 0;
        twoArray[1][0] = 0;
        twoArray[1][1] = 1;
        twoArray[2][0] = 1;
        twoArray[2][1] = 0;
        twoArray[3][0] = 1;
        twoArray[3][1] = 1;
    }

    public static void main( String[] args ) {
        ArrayInit ai = new ArrayInit();
        System.out.println( Arrays.deepToString( ai.oneArray ) );
        System.out.println( Arrays.deepToString( ai.twoArray ) );
        System.out.println( Arrays.deepToString( ai.threeArray ) );
    }
}
