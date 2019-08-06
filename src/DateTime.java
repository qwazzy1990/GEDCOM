


public class DateTime
{

    
    String day;

    public void setDay(String day)
    {
        this.day = String.valueOf(day);
    }
    public String getDay(  )
    {
        return this.day;
    }

    String month;
    public void setMonth(String month)
    {
        this.month = String.valueOf(month);
    }
    public String getMonth()
    {
        return this.month;
    }

    String year;
    public void setYear(String year)
    {
        this.year = String.valueOf(year);
    }

    public String getYear()
    {
        return this.year;
    }

    String hour;
    public void setHour(String hour)
    {
        this.hour = String.valueOf(hour);
    }
    public String getHour()
    {
        return this.hour;
    }

    String minute;
    public void setMinute(String minute)
    {
        this.minute = String.valueOf(minute);
    }
    public String getMinute()
    {
        return this.minute;
    }
    
    String second;
    public void setSecond(String second)
    {
        this.second = String.valueOf(second);
    }
    
    public String getSecond()
    {
        return this.second;
    }

    //Constructor
    DateTime()
    {
        this.second = "";
        this.minute = "";
        this.hour = "";
        this.day = "";
        this.month = "";
        this.year = "";
    }

    //ToString
    public String toString()
    {
        return "Month:"+ this.getMonth()+"\n"+
        "Day:"+this.getDay()+"\n"+
        "Year:"+this.getYear()+"\n"+
        "Hour:"+this.getHour()+"\n"+
        "Minute"+this.getMinute()+"\n"+
        "Second:"+this.getSecond()+"\n"; 
    }

    //If the same dateTime
    public boolean same(DateTime d)
    {
        if(this.toString().equals(d.toString()))
        {
            return true;
        }
        return false;
    }

}