import java.io.*;
import java.util.*;

public class Sorting {

    //Code by Rajat Mishra
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
    public void mergeSort(int arr[], int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int L[] = new int [n1];
        int R[] = new int [n2];
        for(int i= 0; i<n1;i++){
            L[i] = arr[l+i];
        }
        for(int j=0; j<n2;j++){
            L[j] = arr[m+1+j];
        }

        int i = 0, j=0;

        int k = l;
        while (i<n1 &&j<n2){
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
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    //Code by Rajat Mishra
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
    public void quickSort(int arr[], int low, int high){
        if (low<high){
            int pi = partition(arr,low,high);

            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    static int getMax(int arr[], int n){
        int mx = arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>mx){
                mx = arr[i];
            }
        }
        return mx;
    }

    static void countSort(int arr[], int n, int exp){
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        for(i=0 : i<n; i++){
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
    static void radixSort(int arr[], int n){
        int m = getMax(arr,n);
        for(int exp=1; m/exp >0; exp *=10){
            countSort(arr,n,exp);
        }
    }

    void sort(int arr[]){
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
