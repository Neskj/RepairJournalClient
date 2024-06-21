package neskj.RepairJournalClient.Services;

import neskj.RepairJournalClient.Models.RepairUnit;

import java.util.List;

public interface InputParser {

    List<RepairUnit> parse(String[][] inputArray);
}
