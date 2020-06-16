package ilya.ignatov;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
         Digraph graph = new Digraph(5);
         graph.addEdge(2, 3);
         graph.addEdge(3, 1);
         graph.addEdge(3, 4);
         graph.addEdge(4, 0);
         graph.addEdge(2, 3);
         graph.addEdge(1, 4);
         graph.addEdge(2, 0);
         graph.addEdge(4, 2);
         graph.addEdge(0, 1);

        FindShortestCycle find = new FindShortestCycle(graph);
        if (find.hasCycle()) {
            Stack<Integer> stack = find.cycle();
            final int count = stack.size();
            System.out.println("Кратчайший цикл:");
            for (int i = 0; i < count; i++) {
                System.out.print(stack.pop() + " ");
            }
        }
        else {
            System.out.println("Нет циклов");
        }
    }
}
