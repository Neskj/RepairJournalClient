package neskj.RepairJournalClient.Services;

import neskj.RepairJournalClient.Models.RepairUnit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FreakParser implements InputParser{

    private List<RepairUnit> resultList=new ArrayList<>();

    @Override
    public List<RepairUnit> parse(String[][] inputArray) {

        for(String[] x: inputArray){

            RepairUnit unit=new RepairUnit.Builder()
                    .addType(x[0])
                    .addSerial(x[1])
                    .addDate(x[2])
                    .addDefect(x[3])
                    .addComplete(x[4])
                    .addStatus(x[5])
                    .build();
            resultList.add(unit);

            System.out.println(unit.toString());
        }



        return resultList;
    }
}
