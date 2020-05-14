// BINARY SEARCH IMPLEMENTATION - RECURSIVE

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchRecursive
{
    static int BinarySearchRecursive(int[] Arr, int low, int high, int num)
    {
        if(low > high)
            return -1;

        int mid = low + (high - low)/2;         // Or, mid = (low + high)/2;

        if(num == Arr[mid])
            return mid;
        if(num < Arr[mid])
            return BinarySearchRecursive(Arr, low, mid - 1, num);
        else
            return BinarySearchRecursive(Arr, mid + 1, high, num);
    }

    public static void main(String[] args)
    {
        System.out.println("BINARY SEARCH - RECURSIVE IMPLEMENTATION...\n");

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

        int index = BinarySearchRecursive(Arr, 0, (Arr.length - 1), num);
        if(index!=-1)
            System.out.println(num + " is found at index: " + index);
        else
            System.out.println(num + " is NOT found!");
    }
}
