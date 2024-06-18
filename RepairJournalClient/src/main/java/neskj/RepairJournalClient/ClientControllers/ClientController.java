package neskj.RepairJournalClient.ClientControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ClientController {

    @GetMapping("/journal")
    public String openPageJournal(){

        return "Journal.html";
    }

    @GetMapping("/journal/create")
    public String openPageCreate(){

        return "Create.html";
    }


}
