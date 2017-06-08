package nowcoder;
import java.util.*;

 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class TreePrinter {
	public int[][] printTree(TreeNode root) {
        // write code here
        if(root==null)
            return null;
        ArrayList<ArrayList<Integer>> alist=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr=new ArrayList<Integer>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        TreeNode last=root;
        TreeNode nlast=null;
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode pn=q.poll();
            arr.add(pn.val);
            if(pn.left!=null){
                q.add(pn.left);
                nlast=pn.left;
            }
            if(pn.right!=null){
                q.add(pn.right);
                nlast=pn.right;
            }
            if(pn==last){
                last=nlast;
                alist.add(arr);
                arr=new ArrayList<Integer>();
            }
        }
        int[][] result=new int[alist.size()][];
        for(int i=0;i<alist.size();i++){
            result[i]=new int[alist.get(i).size()];
            for(int j=0;j<result[i].length;j++){
               result[i][j]=alist.get(i).get(j); 
            }
        }
        return result;
    }
}
