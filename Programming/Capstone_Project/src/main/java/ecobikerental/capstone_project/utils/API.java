package ecobikerental.capstone_project.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

public class API {

    public static DateFormat DATE_FORMATER = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static Logger LOGGER = Utils.getLogger(Utils.class.getName());

    public static String get(String url, String token) throws Exception {
        LOGGER.info("Request URL: " + url + "\n");

        HttpURLConnection conn = setupConnection(url);

        conn.setRequestMethod("GET");

        conn.setRequestProperty("Authorization", "Bearer " + token);
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder respone = new StringBuilder(); // ising StringBuilder for the sake of memory and performance
        while((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        respone.append(inputLine + "\n");
        in.close();
        LOGGER.info("Respone Info: " + respone.substring(0, respone.length() - 1).toString());
        return respone.substring(0, respone.length() - 1).toString();
    }

    private static HttpURLConnection setupConnection(String url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");
        return conn;
    }

    public static String post(String url, String data
                              //			, String token
    ) throws IOException {
        allowMethods("PATCH");
        String payload = data;
        LOGGER.info("Request Info:\nRequest URL: " + url + "\n" + "Payload Data: " + payload + "\n");

        HttpURLConnection conn = setupConnection(url);

        conn.setRequestMethod("PATCH");

        //		conn.setRequestProperty("Authorization", "Bearer " + token);
        Writer writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
        writer.write(payload);
        writer.close();
        BufferedReader in;
        String inputLine;
        if(conn.getResponseCode() / 100 == 2) {
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder response = new StringBuilder();
        while((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        LOGGER.info("Respone Info: " + response.toString());
        return response.toString();
    }

    private static void allowMethods(String... methods) {
        try {
            Field methodsField = HttpURLConnection.class.getDeclaredField("methods");
            methodsField.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(methodsField, methodsField.getModifiers()&~ Modifier.FINAL);

            String[] oldMethods = (String[]) methodsField.get(null);
            Set<String> methodsSet = new LinkedHashSet<>(Arrays.asList(oldMethods));
            methodsSet.addAll(Arrays.asList(methods));
            String[] newMethods = methodsSet.toArray(new String[0]);

            methodsField.set(null/* static field */, newMethods);
        } catch(NoSuchFieldException|IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

//    public static String post(String url, String data) throws MalformedURLException {
////        String url="http://url.com";
//        allowMethods("PATCH");
//        URL object = new URL(url);
//
//        HttpURLConnection con = null;
//        try {
//            con = (HttpURLConnection) object.openConnection();
//            con.setDoOutput(true);
//            con.setDoInput(true);
//            con.setRequestProperty("Content-Type", "application/json");
//            con.setRequestProperty("Accept", "application/json");
////            con.setRequestMethod("POST");
////            con.setRequestProperty("X-HTTP-Method-Override", "PATCH");
//            con.setRequestMethod("POST");
//
//        } catch (IOException e) {
//            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//            e.printStackTrace();
//        }
//
//        OutputStreamWriter wr = null;
//        try {
//            wr = new OutputStreamWriter(con.getOutputStream());
//            wr.write(data);
//            wr.flush();
//        } catch (IOException e) {
//            System.out.println("BBBBBBBBB");
//            e.printStackTrace();
//        }
//
//        StringBuilder response = new StringBuilder();
//        int HttpResult = 0;
//        try {
//            HttpResult = con.getResponseCode();
//        } catch (IOException e) {
//            System.out.println("coddddddddddddddddddddd");
//            e.printStackTrace();
//        }
//        if (HttpResult == HttpURLConnection.HTTP_OK) {
//            BufferedReader br = null;
//            try {
//                br = new BufferedReader(
//                    new InputStreamReader(con.getInputStream(), "utf-8"));
//            } catch (IOException e) {
//                System.out.println("CCCCCCCCCCCAA");
//                e.printStackTrace();
//            }
//            String line = null;
//            while (true) {
//                try {
//                    if (!((line = br.readLine()) != null)) break;
//                } catch (IOException e) {
//                    System.out.println("UUUUUUUUUUUAAAA");
//                    e.printStackTrace();
//                }
//                response.append(line + "\n");
//            }
//            try {
//                br.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            //            System.out.println("" + response.toString());
//            return response.toString();
//        } else {
//            try {
//                System.out.println(con.getResponseMessage());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//    }
}
