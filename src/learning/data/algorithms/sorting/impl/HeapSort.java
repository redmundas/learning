package learning.data.algorithms.sorting.impl;

import learning.data.algorithms.sorting.SortStrategy;
import static learning.util.SortUtil.compare;

/**
 * Created by edmundas on 14.5.17.
 */
public class HeapSort implements SortStrategy {

    private Comparable[] data;
    private int size;
    private boolean reverse = false;

    @Override
    public void sort(Comparable[] array) {
        this.data = array;
        this.size = array.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }

    }

    @Override
    public void sort(Comparable[] array, boolean reverse) {
        this.reverse = reverse;
        sort(array);
    }

    private void heapify(int i) {
        int largestElementIndex = i;

        int l = leftChild(i);
        if (l < size && compare(data[largestElementIndex], data[l], reverse) > 0) {
            largestElementIndex = l;
        }

        int r = rightChild(i);
        if (r < size && compare(data[largestElementIndex], data[r], reverse) > 0) {
            largestElementIndex = r;
        }

        if (largestElementIndex != i) {
            Comparable swap = data[i];
            data[i] = data[largestElementIndex];
            data[largestElementIndex] = swap;

            heapify(largestElementIndex);
        }
    }

    private Comparable removeNext() throws RuntimeException {
        if (size == 0) {
            throw new RuntimeException("Something went wrong");
        }
        Comparable next = data[0];
        data[0] = data[--size];
        heapify(0);
        return next;
    }

    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }
}
