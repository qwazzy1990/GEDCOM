
import java.util.*;

public class GedObject {

    String type;

    public String getType() {
        return this.type;
    }

    public void setType(String s) {
        this.type = String.valueOf(s);
    }

    String ptr;

    public String getPtr() {
        return this.ptr;
    }

    public void setPtr(String s) {
        this.ptr = String.valueOf(s);
    }

   
    ArrayList<String> references;

    public ArrayList<String> getReferences() {
        return this.references;
    }

    public void setReference(String r) {
        this.references.add(r);
    }

    ArrayList<String> tags;

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public void setTag(String t) {
        this.tags.add(t);
    }

    ArrayList<String> values;

    public ArrayList<String> getValues() {
        return this.values;
    }

    public void setValue(String v) {
        this.values.add(v);
    }

    GedObject() {
        type = "";
        ptr = "";

        references = new ArrayList<String>();
        tags = new ArrayList<String>();
        values = new ArrayList<String>();

    }

    public String toString() {
        return "Type: " + this.getType() + "\n" + "Pointer: " + this.getPtr() + "\n" +"References: " + this.getReferences() + "\n" + "Tags: "
                + this.getTags().toString() + "\n" + "Values: " + this.getValues().toString() + "\n";
    }
}