



import java.util.*;

public class TagValue
{


    String tag;
    String value;


    public void setTag(String s)
    {
        this.tag = String.valueOf(s);
    }
    public String getTag()
    {
        return this.tag;
    }


    public void setValue(String s)
    {
        this.value = String.valueOf(s);
    }

    public String getValue()
    {
        return this.value;
    }
    
    TagValue()
    {
        this.tag = "";
        this.value = "";
    }
}