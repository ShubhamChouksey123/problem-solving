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
18    private Integer countPseudoPalindrome;
19    /**
20        count of occurances of integer in that path from root to leaf
21        integer => count
22     */
23    private Map<Integer, Integer> occurances;
24
25    private void countPathPsedoPalindrome(){
26        int oddOccuranceCount = 0;
27
28        for(Map.Entry<Integer, Integer> entry : occurances.entrySet()){
29            if(entry.getValue() % 2 != 0 ) oddOccuranceCount++;
30        }
31
32        if(oddOccuranceCount < 2){
33            countPseudoPalindrome++;
34        }
35    }
36
37    private void pseudoPalindromicPathsCounter (TreeNode root) {
38
39        if(root == null){
40            return;   
41        }
42
43        int value = root.val;
44        occurances.put(value, occurances.getOrDefault(value, 0) + 1);
45        
46        if(root.left == null && root.right == null){
47            countPathPsedoPalindrome();
48        }
49
50        pseudoPalindromicPathsCounter (root.left);
51        pseudoPalindromicPathsCounter (root.right); 
52        occurances.put(value, occurances.getOrDefault(value, 0) - 1);   
53    }
54    
55    public int pseudoPalindromicPaths (TreeNode root) {
56        countPseudoPalindrome = 0;
57        occurances = new HashMap<>();
58        pseudoPalindromicPathsCounter (root);
59        return countPseudoPalindrome;
60    }
61}