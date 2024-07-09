package neskj.RepairJournalClient.ClientControllers;

import neskj.RepairJournalClient.Models.HttpData;
import neskj.RepairJournalClient.Models.RepairUnit;
import neskj.RepairJournalClient.Proxy.JournalProxy;
import neskj.RepairJournalClient.Services.InputParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {

    @Mock
    private Model page;
    @Mock
    private JournalProxy proxy;
    @Mock
    private InputParser parser;
    @InjectMocks
    private ClientController controller;

    @Test
    public void createNotNull() {

        assertNotNull(controller);
    }

    @Test
    public void openPageJournalTestSuccess() {

        String expectResult = "Journal.html";

        assertEquals(expectResult, controller.openPageJournal());
    }

    @Test
    public void openPageCreateTestSuccess() {

        String expectResult = "Create.html";

        assertEquals(expectResult, controller.openPageCreate());
    }

    @Test
    public void getDataFromViewTestSuccess() {

        String testType = "FW-100";
        String testSerial = "123456";
        String testDefect = "Нет ротации";

        String expectResult = "Create.html";

        String result = controller.getDataFromView(testType, testSerial, testDefect);

        assertEquals(expectResult, result);

        verify(proxy, times(1)).createNewLog(any(HttpData.class));
    }

    @Test
    public void openUpdatePageTestSuccess(){

        String expectResult="Update.html";

        assertEquals(expectResult,controller.openUpdatePage());
    }

    @Test
    public void takeUpdateDataTestSuccess(){

        String testSerial="556633";
        String testComplete="Перепайка разъема кабеля";

        String expectResult="Update.html";

        String result =controller.takeUpdateData(testSerial,testComplete);

        assertEquals(expectResult,result);

        verify(proxy,times(1)).updateStatus(anyString(),anyString());
    }

    @Test
    public void openFindAllUnitsTestSuccess() {

        String expectResult = "FindAll.html";

        RepairUnit firstUnit = new RepairUnit.Builder()
                .addType("FW-300")
                .addSerial("888888")
                .addDate("12.12.2023")
                .addDefect("Не работает подъемник")
                .addComplete("Работы не производились")
                .addStatus("В ремонте")
                .build();

        List<RepairUnit> testList = new ArrayList<>();
        testList.add(firstUnit);

        when(parser.parse(any())).thenReturn(testList);

        assertEquals(expectResult, controller.openFindAllUnits(page));

        verify(proxy, times(1)).getNotDone();
        verify(parser, times(1)).parse(any());
        verify(page).addAttribute(eq("dataList"), anyCollection());
    }

    @Test
    public void openFindBySerialTestSuccess() {

        String expectResult = "FindBySerial.html";

        assertEquals(expectResult, controller.openFindBySerial());
    }

    @Test
    public void takeDataSerialTestSuccess() {

        String testSerial = "111111";
        String expectResult = "FindBySerial.html";

        RepairUnit firstUnit = new RepairUnit.Builder()
                .addType("FW-100")
                .addSerial("1111111")
                .addDate("12.12.2023")
                .addDefect("Нет подсветки")
                .addComplete("Перепайка диодов")
                .addStatus("Готов")
                .build();

        List<RepairUnit> testList = new ArrayList<>();
        testList.add(firstUnit);

        when(parser.parse(any())).thenReturn(testList);

        assertEquals(expectResult, controller.takeDataSerial(testSerial, page));

        verify(proxy, times(1)).findBySerial(testSerial);
        verify(parser, times(1)).parse(any());
        verify(page).addAttribute(eq("dataList"), anyCollection());     //не забыть использовать мэтчер
    }

}
