class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
    
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[] {i, j, 0});
                   
                }
            }
        }
         bfs( m, n, grid,  queue);
    }

    public void bfs(int m, int n, int[][] grid, Queue<int[]> queue) {
   

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();

            for (int del_i = -1; del_i <= 1; del_i++) {
                for (int del_j = -1; del_j <= 1; del_j++) {
                    if (Math.abs(del_i) + Math.abs(del_j) != 1) {
                        continue;
                    }

                    int new_i = arr[0] + del_i;
                    int new_j = arr[1] + del_j;
                    if (new_i >= 0 && new_i < m && new_j >= 0 && new_j < n
                        && grid[new_i][new_j] == Integer.MAX_VALUE) {
                        grid[new_i][new_j] = arr[2] + 1;
                      
                        queue.offer(new int[] {new_i, new_j, grid[new_i][new_j]});
                    }
                }
            }
        }
    }
}
