package Algorithm.Chapter4;

import java.nio.BufferUnderflowException;

// 二叉查找树(遵循左子树的节点小于节点，右子树大于节点)
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>{
    // 嵌套类 节点表示(必须写成静态的 否则需要实例化再调用)
    private static class BinaryNode<AnyType> {
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
        BinaryNode(AnyType theElement) {
            this(theElement, null, null);
        }

        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }
    }

    private BinaryNode<AnyType> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    public AnyType findMax() {
        if (isEmpty())
            throw new BufferUnderflowException();
        return findMax(root).element;
    }

    public AnyType findMin() {
        if (isEmpty())
            throw new BufferUnderflowException();
        return findMin(root).element;
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    public void remove(AnyType x) {
        root = remove(x, root);
    }

    public void printTree() {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    // 使用递归 判断待插入的元素和节点的差值 从而决定去左子树还是右子树中查找
    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return false;
        int compareResult = x.compareTo(t.element);
        if (compareResult > 0) {
            return contains(x, t.right);
        } else if (compareResult < 0){
            return contains(x, t.left);
        } else {
            return true;
        }
    }

    /**
     * 寻找最大和最小值分别用了递归和非递归的形式来进行
     * 递归寻找的代码更加的简洁，但是效率更慢
     * @param t
     * @return
     */
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t == null)
            return null;
        if (t.right == null)
            return t;
        return findMax(t.right);
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t != null)
            while(t.left != null)
                t = t.left;
        return t;
    }

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        // 没有节点的时候插入
        if (t == null)
            return new BinaryNode<>(x);
        int compareResult = x.compareTo(t.element);

        // 判断插在左子树还是右子树
        if (compareResult > 0)
            t.right = insert(x, t.right);
        else if (compareResult < 0)
            t.left = insert(x, t.left);

        return t;
    }

    /**
     * 删除是最麻烦的一个步骤
     * 需要考虑到待删除的节点有几个子树
     * @param x
     * @param t
     * @return
     */
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return t;
        int compareResult = x.compareTo(t.element);

        if (compareResult > 0)
            t.left = remove(x, t.left);
        else if (compareResult < 0)
            t.right = remove(x, t.right);
        // 如果待删除的节点有两个子节点 则将该节点传入右子树的最小节点的值 然后删除最小节点
        else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }

    private void printTree(BinaryNode<AnyType> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    public static void main(String []args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(6);
        tree.insert(1);
        tree.insert(2);
        tree.insert(4);
        tree.printTree();
     }
}
