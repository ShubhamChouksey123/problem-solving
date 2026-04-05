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
17    public TreeNode addOneRow(TreeNode root, int val, int depth) {
18
19        if(depth == 1){
20            TreeNode tmp = new TreeNode(val);
21            tmp.left = root;
22            return tmp;
23        }
24
25
26        Deque<TreeNode> queue = new ArrayDeque<>();
27        queue.offerLast(root);
28        int level = 1;
29
30        while(!queue.isEmpty()){
31
32            int size = queue.size();
33            for(int i = 0 ; i < size ; i++){
34                TreeNode node = queue.pollFirst();
35                if(level + 1 == depth){
36
37                    
38                    TreeNode tmpLeft = new TreeNode(val);
39                    tmpLeft.left = node.left;
40                    node.left = tmpLeft;
41                    
42                    
43                    TreeNode tmpRight = new TreeNode(val);
44                    tmpRight.right = node.right;
45                    node.right = tmpRight;
46                    
47                }
48                if(node.left  != null) queue.offerLast(node.left);
49                if(node.right != null) queue.offerLast(node.right);
50            }
51            level++;
52        }
53        return root;
54    }
55}