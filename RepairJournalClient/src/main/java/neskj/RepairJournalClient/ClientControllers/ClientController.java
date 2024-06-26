package neskj.RepairJournalClient.ClientControllers;

import neskj.RepairJournalClient.Models.HttpData;
import neskj.RepairJournalClient.Models.RepairUnit;
import neskj.RepairJournalClient.Proxy.JournalProxy;
import neskj.RepairJournalClient.Services.InputParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller("http://localhost:8080")
public class ClientController {

    private final JournalProxy proxy;
    private final InputParser parser;
    private List<RepairUnit> dataList=new ArrayList<>();

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

    @PostMapping("/journal/create")
    public String getDataFromView(@RequestParam String type,
                                  @RequestParam String serial,
                                  @RequestParam String defect) {

        HttpData httpData=new HttpData(type,serial,defect);
        proxy.createNewLog(httpData);

        return "Create.html";
    }

    @GetMapping("/journal/update")
    public String openUpdatePage(){

        return "Update.html";
    }

    @PostMapping("/journal/update")
    public String takeUpdateData(@RequestParam String serial, @RequestParam String complete){

        proxy.updateStatus(serial,complete);

        return "Update.html";
    }

    @GetMapping("/journal/findall")
    public String openFindAllUnits(Model page){

        dataList.clear();
        dataList=parser.parse(proxy.getNotDone());
        page.addAttribute("dataList",dataList);

        return "FindAll.html";
    }

    @GetMapping("/journal/serial")
    public String openFindBySerial(){

        return "FindBySerial.html";
    }

    @PostMapping("/journal/serial")
    public String takeDataSerial(@RequestParam String serial,Model page){

        dataList.clear();
        dataList=parser.parse(proxy.findBySerial(serial));
        page.addAttribute("dataList",dataList);

        return "FindBySerial.html";
    }
}
