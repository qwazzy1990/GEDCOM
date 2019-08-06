

import java.util.*;
import java.util.stream.*;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class HelloWorld
{
    public static void main(String[] args)
    {
        StringBuilder theFile = new StringBuilder();
        Parser.openFile(theFile, "../test/fileOne.txt");
        
        ArrayList<String> fileLines = new ArrayList<String>();
        Parser.fileToArray(fileLines, theFile);
        

        
        ArrayList<String> folded = new ArrayList<String>();

        Parser.fold(folded, fileLines);
      


        
        ArrayList<GedLine> gedLines = new ArrayList();
        Parser.arrayToGedLines(gedLines, folded);

        for(int i = 0; i < gedLines.size(); i++)
        {
            System.out.println("-------------------");
            System.out.println(gedLines.get(i).toString());
            System.out.println("-------------------");
        }

        //System.out.println(line.toString());
    }
}