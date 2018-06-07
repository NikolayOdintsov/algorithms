package com.nkodintsov.dataStructures.lruCache;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by nikolay.odintsov on 06.06.18.
 */
public class LRUCache {
    private int actualSize;
    private Map<Integer, Node> map;
    private DoublyLinkedList linkedList;

    public LRUCache() {
        this.map = new HashMap<>();
        this.linkedList = new DoublyLinkedList();
    }

    public void put(int id, String data) {

        //update the data if present in the cache -> update
        if (map.containsKey(id)) {
            Node node = this.map.get(id);
            node.setData(data);

            System.out.println("Inside put: " + node);

            //node should be the head of d-linked list
            update(node);
            return;
        }

        //the data is not present in the cache -> insert
        Node node = new Node(id, data);

        //insert to the cache + set to be the head node
        if (this.actualSize < Constants.CAPACITY) {
            this.actualSize++;
            add(node);
        } else {

            //cache is full -> remove tail + insert new node
            removeTail();
            add(node);
        }

    }

    public Node get(int id) {
        if (!this.map.containsKey(id)) {
            return null;
        }

        Node node = this.map.get(id);

        //move node to the head
        update(node);
        return node;
    }

    //remove the last item (least recent used)
    private void removeTail() {
        //get node from map O(1)
        Node lastNode = this.map.get(this.linkedList.getTailNode().getId());

        //new tail is the previous node of old tail node
        this.linkedList.setTailNode(this.linkedList.getTailNode().getPreviousNode());

        //tail node has no next nodes
        if (this.linkedList.getTailNode() != null) {
            this.linkedList.getTailNode().setNextNode(null);
        }

        //obsolete ref
        lastNode = null;
    }

    //add node to the head
    private void add(Node node) {
        //node is the new head node
        node.setNextNode(this.linkedList.getHeadNode());

        //no previous node as it it head
        node.setPreviousNode(null);

        //old head point to the new head
        if (this.linkedList.getHeadNode() != null) {
            this.linkedList.getHeadNode().setPreviousNode(node);
        }

        this.linkedList.setHeadNode(node);

        if (this.linkedList.getTailNode() == null) {
            this.linkedList.setTailNode(node);
        }

        //we have to put node to map for search with O(1)
        this.map.put(node.getId(), node);
    }

    //move the node to the head
    private void update(Node node) {
        Node prevNode = node.getPreviousNode();
        Node nextNode = node.getNextNode();

        if (prevNode != null) {
            prevNode.setNextNode(nextNode);
        } else {
            this.linkedList.setHeadNode(nextNode);
        }

        if (nextNode != null) {
            nextNode.setPreviousNode(prevNode);
        } else {
            this.linkedList.setTailNode(prevNode);
        }

        //add node to the front
        add(node);
    }

    public void show() {
        Node actualNode = this.linkedList.getHeadNode();
        while (actualNode != null) {
            System.out.print(actualNode + "<->");
            actualNode = actualNode.getNextNode();
        }
    }
}
