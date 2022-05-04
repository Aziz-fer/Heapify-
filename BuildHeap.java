import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BuildHeap {

    // To heapify a subtree rooted with node i which is
    // an index in arr[].Nn is size of heap
    public static void minHeapify(int arr[], int i, int n) {
        int min = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // left child smaller than parent
        if (l < n && arr[l] < arr[min])
            min = l;

        //right child smaller tha parent
        if (r < n && arr[r] < arr[min])
            min = r;

        // neither is small enough
        if (min != i) {
            int swap = arr[i];
            arr[i] = arr[min];
            arr[min] = swap;

            minHeapify(arr, min, n);
        }
    }

    public static void buildMinHeap(int arr[]) {
        int n = arr.length;
        for (int i = n; i >= 0; i--)
            minHeapify(arr, i, n);
    }
    public static void buildMinHeap(int arr[],int n) {
        for (int i = n; i >= 0; i--)
            minHeapify(arr, i, n);
    }
    // A utility function to print the array
    // representation of Heap
    public static void printHeap(int arr[], int n) {
        System.out.println(
                "Array representation of MinHeap is:");

        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
    public static int extractMin(int[] data, int n) {

        int min = data[0]; //min extracted
        for (int i = 0 ; i<n-1 ; i++)
        { data [i] = data [i+1]  ;} //copy of array without the minimum element
        n-- ;
        buildMinHeap(data);
        printHeap(data, n);
        data[n] = min ; //addition of min element at the end of data position n-1
        System.out.println( java.util.Arrays.toString(data));
        return min ;
    }
    public static int heapSelect(int[] data, int k) {
        int kelement = 0 ;
        int n = data.length   ;
        for (int i = 0 ; i < k ; i++)
        {
            kelement = extractMin( data , n)  ;

            n-- ;
            //data[n]= 1000 ; // data
            buildMinHeap(data,n);
            //System.out.println( i + java.util.Arrays.toString(data) );
            //System.out.println(i + "-element " + kelement ) ;
        }

        return data[n] ;
    }
    public static void main(String args[]) {
        String input0 = args[0];
        try
        {
            int k = Integer.parseInt(input0) ;
        }
        catch (NumberFormatException e)
        {
            System.out.println(input0 + " is not a valid integer");
            System.exit(1);
        }
        int k = Integer.parseInt(input0);
        if (k<=0) {
            System.out.println( " argument is not valid nik rbk ");
            System.exit(1);
        }

        Scanner input = new Scanner(System.in);
        ArrayList data = new ArrayList<Integer>();
        try {
            while (input.hasNextLine()) {
                data.add(Integer.parseInt(input.nextLine()));
            }

            int[] Array = new int[data.size()];
            for (int i = 0; i < data.size(); i++) {
                Array[i] = (int) data.get(i);


                buildMinHeap(Array);
                printHeap(Array, Array.length);

                int y = extractMin(Array,Array.length) ;
                System.out.println("min ist " + y) ;

                int x = heapSelect(Array,k) ;
                System.out.println( " Das " + k + "-kleineste Element von " + java.util.Arrays.toString(Array) +
                        " ist" + x );


            }
        }
        catch (NumberFormatException e) {

            System.out.println("Something went wrong");
        }
    }
}