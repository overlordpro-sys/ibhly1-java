
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
        myRoot = deleteHelper(myRoot, target);
    }

    private TreeNode deleteHelper(TreeNode node, Comparable target)
    {
        // pre : node points to a non-empty binary search tree
        // post: deletes a node with data equal to target, if present,
        //       preserving binary search tree property
        if (node == null)
            return null;
        Comparable value = (Comparable)node.getValue();
        if (value.compareTo(target) == 0)
            return deleteTargetNode(node);
        else if (value.compareTo(target) > 0)
        {
            node.setRight(deleteHelper(node.getRight(), target));
            return node;
        }
        else
        {
            node.setLeft(deleteHelper(node.getLeft(), target));
            return node;
        }
    }
//    if (root == null)
//        return new TreeNode(next);
//    Comparable value = (Comparable)root.getValue();
//        if (value.compareTo(next)>=0)
//    {
//        root.setRight(insertHelper(root.getRight(), next));
//        return root;
//    }
//        root.setLeft(insertHelper(root.getLeft(), next));
//        return root;

    private TreeNode deleteTargetNode(TreeNode target){
        if (target.getRight() == null) {
            return target.getLeft();
        }
        else if (target.getLeft() == null) {
            return target.getRight();
        }
        else if (target.getLeft().getRight() == null) {
            target.setValue(target.getLeft().getValue());
            System.out.println("target value is now " + target.getValue());
            target.setLeft(target.getLeft().getLeft());
            return target;
        }
        else{ // left child has right child

            TreeNode marker = target.getLeft();
            while (marker.getRight().getRight() != null)
                marker = marker.getRight();
            target.setValue(marker.getRight().getValue());
            marker.setRight(marker.getRight().getLeft());
            return target;
        }
    }


}

