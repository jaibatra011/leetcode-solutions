class Solution {
    public void clearIsland(char[][] grid, int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0')
            return;
        grid[i][j]='0';
        clearIsland(grid,i+1,j);
        clearIsland(grid,i-1,j);
        clearIsland(grid,i,j+1);
        clearIsland(grid,i,j-1);
    }
    public int numIslands(char[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    clearIsland(grid,i,j);
                }
            }
        }
        return ans;
    }
}