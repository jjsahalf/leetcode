public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid==null){
            return 0;
        }
        if(grid.length==0){
            return 0;
        }
        if(grid[0].length==0){
            return 0;
        }
        
        int counter=0;
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    counter++;
                    removeIsland(grid,i,j);
                }
            }
        }
        
        return counter;
    }
    
    public void removeIsland(char grid[][], int row, int column){
        if(grid[row][column]=='1'){
            grid[row][column]='0';
        }else{
            return;
        }
        
        if(isInside(grid,row-1,column)){
            removeIsland(grid,row-1,column);
        }
        if(isInside(grid,row+1,column)){
            removeIsland(grid,row+1,column);
        }
        if(isInside(grid,row,column-1)){
            removeIsland(grid,row,column-1);
        }
        if(isInside(grid,row,column+1)){
            removeIsland(grid,row,column+1);
        }
        
    }
    
    public boolean isInside(char[][] grid, int row, int column){
        if(row>=0 && row<grid.length && column>=0 && column < grid[0].length){
            return true;
        }else{
            return false;
        }
    }
    
    
}