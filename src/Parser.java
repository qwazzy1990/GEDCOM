import jdk.nashorn.internal.ir.GetSplitState;

import java.util.*;
import java.util.stream.*;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


public class Parser {

    public static openFile(String fileName)
    {
        File file = new File(fileName);

        if(Desktop.isDesktopSupported() == false)
        {
            System.out.println("Desktop is not supported");
        }

        Desktop desktop = Desktop.getDesktop();

        if(file.exists())
        {
            desktop.open(file);
            return file;
        }
        else 
        {
            return NULL;
        }
    }
}

