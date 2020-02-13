import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public Array lista;
    public ArrayList listaFinal;
    public static void main(String args[]){
        ArrayList listaFinal = new ArrayList();

        //3000 datos
        int i = 0;
        int lista[] = new int[3000];
        while(i<3000){
            int numero = (int) (Math.random()*i) +1;
            lista[i]=numero;
            i++;
        }

        System.out.println("************Esta es la lista generada: "+Arrays.toString(lista));

        //******Quitar el comentario del que se desee probar******
        Sorting ob = new Sorting();
        //Selection sort
        //ob.selectionSort(lista);

       //Merge sort
        //ob.sort(lista,0,lista.length-1);

        //Quick sort
        /*int n = lista.length;
        ob.quickSort(lista,0,n-1);*/

        //radix sort
        /*int n = lista.length;
        ob.radixSort(lista,n);*/

        //Insertion sort
        ob.insertionSort(lista);


        System.out.println("\n\n************Lista ordenada: "+Arrays.toString(lista));
    }
}
