import org.example.Solution;
import org.junit.Assert;
import org.junit.Test;

public class TestSolution {
    @Test
    public void isBipartiteTest1() {
        int[][] graph = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };
        Assert.assertFalse(new Solution().isBipartite(graph));
    }

    @Test
    public void isBipartiteTest2() {
        int[][] graph = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };
        Assert.assertTrue(new Solution().isBipartite(graph));
    }
}
