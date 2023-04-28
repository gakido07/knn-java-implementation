package org.csc.lib;

import com.opencsv.CSVReader;
import lombok.NoArgsConstructor;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
public class CsvUtil {
  public List<List<String>> readCsv(String filePath) {
    List<List<String>> records = new ArrayList<>();
    try {
      CSVReader csvUtil = new CSVReader(new FileReader(filePath));
      String[] values;
      while ((values = csvUtil.readNext()) != null) {
        records.add(Arrays.asList(values));
      }
    } catch (Exception ignored) {
    }
    return records;
  }
}
