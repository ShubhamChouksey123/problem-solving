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
18    private Integer maxRange;
19    
20    /**
21        Pair returning min and max values in subtree from this root node
22     */
23    private Pair<Integer, Integer> maxAncestorDiffUtil(TreeNode root) {
24
25        if(root.left == null && root.right == null){
26            return new Pair(root.val, root.val);
27        }
28
29        Pair<Integer, Integer> leftSubTreeRange = null, rightSubTreeRange = null;
30        int difference = 0;
31        int minValue = root.val, maxValue = root.val;
32
33        if(root.left != null){
34            leftSubTreeRange  = maxAncestorDiffUtil(root.left);
35            difference = Math.max( 
36                Math.abs(root.val - leftSubTreeRange.getKey()),
37                Math.abs(root.val - leftSubTreeRange.getValue())   
38            ); 
39            maxRange = Math.max(maxRange, difference);
40            minValue = Math.min(minValue, leftSubTreeRange.getKey());
41            maxValue = Math.max(maxValue, leftSubTreeRange.getValue());
42        }
43        if(root.right != null){
44            rightSubTreeRange = maxAncestorDiffUtil(root.right);
45            difference = Math.max( 
46                Math.max( 
47                    Math.abs(root.val - rightSubTreeRange.getKey()),
48                    Math.abs(root.val - rightSubTreeRange.getValue())
49                ),
50                difference   
51            ); 
52            maxRange = Math.max(maxRange, difference);
53            minValue = Math.min(minValue, rightSubTreeRange.getKey());
54            maxValue = Math.max(maxValue, rightSubTreeRange.getValue());
55        }
56
57        
58        return new Pair(minValue, maxValue);
59    }
60    
61    public int maxAncestorDiff(TreeNode root) {
62
63        maxRange = 0;
64        if(root != null){
65            maxAncestorDiffUtil(root);
66        }
67        return maxRange;
68    }
69}