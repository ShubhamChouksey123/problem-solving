1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10class Solution {
11    
12    private TreeNode lowestCommonAncestor;
13
14    private Pair<Boolean, Boolean> lowestCommonAncestorUtil(TreeNode root, TreeNode p, TreeNode q) {
15        
16        if(root == null){
17            return new Pair(false, false);
18        }
19
20
21        Pair<Boolean, Boolean> pqFoundLeft  = lowestCommonAncestorUtil(root.left,  p, q);
22        Pair<Boolean, Boolean> pqFoundRight = lowestCommonAncestorUtil(root.right, p, q);
23
24        Pair<Boolean, Boolean> pqFound = new Pair(
25            pqFoundLeft.getKey() | pqFoundRight.getKey(), 
26            pqFoundLeft.getValue() | pqFoundRight.getValue()
27        );
28
29        if(root == p){
30            pqFound = new Pair(true, pqFound.getValue());
31        }
32        if(root == q){
33            pqFound = new Pair(pqFound.getKey(), true);
34        }
35
36        if(lowestCommonAncestor == null && pqFound.getKey() && pqFound.getValue()){
37            lowestCommonAncestor = root;
38        }
39        return pqFound;
40    }
41    
42    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
43
44        lowestCommonAncestor = null;
45        lowestCommonAncestorUtil(root, p, q);
46        return lowestCommonAncestor;
47    }
48}