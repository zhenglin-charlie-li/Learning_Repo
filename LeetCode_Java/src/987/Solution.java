import java.util.*;
import java.util.stream.Collectors;
import javafx.util.Pair;
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        Map<Integer, List<Integer>> columnItems = new HashMap<>();
        Queue<Pair<Integer, TreeNode>> queue = new LinkedList<>();
        int min_x = Integer.MAX_VALUE;
        int max_x = Integer.MIN_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        
        queue.offer(new Pair<>(0, root));
        
        while (!queue.isEmpty()) {
            Pair<Integer, TreeNode> pair = queue.poll();
            int x = pair.getKey();
            TreeNode node = pair.getValue();

            List<Integer> list = columnItems.get(x);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(node.val);

            min_x = Math.min(min_x, x);
            max_x = Math.max(max_x, x);
            
            if (node.left != null) {
                queue.offer(new Pair<>(x - 1, node.left));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(x + 1, node.right));
            }
        }
        
        for (int i = min_x; i <= max_x; i++) {
            res.add(columnItems.get(i));
        }
        
        return res;
    }
}
