public class Test {
    public static void main(String[] args) {
        BinTree<String> tree = new BinTree<>("root",
                new BinTree<>("left", new BinTree<>("left.left"), null),
                new BinTree<>("right"));

        assert tree.getData().equals("root");
        assert tree.getLeft().getData().equals("left");
        assert tree.getLeft().getLeft().getData().equals("left.left");
        assert tree.getRight().getData().equals("right");
    }
}