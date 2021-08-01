package bai_10_dsa_danh_sach.bai_tap.trien_khai_cac_phuong_thuc_cua_linked_list;

public class MyLinkedList<E> {
    private Node head;
    private Node tail;
    private int numNodes;

    public MyLinkedList() {
        this.numNodes = 0;
        this.head = null;
        this.tail = null;
    }

    public void add(int index, Node node) {
        if (index == 0) {
            addFirst(node);
        } else if (index >= this.numNodes) {
            addLast(node);
        } else {
            Node preNode = null;
            Node currentNode = this.head;
            int count = 0;
            while (count < index) {
                count++;
                preNode = currentNode;
                currentNode = currentNode.next;
            }
            node.next = currentNode;
            preNode.next = node;
        }
    }

    public void addFirst(Node node) {
        int index = 0;
        if (index < 1) {
            this.head = node;
            node.next = null;

            if (this.tail == null) {
                this.tail = node;
            }

            this.numNodes++;
        }
    }

    public void addLast(Node node) {
        int index = this.numNodes;
        if (index == this.numNodes) {
            if (this.tail != null) {
                this.tail.next = node;
            }
            this.tail = node;

            if (this.head == null) {
                this.head = node;
            }

            this.numNodes++;
        }
    }

    public Node remove(int index) {
        Node preNode = null;
        Node currentNode = this.head;
        int count = 0;
        while (currentNode != null) {
            if (currentNode.indexData(index)) {
                if (count == 0) {
                    this.head = this.head.next;
                    if (this.head == null) {
                        this.tail = null;
                    }
                } else if (count == this.numNodes - 1) {
                    preNode.next = null;
                    this.tail = preNode;
                } else {
                    preNode.next = currentNode.next;
                }
                this.numNodes--;
            }
            count++;
            preNode = currentNode;
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public int size() {
        return this.numNodes;
    }

    public boolean contains(Node node) {
        Node preNode = null;
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.data == node) {
                return true;
            }
            preNode = currentNode;
            currentNode = currentNode.next;
        }
        return false;
    }
}
