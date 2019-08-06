
import java.util.*;
import java.util.stream.*;


import java.awt.Desktop;
import java.io.*;

public class Parser {

    /***SECTION FOR TURNGING A FILE INTO A STRING ARRAY */
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
        temp = customReplaceAll(temp, "\n");
        temp = customReplaceAll(temp, "\r");

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

    /**END SECTION */



    /**Section to adjust for any CONT or CONT tags in the 2-d array */

    public static void fold(ArrayList<String> write, ArrayList<String> read)
    {
        //Go through each line of read
        for(int i = 0; i < read.size(); i++)
        {
            //get the line in the file from read[i]
            String s = new String(read.get(i));

            //if it contains CONC or CONT then
            if(s.contains("CONC") || s.contains("CONT"))
            {
                //remove CONT or CONC from 's'
                if(s.contains(("CONT")))
                    s = s.substring(s.lastIndexOf("CONT")+4);
                
                else
                    s = s.substring(s.lastIndexOf("CONC")+4);

                //for while loop counter
                int x = i+1;
                boolean flag = true;

                //get the previous line in the file that did not contain CONC or CONT.I.E. the 
                //line just before 's'
                String add = new String(read.get(i-1));

                //while the lines begin with CONT or CONC
                while(flag)
                {
                    //get the string
                    String ss = new String(read.get(x));
                    //if it contains CONT then concatenate ss to s with everything after the last 'T' in CONT
                    if(ss.contains("CONT"))
                    {
                        if(ss.length() > ss.lastIndexOf("CONT")+4){
                            String sss = ss.substring(ss.lastIndexOf("CONT")+4);
                        
                            s += sss;
                        }
                    }
                    //if it contains CONC then concatenate ss to s with everything after the space after the last
                    //'C' in CONC
                    else if(ss.contains("CONC"))
                    {
                        if(ss.length() > ss.lastIndexOf("CONC")+5){
                            String sss = ss.substring(ss.lastIndexOf("CONC")+5);
                        
                            s += sss;
                        }
                       
                    }
                    else{
                        flag = false;
                        break;
                    }
                    x++;
                }
                write.remove(write.size()-1);
                add += s;
                write.add(add);
                i = x-1;
            }
    
            else 
            {
                write.add(s);
            }
        }
    }

    /**SECTION TO PARSE A STRING ARRAY INTO AN ARRAY LIST OF GEDlines */

    public static void arrayToGedLines(ArrayList<GedLine> gedLines, ArrayList<String> fileLines)
    {
        int count = 0;

        //for
        for(int i = 0; i < fileLines.size(); i++)
        {
            String s = fileLines.get(i);
            String[] arr = s.split(" ");
            GedLine g = new GedLine();

            //set the line number
            g.setGedLineNumber(arr[0]);

            //if it is a pointer
            if(isXref(arr[1]))
            {
                g.setPointer(arr[1]);
            }

            //else it is a tag
            else 
            {
                g.setTag(arr[1]);
            }

            //if there are three elements in the array then
            if(arr.length == 3)
            {
                System.out.println(g.getTag());
                //if the last element is a pointer then it is a reference to some other object
                if(isXref(arr[2]))
                {
                    g.addReference(arr[2]);
                }

               
                else if(g.getTag() =="No Tag")
                {
                    g.setTag(arr[2]);
                }
                //else if it is a value  then set the value
                else 
                {
                    g.setValue(arr[2]);
                }
            }//end if

            //if greater than 3
            if(arr.length > 3)
            {
                //if it is a pointer then add a reference
                if(isXref(arr[2]))
                {
                    g.addReference(arr[2]);
                    String temp = "";
                    //the remaining elements will be values
                    for(int x = 3; x < arr.length; x++)
                    {
                        temp += " ";
                        temp += arr[x];
                    }
                    g.setValue(temp);
                }//end if

                //if it is a tag then
                else if( g.getTag()=="No Tag")
                {
                    g.setTag(arr[2]);

                    String temp = "";
                    //remaining elements are values
                    for(int x = 3; x < arr.length; x++)
                    {
                        temp += " ";
                        temp += arr[x];
                    }
                    g.setValue(temp);
                }//end if

                //else they are just values
                else 
                {
                    String temp = "";
                    for(int x = 2; x < arr.length; x++)
                    {
                        temp += " ";
                        temp += arr[x];
                    }
                    g.setValue(temp);
                }//end else
            }//end if

            gedLines.add(g);
        }//end for
    }//end func

   




    /**VALIDATOR SECTION */
    
    
    /**Checks if two objects are really one and the same object in memory */
    public static boolean sameObject(Object a, Object b)
    {
        if(a == null)return false;
        if(b == null)return false;

        if(a == b)return true;
        return false;
    }

    /**
     * Checks if the string s i an XREF. Depending on where it occurs in a GEDline, it can be a 
     * pointer or a reference.
     */
    private static boolean isXref(String s)
    {   
        if(s == null)return false;
        if(s.charAt(0)=='@' && s.charAt(s.length()-1)=='@')
        {
            return true;
        }
        return false;
    }
    /**END SECTION */
}
