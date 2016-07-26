package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yufeijiang on 7/25/16.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null){
            return null;
        }
        Map<Integer, UndirectedGraphNode> map=new HashMap();
        return helper(node, map);

    }
    public UndirectedGraphNode helper(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map){
        if(node==null){
            return null;
        }
        if(!map.containsKey(node.label)){
            UndirectedGraphNode undirectedGraphNode=new UndirectedGraphNode(node.label);
            map.put(undirectedGraphNode.label, undirectedGraphNode);
            for(UndirectedGraphNode u:node.neighbors){
                undirectedGraphNode.neighbors.add(helper(u,map));
            }
            return undirectedGraphNode;
        }else{
            return map.get(node.label);
        }
    }
}
