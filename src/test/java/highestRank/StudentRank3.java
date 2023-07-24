package highestRank;

import java.util.TreeMap;

public class StudentRank3 {
    static String[] students;
    static int[] ranks;

    public StudentRank3(String[] students, int[] ranks) {
        this.ranks = ranks;
        this.students = students;
    }

    public String highestRank() {
        String highestRank = students[0];
        for (int i = 1; i < ranks.length; i++) {
            if (ranks[i] > ranks[0]) {
                highestRank = students[i];
            }
        }
        return highestRank;

    }

    public String lowestRank() {
        String lowestRank = students[0];
        for (int i = 1; i < ranks.length; i++) {
            if (ranks[i] < ranks[0]) {
                lowestRank = students[i];
            }
        }
        return lowestRank;

    }

    public static void main(String[] args) {
        String[] students = {"Alex", "Chris", "Sam"};
        int[] ranks = {3, 2, 1};
        StudentRank studentRank = new StudentRank(students, ranks);
        System.out.println("highest" + studentRank.highestRank());
        System.out.println("lowest" + studentRank.lowestRank());
    }
}
