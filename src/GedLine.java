import java.util.*;
import java.util.stream.*;
import java.awt.Desktop;
import java.io.*;

public class GedLine{


    /**
     * Constructor for a GEDline
     */
    int gedLineNumber;
    /**
     * @param gedLineNumber the gedLineNumber to set
     */
    public void setGedLineNumber(int gedLineNumber) {
        this.gedLineNumber = gedLineNumber;
    }

    String tag;
    /**
     * @param tag the tag in the ged line
     */
    public void setTag(String tag)
    {
        this.tag = String.valueOf(tag);
    }

    GedLine(){

    }
}