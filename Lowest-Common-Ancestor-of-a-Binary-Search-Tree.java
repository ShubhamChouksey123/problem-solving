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
23        Pair<Boolean, Boolean> leftFound  = new Pair(false, false);
24        Pair<Boolean, Boolean> rightFound = new Pair(false, false);
25
26        if(p.val < root.val || q.val < root.val){
27            leftFound  = lowestCommonAncestorUtil(root.left,  p, q);
28        }
29
30        if(p.val > root.val || q.val > root.val){
31            rightFound = lowestCommonAncestorUtil(root.right, p, q);
32        }
33        
34        boolean pFound = leftFound.getKey() || rightFound.getKey() ;
35        boolean qFound = leftFound.getValue() || rightFound.getValue() ;
36
37        if(root == p){
38            pFound = true;
39        }
40        if(root == q){
41            qFound = true;
42        }
43
44        if(lowestCommonAncestor == null && pFound && qFound){
45            lowestCommonAncestor = root;
46        }
47        return new Pair(pFound, qFound);
48
49    }
50    
51    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
52        lowestCommonAncestor = null;
53        lowestCommonAncestorUtil(root, p, q);
54        return lowestCommonAncestor;
55    }
56}