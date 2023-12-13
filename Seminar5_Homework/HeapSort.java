package Seminar5_Homework;

public class HeapSort {

    public void sortArray(int arr[]) {
        int length = arr.length;

        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(arr, length, i);
        }

        for (int i = length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int length, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Если левый дочерний элемент больше корня
        if (left < length && arr[left] > arr[largest]) {
            largest = left;
        }

        // Если правый дочерний элемент больше, чем самый большой элемент на данный
        // момент
        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }

        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, length, largest);
        }
    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
