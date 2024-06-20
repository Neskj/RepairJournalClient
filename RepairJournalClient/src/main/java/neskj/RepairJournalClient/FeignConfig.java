package neskj.RepairJournalClient;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "neskj.RepairJournalClient.Proxy")
public class FeignConfig {
}
