package shiftAllZeroElementsToRight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShiftArray {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 0, 3, 4, 5, 7, 0};
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> zerOlist = new ArrayList<Integer>();
        for (int value : arr) {
            list.add(value);
        }
        int countZero = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                countZero++;
                zerOlist.add(0);
                list.remove(i);
            }
        }
        list.addAll(zerOlist);
        System.out.println(Arrays.toString(list.toArray()));

    }

}
