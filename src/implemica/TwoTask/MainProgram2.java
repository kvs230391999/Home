package implemica.TwoTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created 22.11.2024.
 * author Vladyslav Kulishov
 * <p/>
 * s [the number of tests <= 10]
 * n [the number of cities <= 10000]
 * NAME [city name]
 * p [the number of neighbours of city NAME]
 * nr cost [nr - index of a city connected to NAME (the index of the first city is 1)]
 * [cost - the transportation cost]
 * r [the number of paths to find <= 100]
 * NAME1 NAME2 [NAME1 - source, NAME2 - destination]
 * [empty line separating the tests]
 */
public class MainProgram2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Java\\Java Pro\\Home\\Home\\src\\implemica\\TwoTask\\data"));
        String line = br.readLine();
        int s = Integer.parseInt(line);
        for (int i = 0; i < s; i++) {// the number of tests

            String[] n = new String[10000];// create an array of the condition of the job
            line = br.readLine();
            int CountCities = Integer.parseInt(line);// read the number of cities
            int size = CountCities + 1; // The problem of indexing the array from 0
            City city = new City(size);
            for (int CityIndex = 0; CityIndex < CountCities; CityIndex++) {
                line = br.readLine();// reads the name of the city
                String name = line;
                n[CityIndex] = name;// write the name of the city
                line = br.readLine();// read the next value (the number of neighbors)
                int p = Integer.parseInt(line);
                for (int neighborIndex = 0; neighborIndex < p; neighborIndex++) {
                    line = br.readLine();
                    String[] brokenLine = line.split(" ");
                    int nr1 = Integer.parseInt(brokenLine[0]);// Write the code neighbor
                    int nr2 = Integer.parseInt(brokenLine[1]);// write the weight of the edge
                    city.setEdge(CityIndex, nr1, nr2);
                }
            }
            line = br.readLine();
            int routesToFind = Integer.parseInt(line);// number of calculated routes
            for (int routesIndex = 0; routesIndex < routesToFind; routesIndex++) {
                line = br.readLine();// reads the path
                String[] cityNames = line.split(" ");
                String start = cityNames[0];
                String destination = cityNames[1];
                List<String> list = new ArrayList<String>();
                for (String st : n) {// remove the null elements from the array before writing to the list
                    if (st != null) {
                        list.add(st);
                    }
                }
                n = list.toArray(new String[list.size()]);
                int startId = 0;
                int destId = 0;
                for (int j = 0; j < n.length; j++) {  // find the index of the initial city
                    if (start.equals(n[j])) {
                        startId = j;
                        break;
                    }
                }
                for (int k = 0; k < n.length; k++) {  // find the index of the end of the city
                    if (destination.equals(n[k])) {
                        destId = k;
                        break;
                    }
                }
                Integer[] distancesFromSource = city.distancesFrom(startId);
                int bDistance = distancesFromSource[destId];
                System.out.println(bDistance);
            }

        }
        br.close();
    }
}
