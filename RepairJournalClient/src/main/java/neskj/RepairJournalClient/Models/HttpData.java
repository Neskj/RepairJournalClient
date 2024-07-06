package neskj.RepairJournalClient.Models;

import java.io.Serializable;
import java.util.Objects;

public class HttpData implements Serializable {

    private String type;
    private String serial;
    private  String defect;

    public HttpData(String type,String serial,String defect){

        this.type=type;
        this.serial=serial;
        this.defect=defect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HttpData httpData = (HttpData) o;
        return Objects.equals(type, httpData.type) &&
                Objects.equals(serial, httpData.serial) &&
                Objects.equals(defect, httpData.defect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, serial, defect);
    }

    @Override
    public String toString() {
        return "{\n" +
                "    \"type\":\"" + type + "\",\n" +
                "    \"serial\":\"" + serial + "\",\n" +
                "    \"defect\":\"" + defect + "\"\n" +
                "}";

    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }

    public String getType() {
        return type;
    }

    public String getSerial() {
        return serial;
    }

    public String getDefect() {
        return defect;
    }
}
