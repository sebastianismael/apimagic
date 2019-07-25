package edu.tallerjava.aceptacion;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class TestDeAceptacion {

    protected String urlBase = "http://localhost:8080/sitio";

    protected HttpURLConnection invocarAPI(String path, String httpMethod, String body) throws Exception {
        URL url = new URL(urlBase + path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(httpMethod);
        if(body != null){
            connection.setRequestProperty("Content-Type","application/json");
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(body);
            wr.flush();
            wr.close();
        }
        connection.connect();
        return connection;
    }

    protected HttpURLConnection invocarAPI(String path, String httpMethod) throws Exception {
        return invocarAPI(path, httpMethod, null);
    }

}
