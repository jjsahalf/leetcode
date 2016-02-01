package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 2/1/16.
 */
public class PascalTriangleSolution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> list=new ArrayList();
        List<List<Integer>> listOfList=new ArrayList();

        if(numRows<=0){
            return listOfList;
        }

        list.add(1);
        listOfList.add(list);

        for(int j=0;j<numRows-1;j++){
            list=listOfList.get(j);
            List<Integer> newList=new ArrayList();
            for(int i=-1;i<list.size();i++){
                if(i==-1){
                    newList.add(list.get(0));
                    continue;
                }
                if(i==list.size()-1){
                    newList.add(list.get(list.size()-1));
                    continue;
                }
                newList.add(list.get(i)+list.get(i+1));
            }

            listOfList.add(newList);
        }
        return listOfList;
    }



}
