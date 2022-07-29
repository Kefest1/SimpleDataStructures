abstract class DoublyLinkedListDataStructure<T> {
    protected int size;
    protected MyData<T> start;
    protected MyData<T> end;

    public int getSize() {
        return size;
    }

    public void showList() {
        var buffer = start;
        if (size == 0)
            System.out.print("List is empty");
        while (buffer != null) {
            System.out.print(buffer.getData());
            System.out.print(" ");
            buffer = buffer.next;
        }
        System.out.println();
    }
}
