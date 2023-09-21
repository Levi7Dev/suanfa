package kuaishou;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Levi
 * @create 2023/8/8 9:21
 */
public class Tree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(6);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;

//        List<TreeNode> list = leftVal(node1);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i).val + " ");
//        }
        zSearch(node1);
    }

    //树的左侧值
    public static List<TreeNode> leftVal(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            boolean flag = true;
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if (flag) {
                    list.add(node);
                    flag = false;
                }
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
        }
        return list;
    }

    //z型遍历
    public static List<List<Integer>> zSearch(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean left2Right = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            //这里只是在插入的时候做了调整，整个树的遍历没有改变
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (left2Right) {
                    list.offerLast(node.val);
                } else {
                    list.offerFirst(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
            //改变方向
            left2Right = !left2Right;
        }

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }

        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
