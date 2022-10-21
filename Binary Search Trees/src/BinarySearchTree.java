public class BinarySearchTree {
    import java.util.*;

    /**
     *  Implements a Binary Search Tree
     *
     * @author     G. Peck
     * @created    July 2, 2003
     *
     * Modified by Jason Quesenberry and Nancy Quesenberry
     * February 9, 2006
     */

    public class BinarySearchTree{
        // create private TreeNode called myRoot
        TreeNode myRoot;
        public BinarySearchTree()
        {
            myRoot = null;
        }

        public void insert(Comparable next)
        {
            // post: next added to tree so as to preserve binary search tree
            //
        }

        private TreeNode insertHelper(TreeNode root, Comparable next)
        {
            // pre : root points to a binary search tree
            // post: next added to tree so as to preserve binary search tree
            //
        }

        public Object find(Comparable target)
        {
            //
        }

        private Object findHelper(TreeNode root, Comparable target)
        {
            System.out.println("To be implemented in Lab Assignment AB30.2")
            ;
            return null;
        }

        public int countNodes()
        {
            //
        }

        private int countNodesHelper(TreeNode root)
        {
            //
        }

        public void print()
        {
            // post: prints the data fields of the tree, one per line
            //
        }

        private void printInorder(TreeNode root)
        {
            // pre : root points to a binary search tree
            // post: prints the data fields of the tree using an inorder traversal
            //
        }
    }

    public void delete(Comparable target)
    {
        // post: deletes a node with data equal to target, if present,
        //       preserving binary search tree property
        //
    }

    private TreeNode deleteHelper(TreeNode node, Comparable target)
    {
        // pre : node points to a non-empty binary search tree
        // post: deletes a node with data equal to target, if present,
        //       preserving binary search tree property
        System.out.println("To be implemented in Lab Assignment AB30.2")
        ;
        return null;
    }

    private TreeNode deleteTargetNode(TreeNode target)
    {
        // pre : target points to TreeNode to be deleted
        // post: returns a reference to a subtree with the target
        //       TreeNode removed or null if the TreeNode is a leaf
        System.out.println("To be implemented in Lab Assignment AB30.2")
        ;
        return null;
    }

}
}
