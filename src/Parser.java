
import java.util.*;
import java.util.stream.*;
import java.awt.Desktop;
import java.io.*;



public class Parser {

    public static void openFile(StringBuilder theFile, String fileName)
    {

        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int r;
           
            while((r = reader.read())!= -1)
            {
                theFile.append((char)(r));
            }
            reader.close();

        }catch(IOException e)
        {
            e.printStackTrace();
        }
       
       
    }

    public static void fileToArray(StringBuilder[] fileLines, StringBuilder theFile)
    {
        String temp = theFile.toString();
        String newString = customReplaceAll(temp, "\\n");
        System.out.println(newString);
        String finalString = customReplaceAll(newString, "\\r");
        System.out.println(finalString);
        //temp.replaceAll("\n", "ZyZyZxZy");

        String[] splitOne = finalString.split("ZyZyZxZy");
        System.out.println(splitOne.length);
        for(int i = 0; i < splitOne.length; i++)
        {
            System.out.println(splitOne[i]);
        }
    }

    private static String customReplaceAll(String s, String delim)
    {
        if(s.contains(delim)==false)
        {
            return s;
        }

        String ss = s.replace(delim, "ZyZyZxZy");
        return customReplaceAll(ss, delim);
    }
}

