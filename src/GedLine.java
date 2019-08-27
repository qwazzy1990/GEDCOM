import java.util.*;
import java.util.stream.*;
import java.awt.Desktop;
import java.io.*;

public class GedLine extends Object {

    /*Number represeting the line numbe of the file line in the .ged file. Must be >= 0*/
    String gedLineNumber;

    /**
     * @param gedLineNumber the gedLineNumber to set
     * 
     */


    public void setGedLineNumber(String gedLineNumber) {
        this.gedLineNumber = String.valueOf(gedLineNumber);
    }

    public String getGedLineNumber()
    {
        return this.gedLineNumber;
    }

    /**The tag is the tag of the line in the file representing the kind of data
     * For eaxample, the tage INDI represents the following data on said line belongs to an individual
     */
    String tag;

    /**
     * @param tag the tag in the ged line
     */
    public void setTag(String tag) {
        
        this.tag = String.valueOf(tag);
    }
    
    /**
     * @return: return this.tag
     */

     public String getTag()
     {
        if(this.tag.isEmpty())
        {
            return "No Tag";
        }
         return this.tag;
     }

    /**
     * The pointer is an optional component of a ged line. Indicates that the current line points to, or referneces,
     * another structure in the file. For example, @4@ INDI ... means that the following idnividual is referred to
     * by another structure with the reference @4@. Most likely a family with the reference (unique ID) of @4@.
     */
    String pointer;

    public void setPointer(String ptr)
    {
        
        this.pointer = String.valueOf(ptr);
    }

    public String getPointer()
    {
        if(this.pointer.isEmpty())
        {
            return "No Pointer";
        }
        return this.pointer;
    }

    String reference;
    /**
     * Constructor for a GEDline
     */
    public void addReference(String s)
    {
        this.reference = String.valueOf(s);
    }

  

    /**
     * @return this.references
     */
    public String getReference()
    {
        if(reference.isEmpty())
        {
            return "No Reference";
        }
        return this.reference;
    }

    /**
     * Represents a line value
     */
    String value;

    public void setValue(String val)
    {
        this.value = String.valueOf(val);
    }

    public String getValue()
    {
        if(this.value.isEmpty())return "No Value";
        return this.value;
    }
    /**
     * Constructor: default. 
     * Sets values to empty or -1
     * @return gedLine object
     */
    GedLine() {
        //in the constructor initialize the values of gedLineNumber to -1
        //initialize references;
        //initialzize Strings to empty strings
        this.gedLineNumber = "-1";
        this.tag = "";
        this.pointer = "";
        this.reference = "";
        this.value = "";
    }

    /**
     * Returns a human readable version of a GEDline
     */
    public String toString()
    {
    
        return "Line Number: " + this.getGedLineNumber() +"\n" +"Tag: " + this.getTag() 
        +"\n" + "Pointer: "+this.getPointer() + "\n" + "Reference: "+this.getReference() +"\n"+"Value: "+this.getValue();
    }


    /**
     * @return Returns true if this has the same content as b, Else returns false.
     * If either are null return false.
     */
    public boolean sameLine(GedLine b)
    {
        if(this == null || b == null)return false;
        if(this.toString().equals(b.toString()))
        {
            return true;
        }
        return false;
    }

    

    /**
     * 
     */

}