

/**
 * interface MyList - custom java.util.{@code List}
 * it is Aston online intensive task
 * @param <E> Type of elements of list
 */
public interface MyList<E> {


    /**
     * add element to collection
     * @param element element to add
     */
    void add(E element);

    /**
     * remove element from collection
     * @param index index of element to remove
     */
    void remove(int index);

    /**
     * get element by index
     * @param index index of element to get
     * @return element
     */
    E get(int index);

    /**
     * set element 
     * @param index index of element to set
     * @param element element to set
     */
    void set(int index, E element);

    /**
     * get subList from beginIndex to endIndex
     * @param beginIndex first index of subList
     * @param endIndex last index of subList
     * @return subList
     */
    MyList<E> subList(int beginIndex ,int endIndex);

    /**
     * return size of this list
     * @return size(number of elements)
     */
    int size();

    /**
     * map MyList to Array
     * @return Array
     */
    Object[] toArray();


}
