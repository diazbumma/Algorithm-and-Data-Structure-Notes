package heap;

import java.util.Arrays;

public class MinHeap {

    static class Heap {

        private int capacity = 10;
        private int size = 0;

        private int[] items = new int[capacity];

        private int getLeftChildIndex(int parentIndex) {
            return 2 * parentIndex + 1;
        }

        private int getRightChildIndex(int parentIndex) {
            return 2 * parentIndex + 2;
        }

        private int getParentIndex(int childIndex) {
            return (childIndex - 1) / 2;
        }

        private boolean hasLeftChild(int index) {
            return getLeftChildIndex(index) < size;
        }

        private boolean hasRightChild(int index) {
            return getRightChildIndex(index) < size;
        }

        private boolean hasParent(int index) {
            return getParentIndex(index) >= 0;
        }

        private int leftChild(int index) {
            return items[getLeftChildIndex(index)];
        }

        private int rightChild(int index) {
            return items[getRightChildIndex(index)];
        }

        private int parent(int index) {
            return items[getParentIndex(index)];
        }

        private void swapWithIndex(int indexOne, int indexTwo) {
            int temp = items[indexOne];
            items[indexOne] = items[indexTwo];
            items[indexTwo] = temp;
        }

        private void ensureEnoughCapacity() {
            if (size == capacity) {
                capacity *= 2;
                items = Arrays.copyOf(items, capacity);
            }
        }

        public int peek() {
            if (size == 0)
                throw new IllegalStateException();
            return items[0];
        }

        public int poll() {
            if (size == 0)
                throw new IllegalStateException();
            int item = items[0];
            items[0] = items[size-1];
            --size;
            heapifyDown(0);
            return item;
        }

        private void heapifyUp() {
            int traverse = size - 1;
            while (hasParent(traverse) && parent(traverse) > items[traverse]) {
                swapWithIndex(getParentIndex(traverse), traverse);
                traverse = getParentIndex(traverse);
            }
        }

        private void heapifyDown(int traverse) {
            while (hasLeftChild(traverse)) {
                int smallerChildIndex = getLeftChildIndex(traverse);
                if (hasRightChild(traverse) && rightChild(traverse) < leftChild(traverse))
                    smallerChildIndex = getRightChildIndex(traverse);

                if (items[smallerChildIndex] < items[traverse])
                    swapWithIndex(smallerChildIndex, traverse);
                else
                    break;

                traverse = smallerChildIndex;
            }
        }

        public void add(int val) {
            ensureEnoughCapacity();
            items[size] = val;
            ++size;
            heapifyUp();
        }

        public void delete(int i) {
            if (i >= size)
                throw new IllegalStateException();
            items[i] = items[size-1];
            --size;
            heapifyDown(i);
        }

        public int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();

        heap.add(15);
        heap.add(6);
        heap.add(9);
        heap.add(7);
        heap.add(20);
        heap.add(5);
        heap.add(11);

        System.out.println("Extract min: " + heap.poll());
        System.out.println("Current min: " + heap.peek());
        System.out.println("Current size: " + heap.size());

        heap.delete(4);
        System.out.println("Current min: " + heap.peek());
        System.out.println("Current size: " + heap.size());
    }
}
