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
18    private Map<Integer, Integer> getIndexOfRoot;
19    
20    public TreeNode buildTreeUtil(int[] inorder, int[] postorder, int startInOrder, int endInOrder, int startPostOrder, int endPostOrder) {
21        if(startInOrder > endInOrder || startPostOrder > endPostOrder){
22            return null;
23        }
24        int rootValue = postorder[endPostOrder];
25        TreeNode root = new TreeNode(rootValue);
26        if(startInOrder == endInOrder){
27            return root;
28        }
29
30        int mid = getIndexOfRoot.get(rootValue);
31        int lengthOfLeftSubTree = mid - startInOrder;
32        root.left  = buildTreeUtil(inorder, postorder, startInOrder, mid - 1, startPostOrder, startPostOrder + lengthOfLeftSubTree - 1);
33        root.right = buildTreeUtil(inorder, postorder, mid + 1, endInOrder, startPostOrder + lengthOfLeftSubTree, endPostOrder - 1);
34        return root;
35    }
36    
37    public TreeNode buildTree(int[] inorder, int[] postorder) {
38
39        getIndexOfRoot = new HashMap<>();
40        int n = inorder.length;
41        for(int i = 0 ; i < n ; i++){
42            getIndexOfRoot.put(inorder[i], i);
43        }
44
45        return buildTreeUtil(inorder, postorder, 0, n - 1, 0, n - 1);
46    }
47}