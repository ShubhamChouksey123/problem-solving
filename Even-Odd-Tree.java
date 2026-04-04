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
17    public boolean isEvenOddTree(TreeNode root) {
18
19        Deque<TreeNode> stack = new ArrayDeque<>();
20        stack.offerLast(root);
21        boolean odd = true, increasing = true;
22
23        while(!stack.isEmpty()){
24
25            int size = stack.size();
26            int prev = -1;
27            for(int i = 0 ; i < size ; i++){
28                TreeNode node = stack.pollFirst();
29                if( (odd && ((node.val & 1) == 0)) || (!odd && ((node.val & 1) == 1)) ){
30                    return false;
31                }
32
33                if( i > 0 && ( (increasing && node.val <= prev ) || (!increasing && node.val >= prev ) ) ){
34                    return false;
35                }
36                prev = node.val;
37                if(node.left  != null) stack.offerLast(node.left);
38                if(node.right != null) stack.offerLast(node.right);
39            }
40            
41
42            odd = !odd;
43            increasing = !increasing;
44        }
45        return true;
46    }
47}