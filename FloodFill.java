import java.util.Scanner;
import java.util.Arrays;
 
public class FloodFill
{
    private void fillG(char[][] arr, int r, int c) 
    {
        if (arr[r][c] == 'P')
        {
            arr[r][c] = 'W';
            display(arr);
 
            fillG(arr, r + 1, c);
            fillG(arr, r - 1, c);
            fillG(arr, r, c + 1);
            fillG(arr, r, c - 1);
        }
    }
   
    /** Main method **/
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner( System.in );        
        System.out.println("Flood Fill Test\n");
 
        /** Accept dimensions for the matrix**/
        System.out.println("Enter dimensions of grid");
        int M = scan.nextInt();
        int N = scan.nextInt();
 
        /** make grid with border as obstacle**/
        char[][] arr = new char[M + 2][N + 2];
        for (int i = 0; i < M + 2; i++)
            Arrays.fill(arr[i], 'O');
 
        /** Accepting the grid **/
        System.out.println("Enter grid with 'P' for path and 'O' for obstacle");
 
        for (int i = 1; i < M + 1; i++)
            for (int j = 1; j < N + 1; j++)
                arr[i][j] = scan.next().charAt(0);    
 
        System.out.println("Enter coordinates to start with ");
        int sr = scan.nextInt();
        int sc = scan.nextInt();
 
        if (arr[sr][sc] != 'P')
        {
            System.out.println("Invalid coordinates");
            System.exit(0);
        }
 
        FloodFill ff = new FloodFill();
        ff.fillG(arr, sr, sc);    
 
    }  
    private void display(char[][] arr)
    {
        System.out.println("\nGrid : ");
        for (int i = 1; i < arr.length - 1; i++)
        {
            for (int j = 1; j < arr[i].length - 1; j++)
                System.out.print(arr[i][j] +" ");
            System.out.println();
        }
    }  
}