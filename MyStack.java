
public class MyStack<T> extends DoublyLinkedListDataStructure<T>
        implements QueueStackInterface<T> {

    @Override
    public void push(T data) {
        if (size++ == 0) {
            start = end = new MyData<T>(data);
        }
        else {
            MyData<T> buf  = new MyData<>(data);
            buf.prev = end;
            end.next = buf;
            end = end.next;
        }
    }

    @Override
    public T pop() {
        if (size == 0) return null;

        T buf = end.getData();

        end = end.prev;
        if (end != null) end.next = null;
        size--;
        if (size == 0) start = null;

        return buf;
    }
}
