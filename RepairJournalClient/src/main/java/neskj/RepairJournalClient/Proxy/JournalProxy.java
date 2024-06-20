package neskj.RepairJournalClient.Proxy;

import neskj.RepairJournalClient.Models.Unit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "FeignOne" ,url = "http://185.198.152.105:6060")
public interface JournalProxy {

    @GetMapping("/notdone")
    Iterable<Unit> getNotDone();

}
