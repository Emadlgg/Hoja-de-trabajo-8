import java.util.PriorityQueue;

public class VectorHeap<E extends Comparable<E>> {
    private PriorityQueue<E> heap;

    public VectorHeap() {
        heap = new PriorityQueue<>();
    }

    public void add(E element) {
        heap.add(element);
    }

    public E remove() {
        return heap.poll();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
