@SuppressWarnings("unchecked")
public class ArrayQueue<T> implements Queue<T>{
    private T[] array;
    private int head, size; //head as the starting "index" of the queue and size as the size of the queue
    //private Class<T> type;
    public static final int DEFAULT_SIZE = 10;
    public ArrayQueue(int initialSize) {
        head = size = 0;
        array = (T[])(new Object[initialSize]);
    }

    public ArrayQueue() {
        this(DEFAULT_SIZE);
    }


    public T dequeue() throws Exception {
        if (empty())
            throw new IndexOutOfBoundsException();
        size--;
        return array[(head++) % array.length]; //It's ok if head goes above array.length - 1
        // except when head goes over Integer.MAX_VALUE
    }

    public void enqueue(T item) {
        if (size >= array.length)
            expand();
        array[(head + (size++))%array.length] = item;
    }
    public boolean empty() {
        return size <= 0;
    }

    public int size() {
        return size;
    }

    private void expand() {
        T[] temp = (T[])(new Object[2*array.length]);
        for (int i = 0; i < size; i++)
            temp[i] = array[(head+i)%array.length];
        head = 0;
        array = temp;
    }

    public void display() {
        for (int i = 0; i < size - 1; i++)
            System.out.print(array[(head + i)%array.length] + "_");
        if (size > 0)
            System.out.println(array[(head + size - 1)%array.length]);
    }

    public int head() {
        return head%array.length;
    }
}
