/**
 * MyArrayList - custom {@code ArrayList}, implementation for MyList,
 * Contains array of elements
 * @param <E> Type of elements of list
 */
public class MyArrayList<E> implements MyList<E> {


    /**
     * Array
     */
    private Object[] objects;

    /**
     * quantity of elements
     */
    private Integer size;


    /**
     *  default capacity of array
     */
    private static final Integer initialCapacity = 10;

    /**
     * constructor for empty list
     */
    public MyArrayList() {
        objects = new Object[initialCapacity];
        size = 0;
    }

    /**
     * list based constructor
     * @param myList list based on which MyArrayList is created
     */
    public MyArrayList(MyList<E> myList) {
        objects = myList.toArray();
        size = myList.size();
    }


    /**
     * add element to collection
     *
     * @param element element to add
     */
    @Override
    public void add(E element) {

        if (size >= objects.length) {
            Object[] newObjects = new Object[objects.length * 2];
            for (int i = 0; i < objects.length; i++) { // copy array
                newObjects[i] = objects[i];
            }
            newObjects[size] = element; // add element
            objects = newObjects;
            size++;
        } else {
            objects[size] = element;
            size++;
        }


    }

    /**
     * remove element from collection
     *
     * @param index index of element to remove
     */
    @Override
    public void remove(int index) {

        for (int i = index; i < size; i++) {
            objects[i] = objects[i + 1];
        }
        size--;

    }

    /**
     * get element by index
     *
     * @param index index of element to get
     * @return element
     */
    @Override
    public E get(int index) {
        return (E) objects[index];
    }

    /**
     * set element
     *
     * @param index   index of element to set
     * @param element element to set
     */
    @Override
    public void set(int index, E element) {
        objects[index] = element;
    }

    /**
     * get subList from beginIndex to endIndex
     *
     * @param beginIndex first index of subList
     * @param endIndex   last index of subList
     * @return subList
     */
    @Override
    public MyList<E> subList(int beginIndex, int endIndex) {

        MyList<E> subList = new MyArrayList<>();
        for (int i = beginIndex; i < endIndex + 1; i++) {
            subList.add((E) objects[i]);
        }

        return subList;
    }

    /**
     * return size of this list
     *
     * @return size(number of elements)
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * map MyList to Array
     *
     * @return Array
     */
    @Override
    public Object[] toArray() {
        return objects;
    }
}
