package ecobikerental.capstone_project.subsystem.interbank;

import ecobikerental.capstone_project.exception.UnrecognizedException;
import ecobikerental.capstone_project.utils.API;

public class InterbankBoundary {
    String query(String url, String data) throws UnrecognizedException {
        String response = null;
        try {
            response = API.post(url, data);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new UnrecognizedException();
        }
        return response;
    }

}
