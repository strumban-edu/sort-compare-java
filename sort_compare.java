import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class sort_compare {
    public static Scanner scan = new Scanner(System.in);

    // Given arrayLength as argument, create an array of random integers between 0 and 100; return the created array.
    public static int[] createRandomArray(int arrayLength) {
        Random rand = new Random();
        
        int[] arrayInts = new int[arrayLength];
        for (Integer i = 0; i < arrayInts.length; i++) {
            arrayInts[i] = rand.nextInt(10000);
        }

        return arrayInts;
    }

    static void merge_sort(int[] arr, int first, int last) {
        if (first < last) {
            int middle = first + (last - first) / 2;

            merge_sort(arr, first, middle);
            merge_sort(arr, middle + 1, last);

            merge(arr, first, middle, last);
        }
    }

    static void merge(int[] arr, int first, int middle, int last) {
        int len1 = middle - first + 1;
        int len2 = last - middle;
        
        int[] arrL = new int[len1];
        int[] arrR = new int[len2];

        for (int i = 0; i < len1; ++i) {
            arrL[i] = arr[first + i];
        }
        for (int j = 0; j < len2; ++j) {
            arrR[j] = arr[middle + 1 + j];
        }

        int tracker1 = 0, tracker2 = 0;

        int k = first;
        while (tracker1 < len1 && tracker2 < len2) {
            if (arrL[tracker1] <= arrR[tracker2]) {
                arr[k] = arrL[tracker1++];
            } else {
                arr[k] = arrR[tracker2++];
            }

            k++;
        }

        while (tracker1 < len1) {
            arr[k] = arrL[tracker1++];
            k++;
        }

        while (tracker2 < len2) {
            arr[k] = arrR[tracker2++];
            k++;
        }
    }

    static void bubble_sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean changed = false;
            for (int j = 0; j < arr.length - 1; j++) {
                int tempVar = arr[j];
                if (tempVar > arr[j + 1]) {
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tempVar;
                    changed = true;
                }
            }

            if (changed == false) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("----------------------------------------");
        System.out.println("--                                    --");
        System.out.println("--            SORT COMPARE            --");
        System.out.println("--         highly  efficient!         --");
        System.out.println("--                                    --");
        System.out.println("----------------------------------------");
        System.out.println();

        System.out.print("How many integers do you want generated: ");
        String usrInput = scan.nextLine();
        args = usrInput.split(" ");
        int mainInt = Integer.parseInt(args[0]);
        System.out.println();

        int[] newArr = createRandomArray(mainInt);
        int[] arr1 = newArr.clone();
        int[] arr2 = newArr.clone();

        long start2 = System.nanoTime();
        merge_sort(arr2, 0, newArr.length - 1);
        long end2 = System.nanoTime();
        System.out.println("Initial array: " + Arrays.toString(arr2));
        System.out.println("Sorted array: " + Arrays.toString(arr1));
        System.out.println();

        System.out.println("Bubble Sort:");
        long start1 = System.nanoTime();
        bubble_sort(arr1);
        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: "+ (end1 - start1));
        System.out.println();

        System.out.println("Merge Sort:");
        System.out.println("Elapsed Time in nano seconds: "+ (end2 - start2));      
    }
}
