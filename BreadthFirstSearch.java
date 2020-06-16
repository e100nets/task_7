package ilya.ignatov;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearch {
    private boolean[] visited;
    private int[] distantionTo;
    private int[] lastVertex;

    public BreadthFirstSearch(Digraph graph, int v) {
        visited = new boolean[graph.vertexCount()];
        distantionTo = new int[graph.vertexCount()];
        lastVertex = new int[graph.vertexCount()];
        for (int i = 0; i < graph.vertexCount(); i++) {
            distantionTo[i] = Integer.MAX_VALUE;
        }
        bfs(graph, v);
    }

    public boolean hasPathTo (int v) {
        return visited[v];
    }

    public int distantionTo (int v) {
        return distantionTo[v];
    }

    public Iterable<Integer> pathTo (int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack <Integer> path = new Stack<>();
        int i;
        for (i = v; distantionTo[i]!=0; i = lastVertex[i]) {
            path.push(i);
        }
        path.push(i);
        return path;
    }

    private void bfs (Digraph graph, int from) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        visited[from] = true;
        distantionTo[from] = 0;
        while (queue.size() > 0) {
            Integer current = queue.remove();
            for (Integer i : graph.adjacencies(current)) {
                if (!visited[i]) {
                    visited[i] = true;
                    distantionTo[i] = distantionTo[current] + 1;
                    lastVertex[i] = current;
                    queue.add(i);
                }
            }
        }
    }
}
