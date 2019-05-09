package com.company;

import com.company.settings.AppSettings;
import com.company.types.Pair;
import com.company.util.Utils;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            String input = Utils.readFile();
            StringBuffer output = new StringBuffer();

            List<Pair> inputPairs = Utils.stringToPairList(input);

            for (Pair inputPair: inputPairs) {
                if ((Integer)inputPair.getFirstElement() == 0) {
                    String toConcat = inputPair.getSecondElement().toString();
                    output.append(toConcat);
                } else {
                    int startIndex = output.length() - (Integer) inputPair.getFirstElement();
                    int endIndex = startIndex + (Integer) inputPair.getSecondElement();

                    try {
                        String subStringToAppend = output.substring(startIndex, endIndex);
                        output.append(subStringToAppend);
                    } catch (StringIndexOutOfBoundsException e) {
                        output.append(AppSettings.ERROR_DELIMITER);
                    }
                }
            }

            System.out.println(output);
            Utils.printOutput(output.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
