import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    public void findOrderTest1() {
        int numCourses = 2;
        int[][] prerequisites = {
                {1, 0}
        };
        int[] expected = {0, 1};
        int[] actual = new Solution().findOrder(numCourses, prerequisites);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findOrderTest2() {
        int numCourses = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };
        int[] expected = {0, 2, 1, 3};
        int[] actual = new Solution().findOrder(numCourses, prerequisites);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findOrderTest3() {
        int numCourses = 1;
        int[][] prerequisites = {};
        int[] expected = {0};
        int[] actual = new Solution().findOrder(numCourses, prerequisites);
        Assertions.assertArrayEquals(expected, actual);
    }
}
