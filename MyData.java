
public class MyData<T> {
    public MyData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    private T data;
    protected MyData<T> next;
    protected MyData<T> prev;
}
