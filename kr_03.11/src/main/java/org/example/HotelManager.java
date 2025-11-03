package org.example;

import java.io.*;
import java.util.*;

public class HotelManager {
    private List<Hotel> hotels;

    public HotelManager() {
        hotels = new ArrayList<>();
    }

    public void readFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String city = line.trim();
                String name = br.readLine().trim();
                int stars = Integer.parseInt(br.readLine().trim());

                hotels.add(new Hotel(city, name, stars));
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    public void displaySortedHotels() {
        Comparator<Hotel> comparator = Comparator
                .comparing(Hotel::getCity)
                .thenComparing(Comparator.comparing(Hotel::getStars).reversed());

        List<Hotel> sortedHotels = new ArrayList<>(hotels);
        sortedHotels.sort(comparator);

        System.out.println("Отели, отсортированные по городу и звездности:");
        System.out.println("==============================================");
        for (Hotel hotel : sortedHotels) {
            System.out.println(hotel);
        }
        System.out.println();
    }

    public void findHotelsByCity(String cityName) {
        System.out.println("Отели в городе '" + cityName + "':");
        System.out.println("==========================");

        boolean found = false;
        for (Hotel hotel : hotels) {
            if (hotel.getCity().equalsIgnoreCase(cityName)) {
                System.out.println(hotel);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Отели в городе '" + cityName + "' не найдены.");
        }
        System.out.println();
    }

    public void findCitiesByHotelName(String hotelName) {
        System.out.println("Города с отелем '" + hotelName + "':");
        System.out.println("==========================");

        Set<String> cities = new TreeSet<>();
        for (Hotel hotel : hotels) {
            if (hotel.getName().equalsIgnoreCase(hotelName)) {
                cities.add(hotel.getCity());
            }
        }

        if (cities.isEmpty()) {
            System.out.println("Отель с названием '" + hotelName + "' не найден.");
        } else {
            for (String city : cities) {
                System.out.println(city);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HotelManager manager = new HotelManager();

        manager.readFromFile("/Users/danila/IdeaProjects/kr_03.11/hotel.txt");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1 - Показать все отели (сортировка по городу и звездности)");
            System.out.println("2 - Найти отели по городу");
            System.out.println("3 - Найти города по названию отеля");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manager.displaySortedHotels();
                    break;
                case 2:
                    System.out.print("Введите название города: ");
                    String city = scanner.nextLine();
                    manager.findHotelsByCity(city);
                    break;
                case 3:
                    System.out.print("Введите название отеля: ");
                    String hotelName = scanner.nextLine();
                    manager.findCitiesByHotelName(hotelName);
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.\n");
            }
        }
    }
}