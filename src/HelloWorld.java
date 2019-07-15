

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
        
        StringBuilder[] fileLines = new StringBuilder[theFile.length()];
        Parser.fileToArray(fileLines, theFile);
    }
}