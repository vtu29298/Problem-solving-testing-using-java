class Solution {
    public String dayOfTheWeek(int day, int month, int year) {

        String[] week = {
            "Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday"
        };

        int[] days = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        int totalDays = 0;

        // Days from 1971 to the previous year
        for (int y = 1971; y < year; y++) {
            if (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }

        // Check leap year
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            days[1] = 29;
        }

        // Days from previous months
        for (int m = 0; m < month - 1; m++) {
            totalDays += days[m];
        }

        totalDays += day - 1;

        // Jan 1, 1971 was Friday
        return week[(5 + totalDays) % 7];
    }
}