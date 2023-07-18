package edu.kit.informatik;

public class outputFormat {


    public int calculateLongestLine(StringBuilder stringBuilder) {

        String[] lines = stringBuilder.toString().split("\n");
        int longest = 0;
        for (String line : lines) {
            int length = line.length();

            if (length > longest) {
                longest = length;
            }
        }
        return longest;
    }


    public StringBuilder whiteSpaces(int longest, StringBuilder stringBuilder) {

        String[] lines = stringBuilder.toString().split("\n");
        StringBuilder sb = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();
        int i = 0;

        for (String line: lines) {
            int insertIndex = lines[i].indexOf(String.valueOf(':')) + 1;

            if (lines[i].length() < longest) {
                int whiteSpaces = longest - lines[i].length();

                for (int j = 0; j < whiteSpaces; j++) {
                    sb = new StringBuilder(lines[i]).insert(insertIndex, " ");
                    lines[i] = String.valueOf(sb);
                }
                stringBuilder1.append(lines[i]).append("\n");
            } else {
                stringBuilder1.append(lines[i]).append("\n");
            }
            i++;
        }
        return stringBuilder1;
    }
}
