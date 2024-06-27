package neskj.RepairJournalClient.Proxy;

import neskj.RepairJournalClient.Models.HttpData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "FeignOne", url = "http://185.198.152.105:6060")
public interface JournalProxy {

    @GetMapping("/notdone")
    String[][] getNotDone();

    @GetMapping("/find")
    String[][] findBySerial(@RequestParam String serial);

    @PostMapping("/data")
    void createNewLog(@RequestBody HttpData httpData);

    @PostMapping("/complete")
    void updateStatus(@RequestParam String serial,@RequestParam String complete);

}
