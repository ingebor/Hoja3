public class Sorting {
    public static void selectionSort(Comparable[] list){
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
    }

    private static void merge(int data[], int temp[], int low, int middle, int high){
        int ri = low;
        int ti= low;
        int di = middle;
        while (ti<middle && di<=high){
            if(data[di]<temp[di]){
                data[ri++] = data [di++];
            }
            else{
                data[ri++] = temp[ti++];
            }
            while (ti<middle){
                data[ri++] = temp [ti++];
            }
        }
    }
}
