
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

public class BinarySearchTree
{
    // create private TreeNode called myRoot
    TreeNode myRoot;
    public BinarySearchTree()
    {
        myRoot = null;
    }

    public void insert(Comparable next)
    {
        // post: next added to tree so as to preserve binary search tree
        if (myRoot == null)
            myRoot = new TreeNode(next);
        else
            myRoot = insertHelper(myRoot, next);
    }

    private TreeNode insertHelper(TreeNode root, Comparable next)
    {
        // pre : root points to a binary search tree
        // post: next added to tree so as to preserve binary search tree
        //
        if (root == null)
            return new TreeNode(next);
        Comparable value = (Comparable)root.getValue();
        if (value.compareTo(next)>=0)
        {
            root.setRight(insertHelper(root.getRight(), next));
            return root;
        }
        root.setLeft(insertHelper(root.getLeft(), next));
        return root;
    }

    public Object find(Comparable target)
    {
        if (myRoot == null)
            return null;
        else
            return findHelper(myRoot, target);
    }

    private Object findHelper(TreeNode root, Comparable target)
    {
        if (root == null)
            return null;
        Comparable value = (Comparable)root.getValue();
        if (value.compareTo(target) == 0)
            return root.getValue();
        else if (value.compareTo(target) > 0)
            return findHelper(root.getRight(), target);
        else
            return findHelper(root.getLeft(), target);
    }

    public int countNodes()
    {
        return countNodesHelper(myRoot);
    }

    private int countNodesHelper(TreeNode root)
    {
        if (root == null)
            return 0;
        else
            return 1 + countNodesHelper(root.getLeft()) +
                countNodesHelper(root.getRight());
    }

    public void print()
    {
        // post: prints the data fields of the tree, one per line
        //
        printInorder(myRoot);
    }

    private void printInorder(TreeNode node)
    {
        // pre : node points to a binary search tree
        // post: prints the data fields of the tree using an inorder traversal
        //
        if (node != null) {
            printInorder (node.getLeft());
            System.out.println(node.getValue());
            printInorder (node.getRight());
        }
    }

    public void delete(Comparable target)
    {
        // post: deletes a node with data equal to target, if present,
        //       preserving binary search tree property
        //
        TreeNode result = deleteHelper(myRoot, target);
        if (result != null)
            deleteTargetNode(result);
    }

    private TreeNode deleteHelper(TreeNode node, Comparable target)
    {
        // pre : node points to a non-empty binary search tree
        // post: deletes a node with data equal to target, if present,
        //       preserving binary search tree property
        return (TreeNode)findHelper(node, target);
    }

    private TreeNode deleteTargetNode(TreeNode target)
    {
        // pre : target points to TreeNode to be deleted
        // post: returns a reference to a subtree with the target
        //       TreeNode removed or null if the TreeNode is a leaf
        if (target.getLeft() != null && target.getRight() != null)
            return deleteTwoChildren(target);
        else if (target.getLeft() != null)
            return deleteOneChild(target, target.getLeft());
        else if (target.getRight() != null)
            return deleteOneChild(target, target.getRight());
        else
            return deleteLeaf(target);
    }

}

