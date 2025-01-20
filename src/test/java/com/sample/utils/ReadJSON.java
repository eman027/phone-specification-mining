package com.sample.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadJSON {

    public static String parse(String fileName) {
        try {
            String path = System.getProperty("user.dir") + "\\src\\test\\resources\\";
            return readFileAsString(path + fileName);
        } catch (Exception e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    static String readFileAsString(String filePath) throws IOException {
        StringBuilder fileData = new StringBuilder(1000);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0,numRead);
            fileData.append(readData);
            buf = new char[1024];
        }
        reader.close();
        return fileData.toString();
    }

    public static String getString(JSONObject obj, String key) {
        String output = "";
        try {
            output = obj.getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return output;
    }
}
