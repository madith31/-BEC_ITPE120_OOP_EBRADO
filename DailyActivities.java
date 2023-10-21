   
    public class DailyActivities{
        public String getDailyActivity(Day day) {
            switch (day) {
                case Sunday:
                    return "Attend religious activities in church";
                case Monday:
                    return "Start the workweek. Participate PSA Quizbee and Workshop";
                case Tuesday:
                    return "Prepare data table for CLUP revision";
                case Wednesday:
                    return "Attend the Bids and Awards Committee Meeting";
                case Thursday:
                    return "Conduct Data Gathering";
                case Friday:
                    return "Prepare and Submit reports to Commission on Audit";
                case Saturday:
                    return "Family Day and Enjoy the weekend!";
                
                default:
                    return "Invalid day";
            }
        }
    }


