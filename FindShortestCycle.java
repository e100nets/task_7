package ilya.ignatov;

import java.util.Stack;

public class FindShortestCycle {
    private Stack<Integer> cycle;
    private int length;

    public FindShortestCycle(Digraph graph) throws Exception {
        Digraph reverse = graph.reverse();
        length = graph.vertexCount() + 1;

        for (int i = 0; i < reverse.vertexCount(); i++) {
            BreadthFirstSearch bfs = new BreadthFirstSearch(reverse, i);
            for (int j : graph.adjacencies(i)) {
                if(bfs.hasPathTo(j) && (bfs.distantionTo(j) + 1) < length) {
                    length = bfs.distantionTo(j) + 1;
                    cycle = new Stack<>();
                    for (int k : bfs.pathTo(j)) {
                        cycle.push(k);
                    }
                }
            }
        }
    }

    public boolean hasCycle () {
        return cycle != null;
    }

    public Stack<Integer> cycle() {
        return cycle;
    }

}
