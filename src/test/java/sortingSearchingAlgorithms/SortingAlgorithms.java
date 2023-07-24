package sortingSearchingAlgorithms;

import org.testng.Assert;

import java.util.Arrays;

public class SortingAlgorithms {
    ////Burdaki olay adeta bir baloncuk gibi kayarak en bastan ve en sondan tum elema
    ////we are going loop through array for each round
    ////then we will write another loop for comparing!!

//—eger sorted true koyarsak ve array sirali arrayse Best case imiz N olur wors case ise n^2 olur cunku N olmasi demek tum hepsine tek seferda bakip gecer o kadar!!!
    public  int[] bubleSort(int[] arr)
    {
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            boolean sorted=true;
            for(int a=n-1;a>i;a--) {
                if (arr[a - 1] > arr[a]) {
                    sorted = false;
                    int temp = arr[a - 1];
                    arr[a - 1] = arr[a];
                    arr[a] = temp;
                }
            }
                if(sorted)
                {
                    break;
                }
            }
        return arr;
        }
    public  int linearSearch(int[] arr,int searchEl)
    {
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==searchEl)
            {
                return i;
            }
        }
        return  -1;
    }
        public int[] selectionSort(int[] arr)
        {
            int n=arr.length;
            for(int i=0;i<n;i++)
            {
                boolean sorted=true;
                int min=i;
                for(int j=i+1;j<arr.length;j++)
                    if(arr[j]<arr[min])
                    {
                        sorted=false;
                        int temp=arr[min];
                        arr[min]=arr[i+1];
                        arr[i+1]=temp;
                    }
                if (sorted)
                {
                    break;
                }
            }
       return arr;
        }
    public static void main(String[] args) {
        int[] arr={3,2,6,2,1,8};
        System.out.println(Arrays.toString(new SortingAlgorithms().bubleSort(arr)));
        System.out.println(Arrays.toString(new SortingAlgorithms().selectionSort(arr)));
        System.out.println(new SortingAlgorithms().linearSearch(arr,1));
//        Assert.assertTrue(==4);


    }
}