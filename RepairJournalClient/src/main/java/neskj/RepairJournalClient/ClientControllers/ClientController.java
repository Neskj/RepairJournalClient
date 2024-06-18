package neskj.RepairJournalClient.ClientControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller("http://localhost:8080")
public class ClientController {

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
    public String openFindAllUnits(){

        return "FindAll.html";
    }

    @GetMapping("/journal/serial")
    public String openFindBySerial(){

        return "FindBySerial.html";
    }


}
