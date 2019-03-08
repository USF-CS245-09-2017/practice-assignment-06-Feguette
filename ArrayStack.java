@SuppressWarnings("unchecked")
public class ArrayStack<T> implements Stack<T>{
    private T[] array;
    private int pointer; //The highest index containing an object
    public static final int DEFAULT_SIZE = 10;

    public ArrayStack(int initialSize) {
        pointer = -1;
        array = (T[])(new Object[initialSize]);
    }

    public ArrayStack() {
        this(DEFAULT_SIZE);
    }

    public void push(T item) {
        if (size() >= array.length)
            expand();
        array[++pointer] = item;
    }

    public T pop() throws Exception {
        if (empty())
            throw new IndexOutOfBoundsException();
        return array[pointer--];
    }

    public T peek() {
        if (empty())
            throw new IndexOutOfBoundsException();
        return array[pointer];
    }

    public boolean empty() {
        return pointer < 0;
    }

    public int size() {
        return pointer+1;
    }

    private void expand() {
        T[] temp = (T[])(new Object[2*array.length]);
        for (int i = 0; i < array.length; i++)
            temp[i] = array[i];
        array = temp;
    }

    public void display() {
        for (int i = 0; i < pointer; i++)
            System.out.print(array[i] + "_");
        if (pointer >= 0)
            System.out.println(array[pointer]);
    }
}
