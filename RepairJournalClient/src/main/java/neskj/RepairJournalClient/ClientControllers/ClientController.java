package neskj.RepairJournalClient.ClientControllers;

import neskj.RepairJournalClient.Models.RepairUnit;
import neskj.RepairJournalClient.Proxy.JournalProxy;
import neskj.RepairJournalClient.Services.InputParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("http://localhost:8080")
public class ClientController {

    private final JournalProxy proxy;
    private final InputParser parser;

    @Autowired
    ClientController(JournalProxy proxy,InputParser parser){

       this.proxy=proxy;
       this.parser=parser;
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

        List<RepairUnit> dataList=parser.parse(proxy.getNotDone());
        page.addAttribute("dataList",dataList);

        return "FindAll.html";
    }

    @GetMapping("/journal/serial")
    public String openFindBySerial(){

        return "FindBySerial.html";
    }

    @PostMapping("/journal/serial")
    public String takeDataSerial(@RequestParam String serial,Model page){

        List<RepairUnit> dataList=parser.parse(proxy.findBySerial(serial));
        page.addAttribute("dataList",dataList);

        return "FindBySerial.html";
    }



}
