/*
 * INSTRUCTIONS:
 *     This is the starting Java code for hw5_1.
 *     Note that the current filename is "Main.java". 
 *     When you finish your development, copy the file.
 *     Then, rename the copied file to "Main_hw5_1.java".
 *     After that, upload the renamed file to Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw5_1.java
 * Abstract: Write the main purpose of the program.
 * ID: 8900
 * Name: Nate Towsley
 * Date: 03/08/2026
 */

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;

class Main {
    static void bfs(ArrayList<ArrayList<Integer>> graph, int src, int degree) {
        Queue<Integer> q = new LinkedList<>();
        int distance = 0;
        ArrayList<Integer> mark = new ArrayList<>(graph.size());
        for (int i = 0; i < graph.size(); i++) {
            mark.add(-1);
        }
        
        mark.set(src, ++distance);
        q.add(src);
        
        while (!q.isEmpty()) {
            int curr = q.peek();
            q.remove();
            System.out.println("visiting: " + curr); 
            
            for (int i = 0; i < graph.get(curr).size(); i++) {
                int neighbor = graph.get(curr).get(i);
                if (mark.get(neighbor) == -1) {
                    mark.set(neighbor, ++distance);
                    q.add(neighbor);
                }
            }
        }

        System.out.println("\n==== Mark Array ==== "); 
    	for (int i = 0; i < graph.size(); i++) {
    		System.out.println("Mark[" + i + "]: " + mark.get(i));
    	}
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        in.nextLine();
        HashMap<String, Integer> names = new HashMap<>();

        // Fill map + create outer arraylists
        for (int i = 0; i < v; i++) {
            names.put(in.nextLine(), i);
            graph.add(new ArrayList<>());
            for (int j = 0; j < v; j++) {
                graph.get(i).add(0);
            }
        }

        int e = in.nextInt();
        in.nextLine();

        for (int i = 0; i < e; i++) {
            String src = in.next();
            String dest = in.next();
            graph.get(names.get(src)).set(names.get(dest), 1);
        }

        String target = in.nextLine();
        int degree = in.nextInt();
        bfs(graph, names.get(target), degree);
        in.close();
    }
}
