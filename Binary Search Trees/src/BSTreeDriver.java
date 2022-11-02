public class BSTreeDriver {
    //cant find first in list
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        BSTree menu = new BSTree();
        menu.mainMenu(tree);
        tree.debug();
        tree.printLevel(0);
        System.out.println();
        tree.printLevel(1);
        System.out.println();
        tree.printLevel(2);
        System.out.println();
        tree.printLevel(3);
        System.out.println();
        tree.printLevel(4);
        System.out.println();
        tree.printLevel(5);

    }
}