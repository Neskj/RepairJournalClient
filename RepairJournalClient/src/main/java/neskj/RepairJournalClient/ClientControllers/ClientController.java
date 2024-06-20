package neskj.RepairJournalClient.ClientControllers;

import neskj.RepairJournalClient.Models.Unit;
import neskj.RepairJournalClient.Proxy.JournalProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller("http://localhost:8080")
public class ClientController {

    private final JournalProxy proxy;

    @Autowired
    ClientController(JournalProxy proxy){

       this.proxy=proxy;
    }

    @GetMapping("/journal")
    public String openPageJournal(){

        return "Journal.html";
    }

    @GetMapping("/journal/create")
    public String openPageCreate(){

        return "Create.html";
    }

    @GetMapping("/journal/update")
    public String openUpdatePage(){

        return "Update.html";
    }

    @GetMapping("/journal/findall")
    public String openFindAllUnits(Model page){

        Iterable<Unit>listNotDoneUnits= proxy.getNotDone();
        System.out.println(listNotDoneUnits);

        return "FindAll.html";
    }

    @GetMapping("/journal/serial")
    public String openFindBySerial(){

        return "FindBySerial.html";
    }


}
