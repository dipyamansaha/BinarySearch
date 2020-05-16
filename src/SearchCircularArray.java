// SEARCHING AN ELEMENT IN A CIRCULARLY SORTED ARRAY...

import java.util.Arrays;
import java.util.Scanner;

public class SearchCircularArray
{
    static int CircularArraySearch(int[] Arr, int num)
    {
        int low = 0;
        int high = (Arr.length - 1);

        while(low <= high)
        {
            int mid = (low + high)/2;       // Or, mid = low + (high - low)/2

            if(num == Arr[mid])     // Case-1: Element found!
                return mid;

            if(Arr[mid] <= Arr[high])       // Case-2: The right half is sorted.
            {
                if((num > Arr[mid]) && (num <= Arr[high]))      // Case 2A: Go searching in the right
                    low = (mid + 1);                            // sorted half.
                else        // Case 2B: Go searching in the left half.
                    high = (mid - 1);
            }
            else        // Case-3: The left half is sorted.
            {
                if((num < Arr[mid]) && (num >= Arr[low]))       // Case 3A: Go searching in the left sorted half.
                    high = (mid - 1);
                else        // Case 3B: Go searching in the right half.
                    low = (mid + 1);
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        System.out.println("SEARCHING AN ELEMENT IN A CIRCULARLY SORTED ARRAY...\n");

        int[] Arr = {7, 8, 9, 10, 1, 2, 3, 4, 5, 6};

        System.out.println("The array: " + Arrays.toString(Arr));

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the element that you wanna search for: ");
        int num = sc.nextInt();

        int index = CircularArraySearch(Arr, num);
        if(index!=-1)
            System.out.println(num + " is found at index: " + index);
        else
            System.out.println(num + " is NOT found!");
    }
}