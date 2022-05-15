package ru.project.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

class GetUserPassword {
    private static final String path = "src/main/resources/loginDB.txt";

     static HashMap<String, String> readLoginDB() {
        HashMap<String, String> login = new HashMap<>();
        String line;
        try {
            FileReader file = new FileReader(path);
            BufferedReader br = new BufferedReader(file);
            while ((line = br.readLine()) != null) {
                String[] pair = line.split(":");
                login.put(pair[0], pair[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return login;
    }
}
