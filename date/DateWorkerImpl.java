package ru.netcracker.edu.karpov.date;


public class DateWorkerImpl implements DateWorker {
    @Override
    public boolean isLeapYear(int year) throws IllegalArgumentException {
        if (year < 0) {
            throw new IllegalArgumentException("Year is negative");
        }
        boolean isLeap;
        if (year % 4 == 0 && year % 100 != 0) {
            isLeap = true;
        } else if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
            isLeap = true;
        } else {
            isLeap = false;
        }
        return isLeap;
    }

    @Override
    public boolean isValidDate(int year, int month, int day) {
        boolean isValidDate = false;
        if (year >= 0) {
            if (isLeapYear(year)) {
                if (month > 0 && month <= 12) {
                    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                        if (day > 0 && day <= 31) {
                            isValidDate = true;
                        }
                    } else if (month == 2) {
                        if (day > 0 && day <= 29) {
                            isValidDate = true;
                        }
                    } else {
                        if (day > 0 && day <= 30) {
                            isValidDate = true;
                        }
                    }
                }
            } else {
                if (month > 0 && month <= 12) {
                    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                        if (day > 0 && day <= 31) {
                            isValidDate = true;
                        }
                    } else if (month == 2) {
                        if (day > 0 && day <= 28) {
                            isValidDate = true;
                        }
                    } else {
                        if (day > 0 && day <= 30) {
                            isValidDate = true;
                        }
                    }
                }
            }
        }
        return isValidDate;
    }

    @Override
    public int getDayOfWeek(int year, int month, int day) throws IllegalArgumentException {
        int dayOfWeek = 0;
        if (isValidDate(year, month, day)) {
            if (isLeapYear(year) && (month == 1 || month == 2)) {
                dayOfWeek = (codeOfCentury(year) + codeOfMonth(month) + (day % 7) + (year % 100 + (year % 100) / 4 % 7) - 1) % 7;
            } else {
                dayOfWeek = (codeOfCentury(year) + codeOfMonth(month) + (day % 7) + (year % 100 + (year % 100) / 4) % 7) % 7;
            }
            return dayOfWeek;
        } else {
            throw new IllegalArgumentException("Incorrect values of the date");
        }
    }

    @Override
    public String toString(int year, int month, int day) throws IllegalArgumentException {
        String date = "";
        int dayOfWeek = getDayOfWeek(year, month, day);
        if (isValidDate(year, month, day)) {
            date = nameOfDay(dayOfWeek) + " " + day + " " + nameOfMonth(month) + " " + year;
        } else {
            throw new IllegalArgumentException("Incorrect values of the date");
        }
        return date;
    }

    @Override
    public int countDays(int year, int month, int day) {
        if (isValidDate(year, month, day)) {
            int numberOfDays = 0;
            int currentTime = (int) (System.currentTimeMillis() / 86400000) + 1;
            if (year > 1970) {
                for (int i = 1970; i < year; i++) {
                    if (isLeapYear(i)) {
                        numberOfDays += 366;
                    } else {
                        numberOfDays += 365;
                    }
                }
                if (isLeapYear(year)) {
                    for (int i = 1; i < month; i++) {
                        if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                            numberOfDays += 31;
                        } else if (i == 2) {
                            numberOfDays += 29;
                        } else {
                            numberOfDays += 30;
                        }
                    }
                } else {
                    for (int i = 1; i < month; i++) {
                        if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                            numberOfDays += 31;
                        } else if (i == 2) {
                            numberOfDays += 28;
                        } else {
                            numberOfDays += 30;
                        }
                    }
                }
                numberOfDays += day;
                return currentTime - numberOfDays;
            }
            else {
                for (int i = year; i < 1970; i++) {
                    if (isLeapYear(i)) {
                        numberOfDays += 366;
                    } else {
                        numberOfDays += 365;
                    }
                }
                if (isLeapYear(year)) {
                    for (int i = 1; i < month; i++) {
                        if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                            numberOfDays -= 31;
                        } else if (i == 2) {
                            numberOfDays -= 29;
                        } else {
                            numberOfDays -= 30;
                        }
                    }
                } else {
                    for (int i = 1; i < month; i++) {
                        if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                            numberOfDays -= 31;
                        } else if (i == 2) {
                            numberOfDays -= 28;
                        } else {
                            numberOfDays -= 30;
                        }
                    }
                }
                numberOfDays -= day;
                return numberOfDays + currentTime;
            }
        } else {
            throw new IllegalArgumentException("Incorrect values of the date");
        }
    }

    /**
     * Month offset to calculate the day of the week {@link #getDayOfWeek(int, int, int)}
     *
     * @param month
     * @return Month offset
     */
    private int codeOfMonth(int month) {
        if (month > 0 && month <= 12) {
            if (month == 4 || month == 7) {
                return 5;
            } else if (month == 1 || month == 10) {
                return 6;
            } else if (month == 5) {
                return 0;
            } else if (month == 8) {
                return 1;
            } else if (month == 2 || month == 3 || month == 11) {
                return 2;
            } else if (month == 6) {
                return 3;
            } else {
                return 4;
            }
        } else {
            return -1;
        }
    }

    /**
     * Century offset to calculate the day of the week {@link #getDayOfWeek(int, int, int)}
     *
     * @param year
     * @return Century offset
     */
    private int codeOfCentury(int year) {
        if (year > 0) {
            int century = year - year % 100;
            if (century % 400 == 300) {
                return 0;
            }
            if (century % 400 == 0) {
                return 6;
            }
            if (century % 400 == 100) {
                return 4;
            }
            if (century % 400 == 200) {
                return 2;
            }
        }
        return -1;
    }

    /**
     * Day name for {@link #toString(int, int, int)}
     *
     * @param day
     * @return name of the day
     */
    private String nameOfDay(int day) {
        if (day == 0) {
            return "Monday";
        } else if (day == 1) {
            return "Tuesday";
        } else if (day == 2) {
            return "Wednesday";
        } else if (day == 3) {
            return "Thursday";
        } else if (day == 4) {
            return "Friday";
        } else if (day == 5) {
            return "Saturday";
        } else {
            return "Sunday";
        }
    }

    /**
     * Month name for {@link #toString(int, int, int)}
     *
     * @param month
     * @return name of the month
     */
    private String nameOfMonth(int month) {
        if (month == 1) {
            return "Jan";
        } else if (month == 2) {
            return "Feb";
        } else if (month == 3) {
            return "Mar";
        } else if (month == 4) {
            return "Apr";
        } else if (month == 5) {
            return "May";
        } else if (month == 6) {
            return "Jun";
        } else if (month == 7) {
            return "Jul";
        } else if (month == 8) {
            return "Aug";
        } else if (month == 9) {
            return "Sep";
        } else if (month == 10) {
            return "Oct";
        } else if (month == 11) {
            return "Nov";
        } else {
            return "Dec";
        }
    }
}
