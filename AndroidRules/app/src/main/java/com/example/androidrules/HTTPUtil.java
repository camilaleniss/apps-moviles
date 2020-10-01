package com.example.androidrules;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HTTPUtil extends Thread{

    private String url;

    public void setObserver(OnReponseLister observer) {
        this.observer = observer;
    }

    private OnReponseLister observer;

    public HTTPUtil(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        getRequest(url);
    }

    private void getRequest(String url){
        try {
            //Request
            URL site = new URL(url);
            HttpsURLConnection connection= (HttpsURLConnection) site.openConnection();

            //Read
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String mensaje = "";
            String line="";
            while((line= reader.readLine()) !=null){
                mensaje += line;
            }

            Log.e(">>>>", mensaje);

            observer.onResponse(mensaje);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public interface OnReponseLister{
        void onResponse(String response);
    }
}
