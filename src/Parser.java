
import java.util.*;
import java.util.stream.*;
import java.awt.Desktop;
import java.io.*;

public class Parser {

    /**
     * Pseudo-random value used to replace "\r" and "\n". Needed for a workaround to \
     * split the file on \r \n
     */
    static String replaceValue = new String("ZyZyZxZy");

    /**
     * Opens a file and adds the contents of the fike to the StringBuilder theFile.
     * 
     * @param theFile
     * @param fileName Opens fileName and copies the content intoTheFile.
     */
    public static void openFile(StringBuilder theFile, String fileName) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int r;

            while ((r = reader.read()) != -1) {
                theFile.append((char) (r));
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 
     * @param fileLines
     * @param theFile   Splits theFile into and array of lines. Splits on "\r" and
     *                  "\n"
     */
    public static void fileToArray(ArrayList <String> fileLines, StringBuilder theFile) {
        // Because I could not get replace all to work, or to get replace to work on the
        // Substrng \r\n or \n\r, I used this work around.
        String temp = theFile.toString();
        temp = customReplaceAll(temp, "\\n");
        temp = customReplaceAll(temp, "\\r");

        String[] splitOne = temp.split(replaceValue);


        // Copy all non-empty strings into fileLines
        for (int i = 0; i < splitOne.length; i++) {
            if (splitOne[i].isEmpty() == false) {
               fileLines.add(splitOne[i].toString());
            }
        }

    }

    /**
     * 
     * @param s
     * @param delim
     * @return s
     * Replaces all instances of delim with random sequences of chracaters
     */
    private static String customReplaceAll(String s, String delim) {
        if (s.contains(delim) == false) {
            return s;
        }

        String ss = s.replace(delim, replaceValue);
        return customReplaceAll(ss, delim);
    }

}
