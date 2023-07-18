package edu.kit.informatik;

public class OutputFormat {


    public static int calculateLongestLine(String input) {

        String[] lines = input.split("\n");
        int longest = 0;
        for (String line : lines) {
            int length = line.length();

            if (length > longest) {
                longest = length;
            }
        }
        return longest;
    }


    public static String whiteSpaces(int longest, String input) {

        String[] lines = input.split("\n");
        StringBuilder finalOutput = new StringBuilder();

        for (int i = 0; i < lines.length; i++) {
            int insertIndex = lines[i].indexOf(":") + 1;

            if (lines[i].length() < longest) {
                String spaces = " ".repeat(longest - lines[i].length());
                StringBuilder sb = new StringBuilder(lines[i]).insert(insertIndex, spaces);

                finalOutput.append(sb).append("\n");
            } else {
                finalOutput.append(lines[i]).append("\n");
            }
        }
        return finalOutput.toString();
    }
}
