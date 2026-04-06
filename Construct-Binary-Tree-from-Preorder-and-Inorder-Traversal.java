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
18    private int findIndexOfRoot(int[] inorder, int rootValue, int startInOrder, int endInOrder){
19        for(int i = startInOrder ; i <= endInOrder ; i++){
20            if(inorder[i] == rootValue){
21                return i;
22            }
23        }
24        // throw Exception
25        return -1;
26    }
27
28    public TreeNode buildTree(int[] preorder, int[] inorder, int startPreOrder, int endPreOrder, int startInOrder, int endInOrder) {
29        
30        if(startPreOrder > endPreOrder || startInOrder > endInOrder){
31            return null;
32        }
33
34        int rootValue = preorder[startPreOrder];
35        TreeNode root = new TreeNode(rootValue);
36
37        if(startPreOrder == endPreOrder){
38            return root;
39        }
40
41        int indexOfRootInOrder = findIndexOfRoot(inorder, rootValue, startInOrder, endInOrder);
42        int lengthOfLeftSubTree = indexOfRootInOrder - startInOrder;
43
44        root.left = buildTree(preorder, inorder, startPreOrder + 1, startPreOrder + lengthOfLeftSubTree , 
45            startInOrder, indexOfRootInOrder - 1);
46
47        root.right = buildTree(preorder, inorder,  startPreOrder + lengthOfLeftSubTree + 1,  endPreOrder, 
48            indexOfRootInOrder + 1, endInOrder);    
49
50        return root;    
51    }
52    
53    public TreeNode buildTree(int[] preorder, int[] inorder) {
54        int n = preorder.length;
55
56        return buildTree(preorder, inorder, 0, n - 1, 0, n - 1);
57    }
58}