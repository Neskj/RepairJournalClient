package neskj.RepairJournalClient.Models;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;

public class Unit {

   String type;
   String serial;
   String date;
   String defect;
   String complete;
   String status;

   public String getType() {
      return type;
   }

   public String getSerial() {
      return serial;
   }

   public String getDate() {
      return date;
   }

   public String getDefect() {
      return defect;
   }

   public String getComplete() {
      return complete;
   }

   public String getStatus() {
      return status;
   }

   public void setType(String type) {
      this.type = type;
   }

   public void setSerial(String serial) {
      this.serial = serial;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public void setDefect(String defect) {
      this.defect = defect;
   }

   public void setComplete(String complete) {
      this.complete = complete;
   }

   public void setStatus(String status) {
      this.status = status;
   }
}
