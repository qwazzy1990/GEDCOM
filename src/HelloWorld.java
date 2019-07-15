

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
        Parser.openFile(theFile, "../test/test.txt");
        
        ArrayList<String> fileLines = new ArrayList<String>();
        Parser.fileToArray(fileLines, theFile);

        for(int i = 0; i < fileLines.size(); i++)
            System.out.println(fileLines.get(i));
    }
}