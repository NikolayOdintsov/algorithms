package com.nkodintsov.dataStructures.avlTree;

/**
 * Created by nikolay.odintsov on 31.05.18.
 */
public class AvlTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;

    @Override
    public void insert(T data) {
        this.root = insert(root, data);
    }

    @Override
    public void delete(T data) {
        if (this.root != null) {
            this.root = delete(this.root, data);
        }
    }

    private Node<T> delete(Node<T> node, T data) {
        if (node == null) return node;

        //first we have to look for a node we want to get rid of
        if (data.compareTo(node.getData()) < 0) { //data smaller than given node data -> go to the left recursively
            node.setLeftNode(delete(node.getLeftNode(), data));

        } else if (data.compareTo(node.getData()) > 0) { //data greater than given node data -> go to the right recursively
            node.setRightNode(delete(node.getRightNode(), data));

        } else { //we found the node to remove

            //node is a leaf case:
            if (node.getLeftNode() == null && node.getRightNode() == null) {
                System.out.println("Removing a leaf node..");
                return null;
            }

            //node has only one child case:
            if (node.getLeftNode() == null) {
                System.out.println("Removing the right child..");
                Node tempNode = node.getRightNode();
                node = null;

                return tempNode;
            } else if (node.getRightNode() == null) {
                System.out.println("Removing the left child..");
                Node tempNode = node.getLeftNode();
                node = null;

                return tempNode;
            }

            //the node with two children case:
            System.out.println("Removing item with two children..");
            Node<T> tempNode = getPredecessor(node.getLeftNode());

            node.setData(tempNode.getData());
            node.setLeftNode(delete(node.getLeftNode(), tempNode.getData()));

        }

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

        //we have to check on every deletion operation whether the tree has become unbalanced or not
        return settleDeletion(node);
    }

    private Node<T> settleDeletion(Node<T> node) {
        int balance = getBalance(node);

        if (balance > 1) { //left heavy case

            //left right heavy case
            if (getBalance(node.getLeftNode()) < 0) {
                node.setLeftNode(leftRotation(node.getLeftNode()));
            }

            //left-left heavy
            return rightRotation(node);
        }

        if (balance < 11) { //right heavy case

            //right left heavy case
            if (getBalance(node.getRightNode()) < 0) {
                node.setRightNode(rightRotation(node.getRightNode()));
            }

            //right-right heavy
            return leftRotation(node);
        }

        return node;
    }

    private Node<T> getPredecessor(Node<T> node) {
        if (node.getRightNode() != null) {
            return getPredecessor(node.getRightNode());
        }

        System.out.println("Predecessor is: " + node);
        return node;
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeftNode(insert(node.getLeftNode(), data));
        } else {
            node.setRightNode(insert(node.getRightNode(), data));
        }

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

        node = settleViolations(data, node);

        return node;
    }

    private Node<T> settleViolations(T data, Node<T> node) {
        // node is grand parent

        int balance = getBalance(node);

        //left heavy violation. Left-left
        if (balance > 1 && data.compareTo(node.getLeftNode().getData()) < 0) {
            return rightRotation(node);
        }

        //right heavy violation. Right-right
        if (balance < -1 && data.compareTo(node.getRightNode().getData()) > 0) {
            return leftRotation(node);
        }

        //Left-right heavy violation.
        if (balance > 1 && data.compareTo(node.getLeftNode().getData()) > 0) {
            node.setLeftNode(leftRotation(node.getLeftNode()));
            return rightRotation(node);
        }

        //Right-left heavy violation.
        if (balance < -1 && data.compareTo(node.getRightNode().getData()) < 0) {
            node.setRightNode(rightRotation(node.getRightNode()));
            return leftRotation(node);
        }

        return node;
    }

    @Override
    public void traverse() {
        if (this.root == null) return;

        inOrderTraversal(root);
    }

    private Node<T> rightRotation(Node<T> node) {
        System.out.println("Rotating to right on node: " + node);

        Node<T> tempLeftNode = node.getLeftNode();
        Node<T> t = tempLeftNode.getRightNode();
        tempLeftNode.setRightNode(node);
        node.setLeftNode(t);

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeftNode()), height(tempLeftNode.getRightNode())) + 1);

        return tempLeftNode;
    }

    private Node<T> leftRotation(Node<T> node) {
        System.out.println("Rotating to left on node: " + node);

        Node<T> tempRightNode = node.getRightNode();
        Node<T> t = tempRightNode.getLeftNode();
        tempRightNode.setLeftNode(node);
        node.setRightNode(t);

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        tempRightNode.setHeight(Math.max(height(tempRightNode.getLeftNode()), height(tempRightNode.getRightNode())) + 1);

        return tempRightNode;
    }

    private int height(Node<T> node) {
        if (node == null) {
            return -1;
        }

        return node.getHeight();
    }

    private int getBalance(Node<T> node) {
        if (node == null) {
            return 0;
        }

        return height(node.getLeftNode()) - height(node.getRightNode());
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.getLeftNode() != null) {
            inOrderTraversal(node.getLeftNode());
        }

        System.out.println(node);

        if (node.getRightNode() != null) {
            inOrderTraversal(node.getRightNode());
        }
    }
}
