package com.jetblue.task.fetch.route.utils;

import com.jetblue.task.fetch.route.model.Route;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RouteCSVReader {

    private static final String CSV_PATH = System.getProperty("user.dir") + File.separator + "src"
            + File.separator + "main" + File.separator + "resources" + File.separator + "csvDataFiles" + File.separator
            + "Routes.csv";

    public static List<Route> getCSVRouteData() {

        List<Route> listOfAllRoutes = new ArrayList<Route>();

        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_PATH));
            CSVParser csvParser = new CSVParser(reader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
            for (CSVRecord csvRecord : csvParser) {
                Route route = new Route();
                route.setCity1(csvRecord.get("city1"));
                route.setCity2(csvRecord.get("city2"));
                route.setCity3(csvRecord.get("city3"));
                route.setMint(csvRecord.get("mint"));
                route.setSeasonal(csvRecord.get("seasonal"));
                listOfAllRoutes.add(route);
            }
            System.out.println("Number of ROUTES in the CSV : "+ listOfAllRoutes.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfAllRoutes;
    }
    public static void main(String[] args) {
        System.out.println(getCSVRouteData());
    }

}
