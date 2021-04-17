package sortings;

//Min Heap
//for values from 0 to 100
public class MinHeap {

    private int[] list;
    //current capacity
    private int cc;


    public MinHeap(int cap) {
        this.list = new int[cap];
        cc = 0;
    }

    public int getMin() {
        if(cc == 0)
            return -1;
        return list[0];
    }

    public int extractMin() {
        if (cc == 0)
            return -1;
        int min = list[0];
        list[0] = list[cc-1];
        cc--;
        minHeapify(0);
        return min;
    }

    //set new value at index
    public void setNewKey(int index, int newVal) {
        if(index >=0 && index < cc) {
            if(newVal <= list[index]) {
                list[index] = newVal;
                while (index != 0 && list[parent(index)] > list[index]) {
                    swap(parent(index), index);
                    index = parent(index);
                }
            } else {
                list[index] = newVal;
                minHeapify(index);
            }
        }
    }

    //Insert new value
    public void insertKey(int newVal) {
        setNewKey(cc++, newVal);
    }

    //delete key at index
    public void deleteKey(int index) {
        //set small value at index
        setNewKey(index, -1);
        extractMin();
    }

    private void minHeapify(int index) {
        if(index >= cc)
            return;
        int l = leftChild(index);
        int r = rightChild(index);
        int smallest = index;
        if(l < cc && list[smallest] > list[l])
            smallest = l;
        if(r < cc && smallest > list[r])
            smallest = r;
        if(smallest != index) {
            swap(index, smallest);
            minHeapify(smallest);
        }
    }

    private int parent(int i) {
        return (i-1)/2;
    }

    private int leftChild(int i) {
        return 2*i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int t = list[i];
        list[i] = list[j];
        list[j] = t;
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        MinHeap h = new MinHeap(11);
        h.insertKey(3);
        h.insertKey(2);
        h.deleteKey(1);
        h.insertKey(15);
        h.insertKey(5);
        h.insertKey(4);
        h.insertKey(45);
        System.out.print(h.extractMin() + " ");
        System.out.print(h.getMin()+ " ");
        h.setNewKey(2, 1);
        System.out.print(h.getMin());
    }
}
