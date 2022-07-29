
public class MyQueue<T> extends DoublyLinkedListDataStructure<T>
        implements QueueStackInterface<T> {

    @Override
    public void push(T data) {
        if (size == 0) {
            start = new MyData<>(data);
            end = start;
        } else {
            end.next = new MyData<T>(data);
            end.next.prev = end;
            end = end.next;
        }
        size++;
    }

    @Override
    public T pop() {
        if (size == 0) return null;
        MyData<T> buffer = start;
        start = start.next;
        if (start != null) start.prev = null;
        size--;
        return buffer.getData();
    }
}
