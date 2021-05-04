package com.tian;

import java.util.*;

/**
 * @author tomtian
 * @create 2021-03-16 22:19 赫夫曼树
 */
public class HuffmanTree {
    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        Collections.addAll(list,new Node('a',1),new Node('b',1),new Node('c',2),new Node('d',3),
                new Node('e',5),new Node('f',8),new Node('g',13),new Node('h',21));
        Node node = create(list);
//        node.preOrder();
        //char 的默认值为0
//        System.out.println(0==node.ch);
//        System.out.println(weigthedPathLength(node));
        coding(node,"0","1");
        node.preOrder();
    }
    public static Node create(List<Node> list){
        while (list.size()>1){
            Collections.sort(list, (Node n1,Node n2)->{return n1.value-n2.value;});
            Node n1 = list.get(0);
            Node n2 = list.get(1);
            Node node = new Node(n1.value+n2.value);
            node.left= n1;
            node.right = n2;
            list.remove(n1);
            list.remove(n2);
            list.add(node);
        }
//        System.out.println(list);
        return list.get(0);
    }
    //wpl带权路径长度
    //广度优先遍历
    public static int weigthedPathLength(Node root){
        int wpl =0;
        int count =0;
        Queue<Node> queue =new LinkedList<>();
        if (root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            LinkedList<Node> linkedList =new LinkedList<>();
            for (int i = queue.size(); i >0 ; i--) {
                Node poll = queue.poll();
                linkedList.add(poll);
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
            }
            for (Node node:linkedList
                 ) {
                if (node.ch!=0){
                    wpl+=count*node.value;
                }
            }
            count++;
        }
        return wpl;
    }

    public static void coding(Node root,String left,String right){
        coding(root,left,right,left,right);
    }
    //编码
    public static void coding(Node root,String left,String right,String appendLeft,String appendRight){
        if (root.left!=null){
            root.left.str=appendLeft;
            coding(root.left,left,right,appendLeft+left,appendRight+right);
        }
        if (root.right!=null){
            root.right.str=appendRight;
            coding(root.right,left,right,appendRight+left,appendRight+right);
        }
    }
}
class Node {
    //赋值abc
    char ch;
    int value;
    //用于编码010101
    String str;
    Node left;
    Node right;

    public Node(char ch, int value) {
        this.ch = ch;
        this.value = value;
    }

    public Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "value="+value+"char="+ch+"str="+str;
    }

    public void preOrder(){
        System.out.println(this.toString());
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    public void midOrder(){
        if (this.left!=null){
            this.left.midOrder();
        }
        System.out.print(this.value);
        if (this.right!=null){
            this.right.midOrder();
        }
    }
    public void backOrder(){
        if (this.left!=null){
            this.left.backOrder();
        }

        if (this.right!=null){
            this.right.backOrder();
        }
        System.out.print(this.value);
    }
}