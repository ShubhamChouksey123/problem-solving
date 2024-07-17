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
class Solution {


    private void findBranch(TreeNode root, int desiredNodeValue, List<Character> parents, List<Character> ans){

        if(root == null){
            return;
        }


        if(root.val == desiredNodeValue){
            for(Character c : parents){
                ans.add(c);
            }
            return;
        }

        parents.add('L');
        findBranch(root.left, desiredNodeValue, parents, ans);
        parents.remove(parents.size() - 1);

        parents.add('R');
        findBranch(root.right, desiredNodeValue, parents, ans);
        parents.remove(parents.size() - 1);

    }

    private String createString(List<Character> starts, List<Character> dests){
        int indexStart = 0, indexDest = 0, m = starts.size(), n = dests.size();

        while(indexStart < m && indexDest < n && starts.get(indexStart) == dests.get(indexDest)){
            indexStart++;
            indexDest++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while(indexStart < m){
            stringBuilder.append("U");indexStart++;
        }

        while(indexDest < n){
            stringBuilder.append(dests.get(indexDest));indexDest++;
        }

        System.out.println("stringBuilder : " + stringBuilder.toString());
        return stringBuilder.toString();
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        List<Character> starts = new ArrayList<>();
        findBranch(root, startValue, new ArrayList<>(), starts);

        List<Character> dests = new ArrayList<>();
        findBranch(root, destValue, new ArrayList<>(), dests);

        System.out.println("starts : " + starts);
        System.out.println("dests : " + dests);
        return createString(starts, dests);
    }
}