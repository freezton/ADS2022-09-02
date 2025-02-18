package by.it.group151002.naftolsky.lesson11;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class Lesson11_Tests {

    @Test(timeout = 2000)
    public void taskA() {
        Graph graph = new Graph(TaskA.AMOUNT_OF_VERTICES);
        graph.setName(0, 'A');
        graph.setName(1, 'B');
        graph.setName(2, 'C');
        graph.setName(3, 'D');
        graph.setName(4, 'E');
        graph.setName(5, 'F');
        graph.setName(6, 'G');
        graph.setName(7, 'H');
        graph.setName(8, 'I');
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(5, 8);
        graph.addEdge(3, 6);
        graph.addEdge(7, 6);
        graph.addEdge(3, 7);

        String expected = "A - B (tree) B - A (back) B - C (tree) C - B (back) C - F (tree) F - C (back) F - E (tree) E - A (back) E - B (back) E - F (back) F - I (tree) I - F (back) \n" +
                          "D - G (tree) G - D (back) G - H (tree) H - D (back) H - G (back) \n";
        TaskA.dfs(graph, 0);
        assertEquals("Failed taskA", expected, TaskA.res);
    }

    @Test(timeout = 2000)
    public void taskB() {
        Graph graph = new Graph(TaskB.AMOUNT_OF_VERTICES);
        graph.setName(0, 'A');
        graph.setName(1, 'B');
        graph.setName(2, 'C');
        graph.setName(3, 'D');
        graph.setName(4, 'E');
        graph.setName(5, 'F');
        graph.setName(6, 'G');
        graph.setName(7, 'H');
        graph.addOrEdge(0, 2);
        graph.addOrEdge(1, 2);
        graph.addOrEdge(2, 3);
        graph.addOrEdge(2, 4);
        graph.addOrEdge(3, 5);
        graph.addOrEdge(4, 5);
        graph.addOrEdge(5, 6);
        graph.addOrEdge(5, 7);
        String expected = "[B, A, C, E, D, F, H, G]";
        TaskB.sort(graph, 0);
        assertEquals("Failed taskB", expected, TaskB.topological.toString());
    }

    @Test(timeout = 2000)
    public void taskC() {
        Graph graph = new Graph(TaskC.VERTICES);
        graph.setName(0, 'A');
        graph.setName(1, 'B');
        graph.setName(2, 'C');
        graph.setName(3, 'D');
        graph.setName(4, 'E');
        graph.setName(5, 'F');
        graph.setName(6, 'G');
        graph.setName(7, 'H');
        graph.addOrEdge(0, 2);
        graph.addOrEdge(1, 2);
        graph.addOrEdge(2, 3);
        graph.addOrEdge(2, 4);
        graph.addOrEdge(3, 5);
        graph.addOrEdge(4, 5);
        graph.addOrEdge(5, 6);
        graph.addOrEdge(5, 7);
        TaskC.sort(graph);
        List<Character> expectedSources = new ArrayList<>();
        expectedSources.add('A');
        expectedSources.add('B');
        assertEquals("Failed taskC", expectedSources, TaskC.sinkAndSources(graph));
    }
}
