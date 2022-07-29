// Another option that I have considered to be perfectly ok:
/*
public abstract class QueueStackAbstractClass<T> extends DoublyLinkedListDataStructure<T> {
    abstract public void push(T data);
    abstract public T pop();
}*/

public interface QueueStackInterface<T> {
    void push(T data);

    T pop();
}
