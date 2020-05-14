// BINARY SEARCH IMPLEMENTATION - ITERATIVE

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchIterative
{
    static int BinarySearchIterative(int[] Arr, int num)
    {
        int low = 0;
        int high = (Arr.length - 1);

        while(low <= high)
        {
            int mid = (low + high)/2;  // Or, mid = low + (high - low)/2

            if (num == Arr[mid])
                return mid;
            else if (num < Arr[mid])
                high = (mid - 1);
            else
                low = (mid + 1);
        }

        return -1;
    }

    public static void main(String[] args)
    {
        System.out.println("BINARY SEARCH - ITERATIVE IMPLEMENTATION...\n");

        Scanner sc = new Scanner(System.in);

        System.out.print("How many elements do you wanna enter? ");
        int n = sc.nextInt();

        int[] Arr = new int[n];

        System.out.println("Enter the elements: ");
        for(int i = 0; i < n; i++)
        {
            Arr[i] = sc.nextInt();
        }

        Arrays.sort(Arr);
        System.out.println("The sorted array: " + Arrays.toString(Arr));

        System.out.print("Enter the element that you wanna search for: ");
        int num = sc.nextInt();

        int index = BinarySearchIterative(Arr, num);
        if(index!=-1)
            System.out.println(num + " is found at index: " + index);
        else
            System.out.println(num + " is NOT found!");
    }
}