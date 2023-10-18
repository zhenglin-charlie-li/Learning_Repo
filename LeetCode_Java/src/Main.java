import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Main {

    public static int hashFunction(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash += (i + 1) * (s.charAt(i) - 'a' + 1);
        }
        return hash;
    }

    public static void main(String[] args) {

//        Problem1094.main();
    }
}

class Problem1094 {
    public static void main() {
        Deque<Integer> deque = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        new Problem1094().test();
    }

    public void test() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.addWord("pad");
        wordDictionary.addWord("bad");
        wordDictionary.search(".ad");
        wordDictionary.search("b..");

        SolutionTreeNode.TreeNode node5 = new SolutionTreeNode.TreeNode(5);
        SolutionTreeNode.TreeNode node4 = new SolutionTreeNode.TreeNode(4);
        SolutionTreeNode.TreeNode node3 = new SolutionTreeNode.TreeNode(3, node4, node5);
        SolutionTreeNode.TreeNode node2 = new SolutionTreeNode.TreeNode(2);
        SolutionTreeNode.TreeNode node1 = new SolutionTreeNode.TreeNode(1, node2, node3);
        SolutionTreeNode.inorderTraversal(node1);

//        new Solution().longestWord(new String[]{"w", "wo", "wor", "worl", "world"});
    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resList = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        // 找到首个可以和新区间合并的区间，即和新区见不重叠的区间都直接加入列表
        while (i < n && intervals[i][1] < newInterval[0])
            resList.add(intervals[i++]);
        // 找到所有可以和新区间重叠的区间并合并
        while (i < n && newInterval[1] >= intervals[i][0]) {
            // 当前区间和合并区间有重叠的，更新区间的起点和终点
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        resList.add(new int[]{newInterval[0], newInterval[1]});     // 将合并区间加入列表
        return resList.toArray(new int[resList.size()][]);
    }
}

class SolutionTreeNode {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    public void dfs(TreeNode root, int level, List<Integer> result) {
        if (root == null) {
            return;
        }
        // left
        dfs(root.left, level + 1, result);
        // process
        if (result.size() < level) {
            result.add(root.val);
        } else {
            Integer integer = result.get(level);
            integer = new Integer(level);
        }
        //right
        dfs(root.right, level + 1, result);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        Collections.reverse(new ArrayList<>());

        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            // left
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // root
            node = stack.pop();
            list.add(node.val);
            // right
            node = node.right;
        }
        return list;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class WordDictionary {
    class TreeNode {
        boolean end;
        TreeNode[] next;

        public TreeNode() {
            end = false;
            next = new TreeNode[26];
        }
    }

    TreeNode root;

    public WordDictionary() {
        root = new TreeNode();
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        TreeNode p = root;
        for (char ch : chars) {
            if (p.next[ch - 'a'] == null) {
                p.next[ch - 'a'] = new TreeNode();
            }
            p = p.next[ch - 'a'];
        }
        p.end = true;
    }

    public boolean search(String word, int i, TreeNode root) {
        if (root == null) {
            return false;
        }
        if (i == word.length()) {
            return root.end;
        }
        if (word.charAt(i) != '.') {
            if (root.next[word.charAt(i) - 'a'] != null) {
                return search(word, i + 1, root.next[word.charAt(i) - 'a']);
            }
        } else {
            boolean res = false;
            for (int j = 0; j < 26; j++) {
                if (root.next[j] != null) {
                    res = res || search(word, i + 1, root.next[j]);
                }
            }
            return res;
        }
        return false;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

class Twitter {
    // map follow
    // timestampe

    // key: userId value: userIds
    Map<Integer, Set<Integer>> followMap;
    // key: userId
    // value: key: timestampe value: twettId
    Map<Integer, Map<Integer, Integer>> postsMap;
    int timestampe;

    // feed limit
    int FEED_LIMIT = 10;

    public Twitter() {
        followMap = new HashMap<>();
        postsMap = new HashMap<>();
        timestampe = 0;
    }

    public void postTweet(int userId, int tweetId) {
        Map<Integer, Integer> integerIntegerMap = postsMap.get(userId);
        if (integerIntegerMap == null) {
            integerIntegerMap = new HashMap<>();
        }
        postsMap.get(userId).put(++timestampe, tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> followees = followMap.get(userId);
        followees.add(userId);
        int latestTimestampe = timestampe;
        int oldestTimestampe = latestTimestampe - FEED_LIMIT + 1;
        for (Integer i : followees) {
            for (Integer integer : postsMap.get(i).keySet()) {
                if (integer <= latestTimestampe && integer >= oldestTimestampe) {
                    res.add(postsMap.get(i).get(integer));
                }
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> integers = followMap.get(followerId);
        if (integers == null) {
            integers = new HashSet<>();
        }
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */