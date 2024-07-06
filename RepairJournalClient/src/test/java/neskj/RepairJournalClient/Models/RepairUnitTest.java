package neskj.RepairJournalClient.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepairUnitTest {

    @Test
    public void builderAddTypeSuccessAndGetter() {

        String expectType = "FW-100";
        RepairUnit testUnit = new RepairUnit.Builder().addType(expectType).build();

        assertEquals(expectType, testUnit.getType());
    }

    @Test
    public void builderAddSerialSuccessAndGetter() {

        String expectSerial = "123456789";
        RepairUnit testUnit = new RepairUnit.Builder().addSerial(expectSerial).build();

        assertEquals(expectSerial, testUnit.getSerial());
    }

    @Test
    public void builderAddDateSuccessAndGetter() {

        String expectDate = "01.01.2007";
        RepairUnit testUnit = new RepairUnit.Builder().addDate(expectDate).build();

        assertEquals(expectDate, testUnit.getDate());
    }

    @Test
    public void builderAddDefectSuccessAndGetter() {

        String expectDefect = "Вышел из строя драйвер";
        RepairUnit testUnit = new RepairUnit.Builder().addDefect(expectDefect).build();

        assertEquals(expectDefect, testUnit.getDefect());
    }

    @Test
    public void builderAddCompleteSuccessAndGetter() {

        String expectComplete = "Ремонт драйвера";
        RepairUnit testUnit = new RepairUnit.Builder().addComplete(expectComplete).build();

        assertEquals(expectComplete, testUnit.getComplete());
    }

    @Test
    public void builderAddStatusSuccessAndGetter() {

        String expectStatus = "Готов";
        RepairUnit testUnit = new RepairUnit.Builder().addStatus(expectStatus).build();

        assertEquals(expectStatus, testUnit.getStatus());
    }

    @Test
    public void returnRightString() {

        String expectString = "RepairUnit{" +
                "type='" + "vCam 6" + '\'' +
                ", serial='" + "999999" + '\'' +
                ", date='" + "13.03.2023" + '\'' +
                ", defect='" + "Перелом кабеля" + '\'' +
                ", complete='" + "Перепайка" + '\'' +
                ", status='" + "Готов" + '\'' +
                '}';

        RepairUnit testUnit = new RepairUnit.Builder()
                .addType("vCam 6")
                .addSerial("999999")
                .addDate("13.03.2023")
                .addDefect("Перелом кабеля")
                .addComplete("Перепайка")
                .addStatus("Готов")
                .build();

        assertEquals(expectString, testUnit.toString());
    }
}
