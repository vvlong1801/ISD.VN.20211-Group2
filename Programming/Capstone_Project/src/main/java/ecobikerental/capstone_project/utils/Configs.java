package ecobikerental.capstone_project.utils;

public class Configs {


    // api constants
    public static final String GET_BALANCE_URL =
        "https://ecopark-system-api.herokuapp.com/api/card/balance/vn_group2_2021";
    public static final String GET_VEHICLECODE_URL =
        "https://ecopark-system-api.herokuapp.com/api/get-vehicle-code/1rjdfasdfas";
    public static final String PROCESS_TRANSACTION_URL =
        "https://ecopark-system-api.herokuapp.com/api/card/processTransaction";
    public static final String RESET_URL = "https://ecopark-system-api.herokuapp.com/api/card/reset";

    public static final String VERSION = "1.0.1";
    public static final String APPCODE = "DR/hgxXfn+c=";
    public static final String SECRETKEY = "BLRqOL6OIrI=";

    public static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiIxMTg2MDlfZ3JvdXAxXzIwMjAiLCJpYXQiOjE1OTkxMTk5NDl9.y81pBkM0pVn31YDPFwMGXXkQRKW5RaPIJ5WW5r9OW-Y";
    //database configs
    //    public static final String DB_NAME = "";
    //    public static final String DB_USERNAME = System.getenv("DB_USERNAME");
    //    public static final String DB_PASSWORD = System.getenv("DB_PASSWORD");

    public static final String SPLASH_SCREEN_PATH = "/ecobikerental/capstone_project/views/splash.fxml";
    public static final String HOME_SCREEN_PATH = "/ecobikerental/capstone_project/views/home.fxml";
    public static final String DOCK_INFO_SCREEN_PATH = "/ecobikerental/capstone_project/views/dock_info.fxml";
    public static final String BIKE_INFO_SCREEN_PATH = "/ecobikerental/capstone_project/views/bike_info.fxml";
    public static final String PAY_DEPOSIT_SCREEN_PATH = "/ecobikerental/capstone_project/views/pay_deposit.fxml";
    public static final String DEPOSIT_CONFIRM_SCREEN_PATH =
        "/ecobikerental/capstone_project/views/deposit_confirm.fxml";
    public static final String BIKE_STATUS_SCREEN_PATH = "/ecobikerental/capstone_project/views/bike_status.fxml";
    public static final String RETURN_BIKE_SCREEN_PATH = "/ecobikerental/capstone_project/views/return_bike.fxml";
    public static final String INVOICE_SCREEN_PATH = "/ecobikerental/capstone_project/views/invoice.fxml";

    public static final String LOGO_IMG_PATH = "assets/images/Splash.jpg";
    public static final String BIKE_RUNNING_IMG_PATH = "assets/images/bike_running.png";

}
