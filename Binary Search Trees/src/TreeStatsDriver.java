public class TreeStatsDriver {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(26);
        tree.insert(79);
        tree.insert(14);
        tree.insert(99);
        tree.insert(53);
        tree.insert(9);
        tree.insert(35);
        tree.insert(21);
        tree.insert(87);
        tree.debug();

//        TreeStats menu = new TreeStats();
//        menu.mainMenu(tree);
    }
}