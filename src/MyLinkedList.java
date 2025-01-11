/**
 * MyLinkedList - custom {@code LinkedList}, {@code MyList} implementation
 * Contains first element and last element.
 * Each element contains next and previous
 *
 * @param <E> Type of elements of list
 */
public class MyLinkedList<E> implements MyList<E> {
    /**
     * quantity of elements
     */
    private Integer size = 0;

    /**
     *  first element
     */
    private MyNode<E> first;
    /**
     *  last element
     */
    private MyNode<E> last;

    /**
     * all arguments constructor
     * @param size quantity of elements
     * @param first first node
     * @param last last node
     */
    private MyLinkedList(Integer size, MyNode<E> first, MyNode<E> last) {
        this.size = size;
        this.first = first;
        this.last = last;
    }

    /**
     * default constructor
     */
    public MyLinkedList() {
    }

    /**
     * search node by index
     * @param index index of element to find
     * @return MyNode
     */
    private MyNode<E> findMyNode(Integer index){
        if (index < size / 2) {
            MyNode<E> myNode = first; //search from the first
            while (index != 0) {
                myNode = myNode.next;
                index--;
            }
            return myNode;
        } else {
            MyNode<E> myNode = last; //search from the last
            while (size - index - 1 != 0) {
                myNode = myNode.previous;
                index++;
            }
            return myNode;
        }
    }

    /**
     * add element to collection
     *
     * @param element element to add
     */
    @Override
    public void add(E element) {
        MyNode<E> node = new MyNode<>(element, last, null);
        if (last != null)
            last.next = node;
        if (size == 0)
            first = node;

        last = node;
        size++;
    }


    /**
     * remove element from collection
     *
     * @param index index of element to remove
     */
    @Override
    public void remove(int index) {

        MyNode<E> nodeForRemove = findMyNode(index);
        MyNode<E> previousNode = nodeForRemove.previous;
        MyNode<E> nextNode = nodeForRemove.next;

        previousNode.next  = nextNode;
        nextNode.previous = previousNode;
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
        return findMyNode(index).element;
    }

    /**
     * set element
     *
     * @param index   index of element to set
     * @param element element to set
     */
    @Override
    public void set(int index, E element) {
        findMyNode(index).element = element;
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
        MyNode<E> firstNode = findMyNode(beginIndex);
        MyNode<E> endNode = findMyNode(endIndex);
        Integer size = endIndex - beginIndex + 1;

        return new MyLinkedList<>(size,firstNode,endNode);
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
        return null;
    }

    /**
     * element of {@code MyLinkedList}
     * contains next element and previous element
     * @param <E> Type of element
     */
    private static class MyNode<E> {

        /**
         * Element of list
         */
        private E element;
        /**
         * next node
         */
        private MyNode<E> next;
        /**
         * previous node
         */
        private MyNode<E> previous;

        /**
         * all arguments constructor
         * @param element current element
         * @param previous previous node
         * @param next next node
         */
        public MyNode(E element, MyNode<E> previous, MyNode<E> next) {

            this.element = element;
            this.previous = previous;
            this.next = next;
        }


    }


}
