package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yufeijiang on 9/27/16.
 */
public class NumberOfIslandsIISolution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res=new ArrayList();
        if(positions==null || positions.length==0 || positions[0].length==0 || m<=0 || n<=0){
            return res;
        }
        int[][] water=new int[m][n];
        int counter=0;
        int numberOfIslands=0;
        for(int i=0;i<positions.length; i++){
            int row=positions[i][0];
            int column=positions[i][1];
            List<Integer> list=new ArrayList();
            Set<Integer> set=probe(water, row, column, m, n);
            //System.out.println(set.size());
            list.addAll(set);
            if(list.size()==0){
                counter++;
                numberOfIslands++;
                water[row][column]=counter;
            }
            if(list.size()==1){
                water[row][column]=list.get(0);
            }
            if(list.size()>1){
                //System.out.println(list.size()-1);
                numberOfIslands=numberOfIslands-(list.size()-1);
                int min=Integer.MAX_VALUE;
                for(Integer num: list){
                    min=Math.min(min, num);
                }
                //System.out.println(min);
                water[row][column]=min;
                dfsChange(min, water, row+1, column, m, n);
                dfsChange(min, water, row-1, column, m, n);
                dfsChange(min, water, row, column+1, m, n);
                dfsChange(min, water, row, column-1, m, n);
            }
            res.add(numberOfIslands);
        }
        return res;
    }

    public void dfsChange(int toBeNumber, int[][] water, int row, int column, int m, int n){
        if(row>=m || row<0 || column>=n || column<0 ){
            return;
        }
        //System.out.println(water[row][column]);
        if(water[row][column]>toBeNumber){
            water[row][column]=0;
            dfsChange(toBeNumber, water, row+1, column, m, n);
            dfsChange(toBeNumber, water, row-1, column, m, n);
            dfsChange(toBeNumber, water, row, column+1, m, n);
            dfsChange(toBeNumber, water, row, column-1, m, n);
            water[row][column]=toBeNumber;
        }
    }

    public Set<Integer> probe(int[][] water, int row, int column, int m, int n){
        Set<Integer> set=new HashSet();
        if(row+1<m && water[row+1][column]>0){
            //System.out.println(water[row+1][column]);
            set.add(water[row+1][column]);
        }
        if(row-1>=0 && water[row-1][column]>0){
            //System.out.println(water[row-1][column]);
            set.add(water[row-1][column]);
        }
        if(column+1<n && water[row][column+1]>0){
            //System.out.println(water[row][column+1]);
            set.add(water[row][column+1]);
        }
        if(column-1>=0 && water[row][column-1]>0){
            //System.out.println(water[row][column-1]);
            set.add(water[row][column-1]);
        }
        return set;
    }
}
