/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    public List<TreeNode> rootNodes;
    public Integer currentIndex;

    public BSTIterator(TreeNode root) {
        rootNodes = new ArrayList<>();
        addAllLeftNode(root, 0);
        currentIndex = rootNodes.size() - 1;
    }

    private boolean isValid(List<TreeNode> rootNodes, int index) {
        if (index >= 0 && index < rootNodes.size()) {
            return true;
        }
        return false;
    }

    public void addAllLeftNode(TreeNode root, int index) {
        while (root != null) {
            if (rootNodes.size() <= index) {
                rootNodes.add(root);
            } else {
                rootNodes.set(index, root);
            }
            index++;
            root = root.left;
        }
    }

    public int next() {
        TreeNode currentNode = rootNodes.get(currentIndex);

        if (currentNode.right != null) {
            addAllLeftNode(currentNode.right, currentIndex + 1);
            currentIndex = rootNodes.size() - 1;
        } else {
            int index = currentIndex - 1;
            while (isValid(rootNodes, index) && rootNodes.get(index).val < currentNode.val) {
                rootNodes.remove(index + 1);
                index--;
            }
            rootNodes.remove(index + 1);
            currentIndex = index;
        }

        if (isValid(rootNodes, currentIndex + 1) && currentNode.val > rootNodes.get(currentIndex + 1).val) {
            addAllLeftNode(currentNode.right, currentIndex + 1);
            currentIndex++;
        }

        // System.out.println("rootNodes : " + rootNodes);
        return currentNode.val;
    }

    public boolean hasNext() {

        if (!isValid(rootNodes, currentIndex)) {
            return false;
        }
        if (rootNodes.isEmpty()) {
            return false;
        }

        TreeNode currentNode = rootNodes.get(currentIndex);

        if (currentNode.right != null) {
            return true;
        }

//        if(currentNode.val >= rootNodes.get(0).val){
//            return  false;
//        }

        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */