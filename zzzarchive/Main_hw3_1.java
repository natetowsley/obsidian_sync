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
 * Title: Main_hw3_1.java
 * Abstract: Take in number of vertices, number of edges, and rows of relations and weights. Output formatted representation.
 * ID: 8900
 * Name: Nate Towsley
 * Date: 02/14/2026
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Main 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int e = in.nextInt();
        ArrayList<LinkedList<myNode>> adjList = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adjList.add(new LinkedList<>());
        }

        for (int i = 0; i < e; i++) {
            int s = in.nextInt();
            int d = in.nextInt();
            int w = in.nextInt();

            myNode newNode = new myNode(d, w);
            LinkedList<myNode> list = adjList.get(s);

            if (list.isEmpty() || list.getFirst().destination > d) {
                adjList.get(s).addFirst(newNode);
            }
            else {
                int pos = 0;
                boolean added = false;
                Iterator<myNode> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().destination > d) {
                        list.add(pos, newNode);
                        added = true;
                        break;
                    }
                    else {
                        pos++;
                    }
                }
                if (!added) {
                    list.addLast(newNode);
                }
            }
        }

        for (int i = 0; i < adjList.size(); i++) {
            LinkedList<myNode> list = adjList.get(i);
            Iterator<myNode> it = list.iterator();
            System.out.print(i);
            while (it.hasNext()) {
                myNode next = it.next();
                System.out.print("->" + next.destination + "," + next.weight);
            }
            System.out.print("\n");
        }


        in.close();
    }

    static class myNode {
        int destination;
        int weight;

        public myNode(int d, int w) {
            this.destination = d;
            this.weight = w;
        }
    }
}

