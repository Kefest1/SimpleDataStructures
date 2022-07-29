public class MyDoublyLinkedList<T> extends DoublyLinkedListDataStructure<T> {

    public MyDoublyLinkedList() {}

    public MyDoublyLinkedList(T data) {
        size = 1;
        start = end = new MyData<>(data);
    }

    public void addLast(T data) {
        if (size == 0)
            start = end = new MyData<>(data);
        else {
            end.next = new MyData<>(data);
            end.next.prev = end;
            end = end.next;
        }
        size++;
    }

    public void addFirst(T data) {
        if (size == 0)
            start = end = new MyData<>(data);
        else {
            var buffer = new MyData<>(data);
            buffer.next = start;
            start.prev = buffer;
            start = buffer;
        }
        size++;
    }

    public boolean addByIndex(T data, int index) {
        if (index > size) return false;

        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            var buffer = start;
            for (int i = 0; i < index; i++)
                buffer = buffer.next;

            var insert = new MyData<>(data);
            insert.next = buffer;
            insert.prev = buffer.prev;

            var buf = buffer.prev;
            buffer.prev = insert;
            buf.next = insert;
            size++;
        }

        return true;
    }

    public T getByIndex(int index) {
        if (index > size) return null;

        var buffer = start;

        for (int i = 0; i < index; i++)
            buffer = buffer.next;

        return buffer.getData();
    }

    public T popFirst() {
        if (size == 0) return null;
        if (size == 1) {
            var buffer = start;
            start = end = null;
            size--;
            return buffer.getData();
        }

        var buffer = start;
        start = start.next;
        start.prev = null;
        size--;

        return buffer.getData();
    }

    public T popLast() {
        if (size == 0) return null;
        if (size == 1) {
            var buffer = end;
            start = end = null;
            size = 0;
            return buffer.getData();
        }

        var buffer = end;
        end = end.prev;
        if (end != null) end.next = null;
        size--;

        return buffer.getData();
    }

    public T deleteByIndex(int index) {
        if (size == 0) return null;
        if (index == 0) return popFirst();
        if (index == size) return popFirst();

        var buffer = start;
        for (int i = 0; i < index; i++)
            buffer = buffer.next;

        buffer.prev.next = buffer.next;
        buffer.next.prev = buffer.prev;
        size--;

        return buffer.getData();
    }
}
