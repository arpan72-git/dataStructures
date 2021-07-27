import java.util.HashSet;
import java.util.Set;

/**
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */
public class OrangesRotting {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(new OrangesRotting().orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        Set<String> fresh = new HashSet<>();
        Set<String> rotten = new HashSet<>();
        for(int i =0; i<grid.length; i++){
            for(int j=0; j<grid[i].length;j++){
                if(grid[i][j] == 1)
                    fresh.add(""+i+j);
                else if(grid[i][j] == 2)
                    rotten.add(""+i+j);
            }
        }

        int minutes = 0;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        Set<String> infected = new HashSet<>();
        while(fresh.size() > 0){
            infected.clear();
            // Set<String> infected = new HashSet<>();
            for(String s : rotten){
                int i = s.charAt(0) - '0';
                int j = s.charAt(1) - '0';
                for(int[] direction : directions){
                    int nextI = i + direction[0];
                    int nextJ = j + direction[1];
                    if(fresh.contains("" + nextI + nextJ)){
                        fresh.remove("" + nextI + nextJ);
                        infected.add("" + nextI + nextJ);
                    }
                }
            }
            if(infected.size() == 0)
                return -1;

            minutes++;
            rotten.clear(); rotten.addAll(infected);
        }
        return minutes;
    }
}
