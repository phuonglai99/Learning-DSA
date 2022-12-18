package main.java.DSA.SortAlgorithm;

public class InsertionSort {
    public static void insertionSort(int arr[]) {
        int size = arr.length;
        for (int i = 0; i < size  ; i++) {
            for (int j = i ; j >0  ; j--) {
                if (arr[j] < arr[j-1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                else break;
            }

        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 1, 3, 9, 7,9,7};
        insertionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
