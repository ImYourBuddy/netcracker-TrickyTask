package ru.netcracker.edu.karpov.date;

/**
 * Class describing a matrix as an entity
 */

public class DateEntity {
    private int day;
    private int month;
    private int year;

    public DateEntity() {

    }

    public DateEntity(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDate(int year, int month, int day) {
        this.setDay(day);
        this.setMonth(month);
        this.setYear(year);
    }

    public DateEntity getDate() {
        return this;
    }

    @Override
    public String toString() {
        return this.getDay() + "." + this.getMonth() + "." + this.getYear();
    }

    /**
     * Date equality check
     *
     * @param date
     * @return true if dates are equal
     */
    public boolean equals(DateEntity date) {
        boolean equal = false;
        if (this.getDay() == date.getDay() && this.getMonth() == date.getMonth() && this.getYear() == date.getYear()) {
            equal = true;
        }
        return equal;
    }

    /**
     * Copies the date <code>date</code>
     *
     * @param date copied date
     * @return copy of the date <code>date</code>
     */
    public DateEntity copy(DateEntity date) {
        this.year = date.getYear();
        this.month = date.getMonth();
        this.day = date.getDay();
        return this;
    }
}
