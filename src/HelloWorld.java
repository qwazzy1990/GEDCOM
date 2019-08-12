

import java.util.*;
import java.util.stream.*;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.security.GuardedObject;

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

        GedObject obj = new GedObject();

        
        //System.out.println(obj.toString());


        ArrayList<GedObject> obs = new ArrayList();
        Parser.gedLinesToGedObjects(obs, gedLines);
        System.out.println(obs.size());
        for(int i = 0; i < obs.size(); i++)
        {
            System.out.println("Here");
            System.out.println("-------------------");
            System.out.println(obs.get(i).toString());
            System.out.println("-------------------");
        }

        //System.out.println(line.toString());
    }
}