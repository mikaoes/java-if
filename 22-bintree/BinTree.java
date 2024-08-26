
public class BinTree<T> {
    private T data;
    private BinTree<T> left;
    private BinTree<T> right;

    public BinTree(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BinTree(T data, BinTree<T> left, BinTree<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public BinTree<T> getLeft() {
        return left;
    }

    public BinTree<T> getRight() {
        return right;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(BinTree<T> left) {
        this.left = left;
    }

    public void setRight(BinTree<T> right) {
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
