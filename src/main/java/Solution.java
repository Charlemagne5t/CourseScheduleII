import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adjacencyList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] visited = new int[numCourses];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if(!dfs(adjacencyList, i, visited, result)){
                return new int[]{};
            }
        }
        int[] resArray = new int[numCourses];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }

        return resArray;
    }
    private boolean dfs(List<List<Integer>> adjacencyList, int course, int[] visited, List<Integer> result){
        if(visited[course] == 2){
            return true;
        }

        if(visited[course] == 1){
            return false;
        }

        visited[course] = 1;

        for (int i = 0; i < adjacencyList.get(course).size(); i++) {
            if(!dfs(adjacencyList, adjacencyList.get(course).get(i), visited, result)){
                return false;
            }
        }
        visited[course] = 2;
        result.add(course);

        return true;
    }
}
