package main.java.DSA.SortAlgorithm;

public class BubbleSort {
    public static void bubbleSort(int arr[]) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1-i; j++) {
                if (arr[j] > arr[j + 1])
                {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 1, 3, 9, 7};
        bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
