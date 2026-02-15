/*
 * INSTRUCTIONS:
 *     This is the starting Java code for hw3_1.
 *     Note that the current filename is "Main.java". 
 *     When you finish your development, copy the file.
 *     Then, rename the copied file to "Main_hw3_1.java".
 *     After that, upload the renamed file to Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main.java
 * Abstract: Write the main purpose of the program.
 * ID: 8900
 * Name: Nate Towsley
 * Date: 02/14/2026
 */
import java.util.ArrayList;
import java.util.Scanner;

class Main 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int e = in.nextInt();

        // Initialize outer array
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(v);

        // Initialize all inner arrays with maxInt;
        for (int i = 0; i < v; i++) {
            ArrayList<Integer> toAdd = new ArrayList<>(3);
            for (int j = 0; j < 3; j++) {
                toAdd.add(0);
            }
            arr.add(toAdd);
        }

        for (int i = 0; i < e; i++) {
            int s = in.nextInt();
            int d = in.nextInt();
            int w = in.nextInt();

            ArrayList<Integer> curr = arr.get(s);

            curr.set(d, w);
        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.print(i);
            ArrayList<Integer> curr = arr.get(i);

            for(int j = 0; j < curr.size(); j++) {
                if (curr.get(j) != 0) {
                    System.out.print("->" + j + "," + curr.get(j));
                }
            }
            System.out.print("\n");
        }


        in.close();
    }
}

