package ja_va.dsa.linkedlist;

public class SingleLinkedList<T extends Comparable<T> > {
    private Integer size = 0;

    Integer getSize() {
        return size;
    }

    private Node<T> root = null;

    Node<T> add(T value) {
        Node<T> newNode = new Node<T>(value);
        if (root != null) {
            Node<T> temp = root;
            while (temp.nextRef != null) {
                temp = temp.nextRef;
            }
            temp.nextRef = newNode;
        } else {
            root = newNode;
        }
        size++;
        return newNode;
    }

    T remove(T value) {
        if (root.value.compareTo(value) == 0){
            root = root.nextRef;
            size--;
            return value;
        } else{
            Node<T> previousNode = root;
            Node<T> currentNode = root;
            while (currentNode != null) {
                if (currentNode.value.compareTo(value) == 0) {
                    previousNode.nextRef = currentNode.nextRef;
                    size--;
                    return currentNode.value;
                }
                previousNode = currentNode;
                currentNode = currentNode.nextRef;
            }
        }
        return null;
    }

    void display() {
        Node<T> currentNode = root;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.nextRef;
        }
    }
    public static void main(String[] args){
       SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.add(10);
        list.add(20);
        list.add(340);
        list.display();
        System.out.println();
        System.out.println(list.remove(30));
        System.out.println(list.remove(10));
        System.out.println(list.remove(20));
        list.display();
        list.add(10);
        list.add(20);
        list.add(0);
        list.display();
        System.out.println(list.size);
    }
}
