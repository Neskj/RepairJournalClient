package neskj.RepairJournalClient.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HttpDataTest {

    private HttpData testData;

    @BeforeEach
    void init() {

        testData = new HttpData("FW-150", "12345", "Нет ротации камеры");
    }

    @Test
    public void createNotNull() {

        assertNotNull(testData);
    }

    @Test
    public void settersTestHappyFlow() {

        HttpData expectData = new HttpData("FW-100", "54321", "Нет хода");

        testData.setType("FW-100");
        testData.setSerial("54321");
        testData.setDefect("Нет хода");

        assertEquals(expectData, testData);
    }

    @Test
    public void gettersTestHappyFlow() {

        String expectType = "FW-150";
        String expectSerial = "12345";
        String expectDefect = "Нет ротации камеры";

        assertEquals(expectType, testData.getType());
        assertEquals(expectSerial, testData.getSerial());
        assertEquals(expectDefect, testData.getDefect());
    }

    @Test
    public void returnRightString() {

        String expectString = "{\n" +
                "    \"type\":\"" + "FW-150" + "\",\n" +
                "    \"serial\":\"" + "12345" + "\",\n" +
                "    \"defect\":\"" + "Нет ротации камеры" + "\"\n" +
                "}";

        assertEquals(expectString, testData.toString());
    }
}
