// FINDING THE NUMBER OF TIMES A SORTED ARRAY (WITHOUT DUPLICATES) IS ROTATED

public class CountRotations
{
    static int FindRotationCount(int[] Arr)
    {
        int low = 0;
        int high = Arr.length - 1;

        while(low <= high)
        {
            if(Arr[low] <= Arr[high])     // Case-1: The segment is sorted. Found the index of the minimum element!
                return low;

            int mid = (low + high)/2;

            int next = (mid + 1)%Arr.length;
            int prev = (mid - 1 + Arr.length)%Arr.length;

            if((Arr[mid] <= Arr[next]) && (Arr[mid] <= Arr[prev]))     // Case-2: Found the pivot element! That is the minimum element.
                return mid;

            if(Arr[mid] <= Arr[high])     // Case-3: The right half is sorted. Searching in the left half.
                high = (mid - 1);
            else if(Arr[mid] >= Arr[low])      // Case-4: The left half is sorted. Searching in the right half.
                low = (mid + 1);
        }

        return -1;
    }

    public static void main(String[] args)
    {
        System.out.println("FINDING THE NUMBER OF TIMES A SORTED ARRAY IS ROTATED...\n");

        int[] Arr1 = {7, 8, 9, 10, 1, 2, 3, 4, 5, 6};
        int[] Arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] Arr3 = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
        int[] Arr4 = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] Arr5 = {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};

        int count1 = FindRotationCount(Arr1);
        int count2 = FindRotationCount(Arr2);
        int count3 = FindRotationCount(Arr3);
        int count4 = FindRotationCount(Arr4);
        int count5 = FindRotationCount(Arr5);

        System.out.println("The array has been rotated " + count1 + " time(s).");
        System.out.println("The array has been rotated " + count2 + " time(s).");
        System.out.println("The array has been rotated " + count3 + " time(s).");
        System.out.println("The array has been rotated " + count4 + " time(s).");
        System.out.println("The array has been rotated " + count5 + " time(s).");
    }
}