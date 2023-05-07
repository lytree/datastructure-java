package top.lytree.datastructure;

import top.lytree.UnrealizedException;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class LinkedList<T> implements List<T> {

    transient int size = 0;

    /**
     * 首节点
     */
    transient Node<T> first;

    /**
     * 未节点
     */
    transient Node<T> last;


    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> pre;

        public Node(T value, Node<T> next, Node<T> pre) {
            this.value = value;
            this.next = next;
            this.pre = pre;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        List.super.forEach(action);
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> x = first; x != null; x = x.next)
            result[i++] = x.value;
        return result;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnrealizedException();
    }

    @Override
    public <T1> T1[] toArray(IntFunction<T1[]> generator) {
        throw new UnrealizedException();
    }

    @Override
    public boolean add(T t) {
        final Node<T> l = last;
        final Node<T> curr = new Node<T>(t, null, l);
        if (first == null) {
            first = curr;
        } else {
            l.next = curr;
        }
        last = curr;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.value == null) {
                    removeNode(x);
                    return true;
                }
            }
        } else {
            for (Node<T> x = first; x != null; x = x.next) {
                if (o.equals(x.value)) {
                    removeNode(x);
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;

        Node<T> pred, succ;
        if (index == size) {
            succ = null;
            pred = last;
        } else {
            succ = getNode(index);
            pred = succ.pre;
        }

        for (Object o : a) {
            @SuppressWarnings("unchecked") T e = (T) o;
            Node<T> newNode = new Node<>(e, null, pred);
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            pred = newNode;
        }

        if (succ == null) {
            last = pred;
        } else {
            pred.next = succ;
            succ.pre = pred;
        }

        size += numNew;
        return true;

    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return List.super.removeIf(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super T> c) {
        List.super.sort(c);
    }

    @Override
    public void clear() {
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.next;
            x.value = null;
            x.next = null;
            x.pre = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        Node<T> x = getNode(index);
        return x.value;

    }

    @Override
    public T set(int index, T element) {
        Node<T> l = getNode(index);
        T oldVal = l.value;
        l.value = element;
        return oldVal;
    }


    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnrealizedException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnrealizedException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnrealizedException();
    }

    @Override
    public Spliterator<T> spliterator() {
        throw new UnrealizedException();
    }

    @Override
    public Stream<T> stream() {
        throw new UnrealizedException();
    }

    @Override
    public Stream<T> parallelStream() {
        throw new UnrealizedException();
    }

    private Node<T> getNode(int index) {
        Node<T> l = first;
        for (int i = 0; i < index; i++) {
            l = l.next;
        }
        return l;
    }

    private void removeNode(Node<T> x) {
        final Node<T> pre = x.pre;
        final Node<T> next = x.next;
        // 首节点
        if (pre == null) {
            first = next;
        } else {
            pre.next = next;
            x.pre = null;
        }
        //尾节点
        if (next == null) {
            last = pre;
        } else {
            next.pre = pre;
            x.next = null;
        }
        x.value = null;
        size--;
    }

}
