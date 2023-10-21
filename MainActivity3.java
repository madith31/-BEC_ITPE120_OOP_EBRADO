class MainActivity3 {
    public static void main(String[] args) {
        DailyActivities planner = new DailyActivities();
        Day currentDay = Day.Sunday;
        Day firstDayOfWork = Day.Monday;
        Day secondDayOfWork = Day.Tuesday;
        Day thirdDayOfWork = Day.Wednesday;
        Day fourthDayOfWork = Day.Thursday;
        Day fifthDayOfWork = Day.Friday;
        Day weekend = Day.Saturday;

        String activity1 = planner.getDailyActivity(currentDay);
        String activity2 = planner.getDailyActivity(firstDayOfWork);
        String activity3 = planner.getDailyActivity(secondDayOfWork);
        String activity4 = planner.getDailyActivity(thirdDayOfWork);
        String activity5 = planner.getDailyActivity(fourthDayOfWork);
        String activity6 = planner.getDailyActivity(fifthDayOfWork);
        String activity7 = planner.getDailyActivity(weekend);

        System.out.println("On " + currentDay + ", you should: " + activity1);
        System.out.println("On " + firstDayOfWork + ", you should: " + activity2);
        System.out.println("On " + secondDayOfWork + ", you should: " + activity3);
        System.out.println("On " + thirdDayOfWork + ", you should: " + activity4);
        System.out.println("On " + fourthDayOfWork + ", you should: " + activity5);
        System.out.println("On " + fifthDayOfWork + ", you should: " + activity6);
        System.out.println("On " + weekend + ", you should: " + activity7);
    }
}
