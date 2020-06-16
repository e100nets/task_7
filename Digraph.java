package ilya.ignatov;

import java.util.*;

public class Digraph {
    private boolean[][] adjMatrix;
    private int vCount;

    Digraph(int vertexCount) {
        adjMatrix = new boolean[vertexCount][vertexCount];
        vCount = vertexCount;
    }

    public int vertexCount() {
        return vCount;
    }

    public void addEdge(int v1, int v2) throws Exception {
        int maxV = Math.max(v1, v2);
        if (maxV >= vertexCount()) {
            throw new Exception("Вы ввели номер вершины, превышающий число вершин в графе");
        }
        else {
            adjMatrix[v1][v2] = true;
        }
    }

    public void removeEdge(int v1, int v2) {
        if (adjMatrix[v1][v2]) {
            adjMatrix[v1][v2] = false;
        }
    }

    public Digraph reverse() throws Exception {
        Digraph reverse = new Digraph(vertexCount());
        for (int i = 0; i < vertexCount(); i++) {
            for (int j : adjacencies(i)) {
                reverse.addEdge(j, i);
            }
        }
        return reverse;
    }

    public Iterable<Integer> adjacencies(int v) {
        return new Iterable<Integer>() {
            Integer nextAdj = null;

            public Iterator<Integer> iterator() {
                for (int i = 0; i < vCount; i++) {
                    if (adjMatrix[v][i]) {
                        nextAdj = i;
                        break;
                    }
                }

                return new Iterator<Integer>() {
                    public boolean hasNext() {
                        return nextAdj != null;
                    }

                    public Integer next() {
                        Integer result = nextAdj;
                        nextAdj = null;
                        for (int i = result + 1; i < vCount; i++) {
                            if (adjMatrix[v][i]) {
                                nextAdj = i;
                                break;
                            }
                        }
                        return result;
                    }
                };
            }
        };
    }
}
