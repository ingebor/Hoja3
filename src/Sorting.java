public class Sorting {
    /*public static void selectionSort(Comparable[] list){
       int min;
       Comparable temp;
       for(int index = 0; index<list.length-1;index++){
            min=index;
            for(int scan = index+1; scan<list.length;scan++){
                if(list[scan].compareTo(list[min])<0){
                    min = scan;
                }
            }
            temp = list[min];
            list[min] = list[index];
            list[index]=temp;
       }
    }*/
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
}
