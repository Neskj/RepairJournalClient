package neskj.RepairJournalClient.Models;

public class RepairUnit {

    private String type;
    private String serial;
    private String date;
    private String defect;
    private String complete;
    private String status;

    @Override
    public String toString() {
        return "RepairUnit{" +
                "type='" + type + '\'' +
                ", serial='" + serial + '\'' +
                ", date='" + date + '\'' +
                ", defect='" + defect + '\'' +
                ", complete='" + complete + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

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

    public static class Builder {

        private final RepairUnit repairUnit;

        public Builder() {

            repairUnit = new RepairUnit();
        }

        public Builder addType(String type) {

            repairUnit.type = type;
            return this;
        }

        public Builder addSerial(String serial) {

            repairUnit.serial = serial;
            return this;
        }

        public Builder addDate(String date) {

            repairUnit.date = date;
            return this;
        }

        public Builder addDefect(String defect) {

            repairUnit.defect = defect;
            return this;
        }

        public Builder addComplete(String complete) {

            repairUnit.complete = complete;
            return this;
        }

        public Builder addStatus(String status) {

            repairUnit.status = status;
            return this;
        }

        public RepairUnit build() {

            return repairUnit;
        }
    }
}