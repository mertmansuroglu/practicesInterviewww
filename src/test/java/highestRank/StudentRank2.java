package highestRank;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class StudentRank2 {
    static String[] students;
    static int[] ranks;

    public StudentRank2(String[] students, int[] ranks) {
        this.ranks = ranks;
        this.students = students;
    }

    public String highestRank() {
        TreeMap<Integer, String> map = new TreeMap();
        for (int i = 0; i < ranks.length; i++) {
            map.put(ranks[i], students[i]);
        }
        return map.get(ranks[0]);

    }

    public String lowestRank() {
        TreeMap<Integer, String> map = new TreeMap();
        for (int i = 0; i < ranks.length; i++) {
            map.put(ranks[i], students[i]);
        }
        return map.get(ranks[ranks.length-1]);

    }

//    public static void main(String[] args) {
//        String[] students = {"Alex", "Chris", "Sam"};
//        int[] ranks = {3, 2, 1};
//        StudentRank studentRank = new StudentRank(students, ranks);
//        System.out.println("highest"+studentRank.highestRank());
//        System.out.println("lowest"+studentRank.lowestRank());
//    }
}
