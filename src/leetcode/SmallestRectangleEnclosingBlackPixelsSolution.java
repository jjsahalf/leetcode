package leetcode;

/**
 * Created by yufeijiang on 10/28/16.
 */
public class SmallestRectangleEnclosingBlackPixelsSolution {
    public int minArea(char[][] image, int x, int y) {
        if(image==null || image.length==0 || image[0].length==0){
            return 0;
        }
        int col=y;
        int row=x;
        int minX=findMinX(0,col,image);
        int maxX=findMaxX(col,image[0].length-1, image);
        int minY=findMinY(0, row, image);
        int maxY=findMaxY(row, image.length-1, image);
        return (maxX-minX+1)*(maxY-minY+1);
    }
    public int findMinX(int start, int end, char[][] image){
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(colContainsBlackPixel(mid, image)){

                end=mid;
            }else{
                start=mid;
            }
        }
        if(colContainsBlackPixel(start, image)){
            return start;
        }else{
            return end;
        }
    }
    public int findMaxX(int start, int end, char[][] image){
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(colContainsBlackPixel(mid, image)){
                start=mid;
            }else{
                end=mid;
            }
        }
        if(colContainsBlackPixel(end, image)){
            return end;
        }else{
            return start;
        }
    }
    public int findMinY(int start, int end, char[][] image){
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(rowContainsBlackPixel(mid, image)){
                end=mid;
            }else{
                start=mid;
            }
        }
        if(rowContainsBlackPixel(start, image)){
            return start;
        }else{
            return end;
        }
    }
    public int findMaxY(int start, int end, char[][] image){
        while(start+1<end){
            int mid=start+(end-start)/2;
            System.out.println("2 "+mid);
            if(rowContainsBlackPixel(mid, image)){
                start=mid;
            }else{
                end=mid;
            }
        }
        //System.out.println("2 "+end);
        if(rowContainsBlackPixel(end, image)){
            return end;
        }else{
            return start;
        }
    }
    public boolean colContainsBlackPixel(int col, char[][] image){
        for(int i=0;i<image.length;i++){
            if(image[i][col]=='1'){
                return true;
            }
        }
        return false;
    }
    public boolean rowContainsBlackPixel(int row, char[][] image){
        for(int i=0; i<image[0].length;i++){
            if(image[row][i]=='1'){
                return true;
            }
        }
        return false;
    }
}
