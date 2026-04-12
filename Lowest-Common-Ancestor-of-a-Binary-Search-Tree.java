1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10
11class Solution {
12
13    private TreeNode lowestCommonAncestor ;
14    
15    /**
16        pair returninf whether p and q found in this subtree or not 
17     */
18    public Pair<Boolean, Boolean> lowestCommonAncestorUtil(TreeNode root, TreeNode p, TreeNode q) {
19        if(root == null){
20            return new Pair(false, false);
21        }
22
23        Pair<Boolean, Boolean> leftFound  = lowestCommonAncestorUtil(root.left,  p, q);
24        Pair<Boolean, Boolean> rightFound = lowestCommonAncestorUtil(root.right, p, q);
25
26        boolean pFound = leftFound.getKey() || rightFound.getKey() ;
27        boolean qFound = leftFound.getValue() || rightFound.getValue() ;
28
29        if(root == p){
30            pFound = true;
31        }
32        if(root == q){
33            qFound = true;
34        }
35
36        if(lowestCommonAncestor == null && pFound && qFound){
37            lowestCommonAncestor = root;
38        }
39        return new Pair(pFound, qFound);
40
41    }
42    
43    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
44        lowestCommonAncestor = null;
45        lowestCommonAncestorUtil(root, p, q);
46        return lowestCommonAncestor;
47    }
48}