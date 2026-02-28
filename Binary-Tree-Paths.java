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
18    private String convertToPath(List<String> cur){
19        StringBuilder sb = new StringBuilder(); 
20        int i = 0;
21        sb.append(cur.get(i));
22        for(i = 1 ; i < cur.size() ; i++){
23            sb.append("->");
24            sb.append(cur.get(i));
25        }
26        return sb.toString();
27    }
28    
29    public void binaryTreePathsUtils(TreeNode root, List<String> result, List<String> cur) {
30
31        if(root == null){
32            return; 
33        }
34
35        cur.add(String.valueOf(root.val));
36        
37        if(root.left != null){
38            binaryTreePathsUtils(root.left, result, cur);
39        }
40        if(root.right != null){
41            binaryTreePathsUtils(root.right, result, cur);
42        }
43
44        if(root.left == null && root.right == null){
45            String s = convertToPath(cur);
46            result.add(s);
47        }
48        cur.remove(cur.size() - 1);
49    }
50    
51    public List<String> binaryTreePaths(TreeNode root) {
52        List<String> result = new ArrayList<>();
53
54        binaryTreePathsUtils(root, result, new ArrayList<>());
55        return result;
56    }
57}