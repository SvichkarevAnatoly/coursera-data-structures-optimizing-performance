package textgen;

import java.util.AbstractList;


/**
 * A class that implements a doubly linked list
 *
 * @param <E> The type of the elements stored in the list
 * @author UC San Diego Intermediate Programming MOOC team
 */
public class MyLinkedList<E> extends AbstractList<E> {
    LLNode<E> head;
    LLNode<E> tail;
    int size;

    /**
     * Create a new empty LinkedList
     */
    public MyLinkedList() {
        head = new LLNode<>(null);
        tail = new LLNode<>(null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Appends an element to the end of the list
     *
     * @param element The element to add
     */
    public boolean add(E element) {
        add(size, element);
        return true;
    }

    /**
     * Get the element at position index
     *
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E get(int index) {
        validateIndex(index, size);

        // TODO: 25.08.18 optimize
        LLNode<E> current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }


    /**
     * Add an element to the list at the specified index
     *
     * @param index   where the element should be added
     * @param element The element to add
     */
    public void add(int index, E element) {
        validateIndex(index, size + 1);
        validateElement(element);

        // TODO: 25.08.18 validate
        // TODO: 25.08.18 optimize
        LLNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        new LLNode<>(element, current, current.next);
        size++;
    }


    /**
     * Return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Remove a node at the specified index and return its data element.
     *
     * @param index The index of the element to remove
     * @return The data element removed
     * @throws IndexOutOfBoundsException If index is outside the bounds of the list
     */
    public E remove(int index) {
        validateIndex(index, size);

        // TODO: 25.08.18 optimize
        LLNode<E> current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        E removedElement = current.data;
        current.prev.next = current.next;
        current.next.prev = current.prev;

        size--;

        return removedElement;
    }

    /**
     * Set an index position in the list to a new element
     *
     * @param index   The index of the element to change
     * @param element The new element
     * @return The element that was replaced
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E set(int index, E element) {
        validateIndex(index, size);
        validateElement(element);

        // TODO: 25.08.18 optimize
        LLNode<E> current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        E oldElement = current.data;
        current.data = element;
        return oldElement;
    }

    private void validateIndex(int index, int rightBoarder) {
        if (index < 0 || index >= rightBoarder) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void validateElement(E element) {
        if (element == null) {
            throw new NullPointerException();
        }
    }
}

class LLNode<E> {
    LLNode<E> prev;
    LLNode<E> next;
    E data;

    public LLNode(E e) {
        this.data = e;
        this.prev = null;
        this.next = null;
    }

    public LLNode(E e, LLNode<E> prev, LLNode<E> next) {
        this(e);
        prev.next = this;
        next.prev = this;
        this.next = next;
        this.prev = prev;
    }
}
