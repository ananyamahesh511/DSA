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
    void inorder(TreeNode root, List<Integer> ls){
        if(root == null) return;

        inorder(root.left, ls);

        ls.add(root.val);

        inorder(root.right, ls);
    }
    public int minDiffInBST(TreeNode root) {
        
        List<Integer> ls = new ArrayList<>();
        inorder(root, ls);

        int[] arr = new int[ls.size()];

        for(int i=0; i<arr.length; i++){
            arr[i] = ls.get(i);
        }
        int res = Integer.MAX_VALUE;

        for(int i=1; i<arr.length; i++){
            res = Math.min(res, arr[i] - arr[i-1]);
        }

        return res;
    }
}