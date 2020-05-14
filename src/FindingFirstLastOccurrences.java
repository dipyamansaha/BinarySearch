// FINDING THE FIRST AND LAST OCCURRENCES OF A NUMBER IN AN ARRAY

import java.util.Arrays;
import java.util.Scanner;

public class FindingFirstLastOccurrences
{
    static int FirstOccurrence(int[] Arr, int num)
    {
        int low = 0;
        int high = (Arr.length - 1);
        int result = -1;

        while(low <= high)
        {
            int mid = (low + high)/2;       // Or, mid = low + (high - low)/2

            if (num == Arr[mid])
            {
                result = mid;
                high = (mid - 1);
            }
            else if (num < Arr[mid])
                high = (mid - 1);
            else
                low = (mid + 1);
        }

        return result;
    }

    static int LastOccurrence(int[] Arr, int num)
    {
        int low = 0;
        int high = (Arr.length - 1);
        int result = -1;

        while(low <= high)
        {
            int mid = (low + high)/2;       // Or, mid = low + (high - low)/2

            if (num == Arr[mid])
            {
                result = mid;
                low = (mid + 1);
            }
            else if (num < Arr[mid])
                high = (mid - 1);
            else
                low = (mid + 1);
        }

        return result;
    }

    public static void main(String[] args)
    {
        System.out.println("FINDING THE FIRST AND LAST OCCURRENCES OF A NUMBER...\n");

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

        System.out.print("Enter the element whose first occurrence you wanna search for: ");
        int num1 = sc.nextInt();

        int index1 = FirstOccurrence(Arr, num1);
        if(index1!=-1)
            System.out.println(num1 + " is found at index: " + index1);
        else
            System.out.println(num1 + " is NOT found!");

        System.out.print("Enter the element whose last occurrence you wanna search for: ");
        int num2 = sc.nextInt();

        int index2 = LastOccurrence(Arr, num2);
        if(index2!=-1)
            System.out.println(num2 + " is found at index: " + index2);
        else
            System.out.println(num2 + " is NOT found!");
    }
}
