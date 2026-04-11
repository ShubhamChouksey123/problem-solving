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
12    List<TreeNode> leftAncestorList;
13    List<TreeNode> rightAncestorList;
14
15    private void getAncestor(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
16
17        if(root == null) return;
18
19        path.add(root);
20
21        if(root == p){
22            leftAncestorList = new ArrayList<>(path);
23        }
24        if(root == q){
25            rightAncestorList = new ArrayList<>(path);
26        }
27        getAncestor(root.left, p, q, path);
28        getAncestor(root.right, p, q, path);
29
30        path.remove(path.size() - 1);
31    }
32    
33    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
34        leftAncestorList = new ArrayList<>();
35        rightAncestorList = new ArrayList<>();
36
37        getAncestor(root, p, q, new ArrayList<>());
38
39        int index1 = 0, index2 = 0;
40        TreeNode commonAncestor = null;
41
42        for(int i = 0 ; i < Math.min(leftAncestorList.size(), rightAncestorList.size()) ; i++){
43            if(leftAncestorList.get(i).val == rightAncestorList.get(i).val){
44                commonAncestor = leftAncestorList.get(i);
45            }
46        }
47
48
49
50        return commonAncestor;
51    }
52}