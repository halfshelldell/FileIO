package com.theironyard;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        HashMap readMap = ReadJson();
        if (readMap == null) {
            askQuestion();
        }
        else {
            System.out.println(readMap);
            System.out.println("Did you want to update your choice [y/n]");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                askQuestion();
            }
            else {
                System.out.println("Thank you for playing.");
            }
        }

    }

    public static HashMap ReadJson() throws FileNotFoundException {
        File file = new File("album.json");
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("\\Z");
        String contents = scanner.next();
        JsonParser parser = new JsonParser();
        try {
            HashMap albumParse = parser.parse(contents);
            return albumParse;
        }
        catch (Exception e) {
            System.out.println("Invalid Json");
        }

        return null;

    }

    public static void WriteJson(HashMap album) throws IOException {
        File file = new File("album.json");
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(album);
        FileWriter fw = new FileWriter(file);
        fw.write(json);
        fw.close();
        System.out.println(json);
    }


    public static void askQuestion() {

        HashMap map = new HashMap();

        System.out.println("Enter an album of your choice");
        String album = scanner.nextLine();
        map.put("album", album);
        System.out.println("Enter the artist of the album");
        String artist = scanner.nextLine();
        map.put("artist", artist);
        System.out.println("Favorite song on the album?");
        String song = scanner.nextLine();
        map.put("song", song);
        System.out.println("What genre of music is it?");
        String genre = scanner.nextLine();
        map.put("genre", genre);
        System.out.println("What year did this album release?");
        String year = scanner.nextLine();
        map.put("year", year);

        try {
            WriteJson(map);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


}
