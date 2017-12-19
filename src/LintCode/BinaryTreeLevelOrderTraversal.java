package LintCode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    // 下面这种写法是错误的 只能使用队列而不能使用栈
    public static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return result;
        stack.push(root);
        // 当循环要推出第二个元素的时候 最顶端会是第一个元素的子节点
        while (!stack.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = stack.pop();
                level.add(head.val);
                if (head.right != null)
                    stack.push(head.right);
                if (head.left != null)
                    stack.push(head.left);
            }
            result.add(level);
        }
        return result;
    }

    // 队列的写法才是正确的
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return result;
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if(head.left != null)
                    queue.offer(head.left);
                if(head.right != null)
                    queue.offer(head.right);
            }
            result.add(level);
        }
        return result;
    }
}
