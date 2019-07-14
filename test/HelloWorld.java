
import jdk.nashorn.internal.ir.GetSplitState;

import java.util.*;
import java.util.stream.*;
import java.io.File;
import java.io.IOException;


public class HelloWorld 
{
    public static void main(String[] args) 
    {
        System.out.println("Hello World");

        File f = Parser.openFile("testing.txt");
    }
}