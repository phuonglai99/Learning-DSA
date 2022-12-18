package main.java.DSA.SortAlgorithm;

public class MergeSort {
    public static void merge(int [] c, int start, int end, int mid){
        int[] arr = new int[end+1];
        //System.out.println("merge chuoi "+start+" " +end+" "+mid);
        for(int i=start;i<=end;i++){
            arr[i] = c[i];
        }
        int indexEnd = mid+1, indexStart = start, indexc = start;

        while(indexc<arr.length){
            if(indexStart > mid) {
                //System.out.println("debug 1: "+arr[indexEnd]+" "+indexc);
                c[indexc] = arr[indexEnd++];
                //indexb++;

            }
            else if(indexEnd > end) {
                //System.out.println("debug 2: "+arr[indexStart]+" "+indexc);
                c[indexc] = arr[indexStart++];
                //indexa++;
            }
            else if(arr[indexStart]>arr[indexEnd]){
                //System.out.println("debug 3: "+arr[indexEnd]+" "+indexc);
                c[indexc] = arr[indexEnd++];
                //indexb++;
            }
            else {
                //System.out.println("debug 4: "+arr[indexStart]);
                c[indexc] = arr[indexStart++];
                //indexa++;
            }
            indexc++;
        }
    }

    public static void devide(int arr[],int start,int end){
        if(start<end) {
            int mid = (start + end) / 2;
            devide(arr, start, mid);
            devide(arr, mid + 1, end);
            merge(arr, start, end, mid);
        }
    }
    public static void main(String[] args) {
        int [] a = {5,5,5,5,5,5};
        devide(a,0,a.length-1);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
