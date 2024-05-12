/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private List<TreeNode> ancestorsP;
    private List<TreeNode> ancestorsQ;
    private void getAllAncestorsP(TreeNode root, TreeNode p, Stack<TreeNode> ancestors) {

        if (root == null)
            return;

        if (root == p) {
            this.ancestorsP = new ArrayList<>(ancestors);
        }

        ancestors.add(root);

        if (root.left != null) {
            getAllAncestorsP(root.left, p, ancestors);
        }

        if (root.right != null) {
            getAllAncestorsP(root.right, p, ancestors);
        }

        ancestors.pop();
    }

    private void getAllAncestorsQ(TreeNode root, TreeNode p, Stack<TreeNode> ancestors) {

        if (root == null)
            return;

        if (root == p) {
            this.ancestorsQ = new ArrayList<>(ancestors);
        }

        ancestors.add(root);

        if (root.left != null) {
            getAllAncestorsQ(root.left, p, ancestors);
        }

        if (root.right != null) {
            getAllAncestorsQ(root.right, p, ancestors);
        }

        ancestors.pop();
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        if (root == null)
            return null;

        if (p == q)
            return p;


        getAllAncestorsP(root, p, new Stack<>());
        ancestorsP.add(p);
        System.out.println("ancestorsP : " + ancestorsP);


        getAllAncestorsQ(root, q, new Stack<>());
        ancestorsQ.add(q);

        System.out.println("ancestorsQ : " + ancestorsQ);

        int index = 0;
        TreeNode common = null;
        while (index < ancestorsP.size() && index < ancestorsQ.size()) {
            if (!Objects.equals(ancestorsP.get(index), ancestorsQ.get(index))) {
                System.out.println("common: " + common);
                return common;
            }
            common = ancestorsP.get(index);
            index++;
        }

        // System.out.println("common: " + common);
        return common;
    }
}