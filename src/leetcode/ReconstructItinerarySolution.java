package leetcode;

import java.util.*;

/**
 * Created by yufeijiang on 9/21/16.
 */
public class ReconstructItinerarySolution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> list=new ArrayList();
        if(tickets==null || tickets.length==0 || tickets[0].length==0){
            return list;
        }
        Map<String, List<String>> map=new HashMap();
        for(int i=0;i<tickets.length;i++){
            if(map.containsKey(tickets[i][0])){
                map.get(tickets[i][0]).add(tickets[i][1]);
            }else{
                List<String> strList=new LinkedList();
                strList.add(tickets[i][1]);
                map.put(tickets[i][0], strList);
            }
        }
        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            List<String> destinations=entry.getValue();
            Collections.sort(destinations);
        }
        list.add("JFK");
        helper(list, map, tickets);
        return list;
    }
    public void helper(List<String> list, Map<String, List<String>> map, String[][] tickets){
        if(list.size()==tickets.length+1){
            return;
        }
        String currDep=list.get(list.size()-1);
        if(map.get(currDep)!=null){
            List<String> arrivalList=map.get(currDep);
            for(int i=0; i<arrivalList.size(); i++){
                String currArrive=map.get(currDep).get(i);
                list.add(currArrive);
                arrivalList.remove(i);
                helper(list, map, tickets);
                if(list.size()==tickets.length+1){
                    return;
                }
                list.remove(list.size()-1);
                arrivalList.add(i, currArrive);
            }
        }else{
            return;
        }
    }
}
