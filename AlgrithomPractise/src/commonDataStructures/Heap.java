package commonDataStructures;

/**
 * A lot to notice: 0. the length is easier from 1 to size than from 0 to size-1
 * 1. heapify is to sink every element from size/2 to 1 2. while extract top
 * element, switch this element with the last element, then reduce the size by
 * 1, then sink top element
 * 
 * @author shen
 * 
 */
public class Heap {
	int size;
	int maxSize = 20;
	int[] array;

	public Heap(int[] input) {
		size = input.length;
		maxSize = Math.max(size * 2, 10);
		array = new int[maxSize];
		for (int i = 0; i < size; i++) {
			array[i + 1] = input[i];
		}
		heapify(array);
	}

	public Heap() {
		size = 0;
		maxSize = 10;
		array = new int[maxSize];
	}

	public int peekMin() {
		return array[1];
	}

	private int extractMin() {
		int tmp = array[1];
		swap(array, 1, size--);
		sink(array, 1);
		return tmp;
	}

	private void heapify(int[] array) {
		for (int i = size / 2; i >= 1; i--) {
			sink(array, i);
		}

	}

	public void put(int x) {
		if (size == maxSize) {
			maxSize *= 2;
			int[] tmpArray = new int[maxSize];
			for (int i = 1; i <= size; i++) {
				tmpArray[i] = this.array[i];
				array = tmpArray;
			}
		}

		array[++size] = x;
		percolate(array, size);
	}

	private void percolate(int[] array, int i) {
		if (i == 1)
			return;
		while (i > 1 && array[i] < array[i / 2]) {
			swap(array, i, i / 2);
			i = i / 2;
		}
	}

	private void sink(int[] array, int i) {
		int tmp = 0;
		if ((i * 2 + 1) > this.size)
			return;
		if ((i * 2 + 1) == this.size + 1) {
			tmp = array[2 * i];
		} else {
			tmp = array[2 * i] > array[2 * i + 1] ? (2 * i) : (2 * i + 1);
		}
		if (array[i] < array[tmp]) {
			swap(array, i, tmp);
			sink(array, tmp);
		}
	}

	public static void swap(int[] A, int a, int b) {
		A[a] ^= A[b];
		A[b] ^= A[a];
		A[a] ^= A[b];
	}

	public static void main(String[] args) {
		Heap heap = new Heap(new int[] { 6, 3, 2, 5, 0, 4, 1 });
		System.out.println(heap.peekMin());
		while (heap.size > 0) {
			System.out.println(heap.extractMin());
		}
	}
}
