package com.company.util;

import com.company.settings.AppSettings;
import com.company.types.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

    /*
    * reads input from file
    * */
    public static String readFile() throws IOException {
        Scanner scanner = new Scanner(new File(AppSettings.INPUT_FILE_NAME));
        String input = scanner.useDelimiter("\\A").next();
        scanner.close();
        return input;
    }

    /*
    * parse and converts string input to generic Pair list
    * */
    public static List<Pair> stringToPairList(String input) {
        List<Pair> pairList = new ArrayList<>();
        String[] pairs = input.split("\\),");

        for (String s: pairs) {
            String t = s.replaceAll("\\p{P}", "");
            t = t.trim();
            String[] r = t.split(" ");

            Pair p = new Pair();
            p.setFirstElement(Integer.parseInt(r[0]));

            if (Character.isDigit(r[1].toCharArray()[0])) {
                p.setSecondElement(Integer.parseInt(r[1]));
            } else {
                p.setSecondElement(String.valueOf(r[1]));
            }

            pairList.add(p);
        }

        return pairList;
    }

    /*
    * outputs to binary file
    * */
    public static void printOutput(byte[] output) throws IOException {
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(AppSettings.OUTPUT_FILE_NAME));
        outputStream.write(output);
        outputStream.close();
    }
}
