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
17    public int widthOfBinaryTree(TreeNode root) {
18
19        if(root == null)
20            return 0;
21
22
23        if(root.left == null && root.right == null)
24            return 1;
25        
26        return widthOfBinaryTreeUtil(root);
27    }
28
29    private int widthOfBinaryTreeUtil(TreeNode root){
30
31        Deque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
32        queue.offerLast(new Pair(root, 0));
33        int level = 0, maxWidth = 0;
34        
35        while(!queue.isEmpty()){
36
37            // width of that level
38            int size = queue.size();
39            int minIndex = queue.peekFirst().getValue(), maxIndex = Integer.MIN_VALUE;;
40            for(int i = 0 ; i < size ; i++){
41                Pair<TreeNode, Integer> pair = queue.pollFirst();
42                
43                TreeNode node = pair.getKey();
44                Integer index = pair.getValue();
45                int width = pair.getValue() - minIndex + 1;
46                maxWidth = Math.max(maxWidth, width);
47
48                if(node.left != null){
49                    queue.offerLast(new Pair(node.left, 2*index + 1));
50                }
51                if(node.right != null){
52                    queue.offerLast(new Pair(node.right, 2*index + 2));
53                }
54            }
55        }
56
57        return maxWidth;
58    } 
59}