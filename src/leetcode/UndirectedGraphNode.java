package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 7/25/16.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
