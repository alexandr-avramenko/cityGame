package org.example.fileReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {

    private final String path;

    public MyFileReader(String path) {
        this.path = path;
    }

    public List<String> readCitiesFromFile() {
        List<String> cities = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                cities.add(line.trim().toLowerCase()); // Додаємо місто у нижньому регістрі
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }
}
