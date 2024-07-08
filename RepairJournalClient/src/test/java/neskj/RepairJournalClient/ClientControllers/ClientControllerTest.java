package neskj.RepairJournalClient.ClientControllers;

import neskj.RepairJournalClient.Models.HttpData;
import neskj.RepairJournalClient.Proxy.JournalProxy;
import neskj.RepairJournalClient.Services.InputParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {

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


    public void openFindAllUnitsTestSuccess(){

    }

    public void openFindBySerialTestSuccess(){

    }

    public void takeDataSerialTestSuccess(){
        
    }

}
