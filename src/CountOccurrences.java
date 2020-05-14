// COUNTING OCCURRENCES OF A NUMBER IN AN ARRAY

import java.util.Arrays;
import java.util.Scanner;

public class CountOccurrences
{
    static int SearchIndices(int[] Arr, int num, boolean searchFirst)
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

                if(searchFirst)
                    high = (mid - 1);
                else
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
        System.out.println("COUNTING OCCURRENCES OF A NUMBER IN AN ARRAY...\n");

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

        System.out.print("Enter the element whose occurrences you wanna count: ");
        int num = sc.nextInt();

        int firstIndex = SearchIndices(Arr, num, true);
        if(firstIndex == -1)
            System.out.println("Count of " + num + " is 0.");
        else
        {
            int lastIndex = SearchIndices(Arr, num, false);
            System.out.println("Count of " + num + " is: " + (lastIndex - firstIndex + 1) + ".");
        }
    }
}