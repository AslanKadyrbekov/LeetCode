class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int q = grid.length;
        int w = grid[0].length;
        int count = 0;
        for (int i=0; i<q; ++i) {
            for (int j=0; j<w; ++j) {
                if (grid[i][j] == '1') {
                    ++count;
                    merge(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public void merge(char[][] grid, int i, int j) {
        int q = grid.length;
        int w = grid[0].length;
        if (i < 0 || i >= q || j < 0 || j >= w || grid[i][j] != '1')
            return;
        grid[i][j] = 'X';
        merge(grid, i-1, j);
        merge(grid, i+1, j);
        merge(grid, i, j-1);
        merge(grid, i, j+1);
    }
}
