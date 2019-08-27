


public class Note
{
    String text;
    String pointer;

    public void setText(String text)
    {
        this.text = String.valueOf(text);
    }
    public String getText()
    {
        return this.text;
    }
    public void setPointer(String ptr)
    {
        this.pointer = String.valueOf(ptr);
    }
    public String getPointer()
    {
        return this.pointer;
    }

    Note()
    {
        this.text = "";
        this.pointer = "";
    }

    public String toString()
    {
        return "Pointer:"+this.getPointer()+"\n"
        +"Text:"+this.getText()+"\n";
    }

    public boolean same(Note n)
    {
        if(this.toString().equals(n.toString()))
        {
            return true;
        }
        return false;
    }
}