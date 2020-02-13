/**
 * @author Ingebor Ayleen Rubio Vasquez 19003
 * @date 12/02/20
 * Hoja de trabajo 3
 */

import java.io.*;
import java.util.*;

public class Sorting {

    //Code by Rajat Mishra
    /**
     * Selection sort
     * @param arr
     */
    public void selectionSort(int arr[]){
        int n = arr.length;
        for(int i =0; i<n-1;i++){
            int min_idx = i;
            for (int j = i+1; j<n; j++){
                if (arr[j]<arr[min_idx]){
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    //Code by Rajat Mishra
    /**
     * Merge Sort
     * @param arr
     * @param l
     * @param m
     * @param r
     */
    void mergeSort(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    //Code by Rajat Mishra
    /**
     * sort
     * @param arr
     * @param l
     * @param r
     */
    void sort(int arr[], int l, int r){
        if (l < r)
        {
            int m = (l+r)/2;
            sort(arr, l, m);
            sort(arr , m+1, r);
            mergeSort(arr, l, m, r);
        }
    }

    //Code by Rajat Mishra
    /**
     * partition
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = (low-1);
        for(int j=low;j<high;j++){
            if (arr[j]<pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    //Code by Rajat Mishra
    /**
     * quick sort
     * @param arr
     * @param low
     * @param high
     */
    public void quickSort(int arr[], int low, int high){
        if (low<high){
            int pi = partition(arr,low,high);

            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    //Code by Devesh Agrawal
    /**
     * get max for radix sort
     * @param arr
     * @param n
     * @return
     */
    static int getMax(int arr[], int n){
        int mx = arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>mx){
                mx = arr[i];
            }
        }
        return mx;
    }

    /**
     * Count sort for radix sort
     * @param arr
     * @param n
     * @param exp
     */
    //Code by Devesh Agrawal
    static void countSort(int arr[], int n, int exp){
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        for( i=0 ; i<n; i++){
            count[(arr[i]/exp)%10]++;
        }
        for(i=1;i<10;i++){
            count[i] += count[i-1];
        }
        for (i = n - 1; i >= 0; i--){
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    //Code by Devesh Agrawal
    /**
     * radix sort
     * @param arr
     * @param n
     */
    static void radixSort(int arr[], int n){
        int m = getMax(arr,n);
        for(int exp=1; m/exp >0; exp *=10){
            countSort(arr,n,exp);
        }
    }

    //Code by Rajat Mishra
    /**
     * Insertion sort
     * @param arr
     */
    void insertionSort(int arr[]){
        int n = arr.length;
        for (int i = 1; i<n;i++){
            int key = arr[i];
            int j = i -1;
            while(j>= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j + 1] = key;
        }
    }
}
