package main.java.DSA.SortAlgorithm;

public class SelectionSort {

        public static void selectionSort(int arr[]) {
            int size = arr.length;
            for (int i = 0; i < size  ; i++) {
                int min = arr[i];
                int pos = i;
                for (int j = i+1 ; j < size  ; j++) {
                    if (arr[j] < min)
                    {
                        min = arr[j];
                        pos = j;
                    }
                }
                arr[pos] = arr[i];
                arr[i] = min;
            }
        }

        public static void main(String[] args) {
            int[] a = {5, 2, 1, 3, 9, 7};
            selectionSort(a);
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
        }
}
