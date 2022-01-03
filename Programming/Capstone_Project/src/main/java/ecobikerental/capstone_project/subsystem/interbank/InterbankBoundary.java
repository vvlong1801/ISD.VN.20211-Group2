package ecobikerental.capstone_project.subsystem.interbank;

import java.io.IOException;

import ecobikerental.capstone_project.utils.API;

public class InterbankBoundary {
    public static String query(final String url, final String data) {
        String response = null;
        try {
            response = API.post(url, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //        try {
//            response = API.post(url, data);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            throw new UnrecognizedException();
//        }
        return response;
    }

}
