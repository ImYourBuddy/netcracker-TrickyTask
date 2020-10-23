package ru.netcracker.edu.karpov.date;

/**
 * @author Alexander Karpov
 */

public interface DateWorker {

    /**
     * Checking for a leap year
     *
     * @param year
     * @return true if year is leap
     * @throws IllegalArgumentException if year is negative
     */
    boolean isLeapYear(int year);

    /**
     * Date validation
     *
     * @param year
     * @param month
     * @param day
     * @return true if date is valid
     */
    boolean isValidDate(int year, int month, int day);

    /**
     * Counting the day of the week
     *
     * @param year
     * @param month
     * @param day
     * @return day of the week where 0 is monday, 6 is sunday
     * @throws IllegalArgumentException if date is incorrect
     */
    int getDayOfWeek(int year, int month, int day);

    /**
     * Formatting the date
     *
     * @param year
     * @param month
     * @param day
     * @return date as Tuesday 14 Feb 2012
     * @throws IllegalArgumentException if date is incorrect
     */
    String toString(int year, int month, int day);

    /**
     * Calculating the number of days that have passed from the entered date to the current date
     *
     * @param year
     * @param month
     * @param day
     * @return number of days since the entered date. If date is in the future then return number of days with minus
     * @throws IllegalArgumentException if date is incorrect
     */
    int countDays(int year, int month, int day);
}
