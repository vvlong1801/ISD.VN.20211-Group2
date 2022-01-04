package ecobikerental.capstone_project.business_layer;

/**
 * This class processes businesses related to Invoice
 */
public class InvoiceBL {
    /**
     * This method calculates the rental fee
     * @param timeRental - the time that user rented bike
     * @return rentalFee - the rental fee
     */
    public static int calculateRentalFee(String timeRental) {
        int rentalFee = 0;
        int minutes = processTime(timeRental);
        if (minutes <= 10) {
            rentalFee = 0;
        } else if (minutes < 30) {
            rentalFee = 10000;
        } else if (minutes % 15 == 0) {
            rentalFee = 10000 + (minutes - 30) / 15 * 3000;
        } else {
            rentalFee = 10000 + ((minutes - 30) / 15 + 1) * 3000;
        }
        return rentalFee;
    }

    /**
     * This method convert the rental time into minute(s)
     * @param timeRental - the time that user rented bike
     * @return minutes - the rental minute(s)
     */
    private static int processTime(String timeRental) {
        String[] timeArr = timeRental.split(":");
        int minutes = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
        if (Integer.parseInt(timeArr[2]) > 0) {
            minutes++;
        }
        return minutes;
    }

//    public static void main(String[] args) {
//        String time = "00:10:00";
//        String[] timeArr = time.split(":");
//        int minutes = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
//        if (Integer.parseInt(timeArr[2]) > 0) {
//            minutes++;
//        }
//        System.out.println(minutes);
//        System.out.println(calculateRentalFee(time));
//    }
}
