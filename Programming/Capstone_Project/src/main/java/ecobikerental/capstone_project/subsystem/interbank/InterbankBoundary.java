package ecobikerental.capstone_project.subsystem.interbank;

import java.io.IOException;
import java.net.MalformedURLException;

import ecobikerental.capstone_project.exception.UnrecognizedException;
import ecobikerental.capstone_project.utils.API;

public class InterbankBoundary {
    String query(String url, String data){
        String response = null;
//        try {
//            response = API.post(url, data);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            System.out.println("UUUUUUUUUUU");
//            e.getStackTrace();
//            e.getMessage();
//            throw new UnrecognizedException();
//        }
        try {
            response = API.post(url, data);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
