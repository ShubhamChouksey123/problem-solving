1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17
18    private void swapChildNodeValues(TreeNode node){
19
20        if(node.left == null){
21            return;
22        }
23        TreeNode tmp = node.left;
24        node.left = node.right;
25        node.right = tmp;
26    }
27
28    public TreeNode reverseOddLevels(TreeNode root) {
29
30        Deque<TreeNode> queue = new ArrayDeque<>();
31        queue.add(root);
32        int level = 0, startIndex = 0;
33        List<List<Integer>> values = new ArrayList<>();
34        levelOrder(root, values, 0);
35
36
37        while(!queue.isEmpty()){
38
39            int size = queue.size();
40            int endIndex = startIndex + size - 1;
41            for(int i = 0 ; i < size ; i++){
42                TreeNode node = queue.pollFirst();
43
44                if(level % 2 != 0) {
45                    node.val = values.get(level).get(size - i - 1);
46                }else{
47                    node.val = values.get(level).get(i);
48                }
49                
50                if(node.left  != null)  queue.offerLast(node.left);
51                if(node.right != null)  queue.offerLast(node.right);
52            }
53            startIndex = endIndex + 1;
54            level++;
55        }
56        return root;
57    }
58
59    public void levelOrder(TreeNode root, List<List<Integer>> values, int level) {
60
61        if(root == null)
62            return;
63
64        if(values.size() == level){
65            values.add(new ArrayList<>());
66        }
67        
68        values.get(level).add(root.val);
69        levelOrder(root.left,  values, level + 1);
70        levelOrder(root.right, values, level + 1);
71    }
72}