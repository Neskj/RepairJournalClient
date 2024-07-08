package neskj.RepairJournalClient.Services;

import neskj.RepairJournalClient.Models.RepairUnit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FreakParserTest {

    InputParser parser=new FreakParser();

    @Test
    public void createNotNull(){

        parser=new FreakParser();

        assertNotNull(parser);
    }

    @Test
    public void parseHappyFlow(){

        String[][] incomingData={

                {"FW-100","11111","01.02.2023","Нет видео","","В ремонте"},
                {"vCam-6","22222","02.02.2023","Нет подсветки","Замена модуля освещения","Готов"}
        };

        RepairUnit firstUnit=new RepairUnit.Builder()
                .addType("FW-100")
                .addSerial("11111")
                .addDate("01.02.2023")
                .addDefect("Нет видео")
                .addComplete("")
                .addStatus("В ремонте")
                .build();

        RepairUnit secondUnit=new RepairUnit.Builder()
                .addType("vCam-6")
                .addSerial("22222")
                .addDate("02.02.2023")
                .addDefect("Нет подсветки")
                .addComplete("Замена модуля освещения")
                .addStatus("Готов")
                .build();

        List<RepairUnit> expectList=new ArrayList<>(Arrays.asList(firstUnit,secondUnit));

        List<RepairUnit> resultList=parser.parse(incomingData);

        assertEquals(expectList,resultList);
    }
}
