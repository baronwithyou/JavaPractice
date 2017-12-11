package Algorithm.Chapter4.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OrderTree<AnyType extends Comparable<AnyType>>{
    Node<AnyType> root;
    private static class Node<AnyType> {
        AnyType value;
        Node<AnyType> left;
        Node<AnyType> right;
        Node(AnyType value) {
            this(value, null, null);
        }
        Node(AnyType value, Node<AnyType> left, Node<AnyType> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 先序遍历 非递归
     * @param root
     * @return List
     */
    private List<AnyType> preOrder(Node<AnyType> root) {
        List<AnyType> list = new ArrayList<>();
        Stack<Node<AnyType>> stack = new Stack<>();
        // 将节点推入栈中
        stack.push(root);
        // 当栈不为空的时候 推出写入表中 然后分别推入右子树和左子树
        while(!stack.isEmpty()) {
            Node<AnyType> current = stack.pop();
            list.add(current.value);
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
        return list;
    }

    public List<AnyType> inOrder() {
        return inOrder(root);
    }

    /**
     * 中序遍历 非递归
     * @param t
     * @return List
     */
    private List<AnyType> inOrder(Node<AnyType> t) {
        List<AnyType> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        // 当栈不为空或者当前指针不为空
        while (!stack.isEmpty() || t != null) {
            // 当存在左子树的时候 持续的将左子树推入栈中
            while(t != null) {
                stack.push(t);
                t = t.left;
            }
            // 推出栈中元素写入表中
            t = stack.pop();
            list.add(t.value);
            // 此时左子树和节点都已经写入表中 将当前指针指向右子树
            t = t.right;
        }
        return list;
    }

    // 后序排序 双栈法
    private List<AnyType> postOrder(Node<AnyType> t) {
        Stack<Node<AnyType>> stack1 = new Stack<>();
        // 第二个栈才是最终排序结果
        Stack<Node<AnyType>> stack2 = new Stack<>();
        List<AnyType> list = new ArrayList<>();
        while (t != null || !stack1.isEmpty()) {
            // 将右子树添加进两个栈中
            while (t != null) {
                stack1.push(t);
                stack2.push(t);
                t = t.right;
            }
            // 如果栈1不为空 则推出来 并且让当前指针指向其左子树
            if (!stack1.isEmpty()) {
                t = stack1.pop();
                t = t.left;
            }
        }
        while(!stack2.isEmpty()) {
            t = stack2.pop();
            list.add(t.value);
        }
        return list;
    }

    public OrderTree() {
        root = null;
    }

    public List<AnyType> preOrder() {
        return preOrder(root);
    }

    public List<AnyType> postOrder() {
        return postOrder(root);
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    private Node<AnyType> insert(AnyType x, Node<AnyType> t) {
        if (t == null)
            return new Node<>(x);
        int compareResult = x.compareTo(t.value);
        if (compareResult > 0) {
            t.right = insert(x, t.right);
        } else if (compareResult < 0) {
            t.left = insert(x, t.left);
        }
        return t;
    }

    public static void main(String[] args) {
        OrderTree<Integer> orderTree = new OrderTree<>();
        orderTree.insert(5);
        orderTree.insert(2);
        orderTree.insert(10);
        orderTree.insert(6);
        orderTree.insert(15);
        orderTree.insert(11);
        System.out.println(orderTree.preOrder());
        System.out.println(orderTree.inOrder());
        System.out.println(orderTree.postOrder());
    }
}
