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
    private TreeNode myRoot;
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
        if (next.compareTo(value)>=0)
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
        else if (target.compareTo(value) > 0)
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

    public void printInorder()
    {
        // post: prints the data fields of the tree, one per line
        //
        printInorderHelper(myRoot);
    }

    private void printInorderHelper(TreeNode root)
    {
        // pre : node points to a binary search tree
        // post: prints the data fields of the tree using an inorder traversal
        //
        if (root != null) {
            printInorderHelper(root.getLeft());
            System.out.println(root.getValue());
            printInorderHelper(root.getRight());
        }
    }

    public void printPreorder(){
        // post: prints the data fields of the tree, one per line
        printPreorderHelper(myRoot);
    }

    private void printPreorderHelper(TreeNode root){
        // pre : root points to a binary search tree
        // post: prints the data fields of the tree using an inorder traversal
        if (root != null) {
            System.out.println(root.getValue());
            printPreorderHelper(root.getLeft());
            printPreorderHelper(root.getRight());
        }
    }


    public void printPostorder(){
        // post: prints the data fields of the tree, one per line
        printPostorderHelper(myRoot);
    }

    private void printPostorderHelper(TreeNode root){
        // pre : root points to a binary search tree
        // post: prints the data fields of the tree using an inorder traversal
        if (root != null) {
            printPostorderHelper(root.getLeft());
            printPostorderHelper(root.getRight());
            System.out.println(root.getValue());
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
        {
            return deleteTargetNode(node);
        }
        else if (target.compareTo(value) > 0)
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

    private TreeNode deleteTargetNode(TreeNode target){
        if (target.getRight() == null) {
            return target.getLeft();
        }
        else if (target.getLeft() == null) {
            return target.getRight();
        }
        else if (target.getRight().getLeft() == null) {
            target.setValue(target.getRight().getValue());
            target.setRight(target.getRight().getRight());
            return target;
        }
        else{ // left child has right child

            TreeNode marker = target.getRight();
            while (marker.getLeft().getLeft() != null)
                marker = marker.getLeft();
            target.setValue(marker.getLeft().getValue());
            marker.setLeft(marker.getLeft().getRight());
            return target;
        }
    }

    public int countLeaves(){
        return countLeaves(myRoot);
    }

    private int countLeaves (TreeNode root){
        if (root == null)
            return 0;

        if (countLeaves(root.getLeft()) == 0 && countLeaves(root.getRight()) == 0)
            return 1;
        else
            return countLeaves(root.getLeft()) + countLeaves(root.getRight());
    }

    public void clearTree()
    {
        myRoot = null;
    }

    public int height()
    {
        return height(myRoot);
    }

    private int height(TreeNode node)
    {
        if (node == null)
            return 0;

        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    public int width(){
        return width(myRoot);
    }

    private int width (TreeNode root){
        if (root == null)
            return 0;
        int width = 1;
        if (root.getLeft()!=null)
            width += height(root.getLeft());
        if (root.getRight()!=null)
            width += height(root.getRight());
        return Math.max(width, Math.max(width(root.getLeft()), width(root.getRight())));


    }
    public void interchange()
    // post: tree becomes a mirror image of itself
    {
        interchange(myRoot);
    }

    private void interchange(TreeNode root)
    {
        if (root != null)
        {
            interchange(root.getLeft());
            interchange(root.getRight());
            TreeNode temp = root.getLeft();
            root.setLeft(root.getRight());
            root.setRight(temp);
        }
    }

    public boolean isAncestor(Comparable ancestor, Comparable descendant){
        // post: returns true if descendant is a "child" of ancestor; false otherwise
        //       i.e., true if descendant belongs to ancestor's subtree
        if (ancestor.equals(descendant))
        {
            return false;
        }
        return isAncestor(myRoot, ancestor, descendant);
    }

    public boolean isAncestor(TreeNode root, Comparable a, Comparable d){
        if (findPtr(findPtr(root, a), d) != null)
            return true;
        return false;
    }

    private TreeNode findPtr(TreeNode root, Comparable target){
        if (root == null)
            return null;
        Comparable value = (Comparable)root.getValue();
        if (value.compareTo(target) == 0)
            return root;
        else if (target.compareTo(value) > 0)
            return findPtr(root.getRight(), target);
        else
            return findPtr(root.getLeft(), target);
    }

    public void printLevel(int level)
    // post: prints the data fields of the tree, one per line
    {
        printLevel(myRoot, level);
    }

    private void printLevel(TreeNode root, int level)
    {
        // pre : node points to a binary search tree
        // post: prints the data fields of the tree using an inorder traversal
        //
        if (root != null) {
            if (level == 0)
                System.out.println(root.getValue());
            else{
                printLevel(root.getLeft(), level - 1);
                printLevel(root.getRight(), level - 1);
            }
        }
    }

    public void debug()
    {
        int width = 1;
        if (myRoot.getLeft().getLeft()!=null)
            width += height(myRoot.getLeft());
        if (myRoot.getLeft().getRight()!=null)
            width += height(myRoot.getRight());
        System.out.print(width);

    }

}

