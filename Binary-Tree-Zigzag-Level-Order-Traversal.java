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
18    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
19
20        if(root == null){
21            return new ArrayList<>();
22        }
23
24        Deque<TreeNode> queue = new ArrayDeque<>();
25        queue.offerLast(root);
26        boolean leftToRight = true;
27        List<List<Integer>> zigZagOrder = new ArrayList<>();
28
29
30        while(!queue.isEmpty()){
31            int size = queue.size();
32            List<Integer> row = new LinkedList<>();
33            zigZagOrder.add(row);
34
35            for(int i = 0 ; i < size ; i++){
36                TreeNode current = queue.poll();
37                if(leftToRight){
38                    row.addLast(current.val);
39                }else{
40                    row.addFirst(current.val);
41                }
42                
43                if(current.left  != null) queue.add(current.left);
44                if(current.right != null) queue.add(current.right);
45            }
46            leftToRight = !leftToRight;
47        }
48        return zigZagOrder;
49    }
50}