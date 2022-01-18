import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadCSV<T, T2> implements ReadFile<SamplingCSV, CSVRecord> {

    @Override
    public List<ArrayList<SamplingCSV>> FileIntoList(String path) throws IOException {
        Reader in = new FileReader(path);
        int num = 1;
        int start;
        List<ArrayList<SamplingCSV>> arrayListOfRecords = new ArrayList<>();
        List<SamplingCSV> samplingCSVArrayList = new ArrayList<>();
        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
        Iterator<CSVRecord> csvRecordIterator = records.iterator();
        while (csvRecordIterator.hasNext()) {
            samplingCSVArrayList.add(newItem(csvRecordIterator));
            if (samplingCSVArrayList.size() % 50000 == 0) {
                if (num == 1) {
                    start = 0;
                } else {
                    start = (5000 * (num - 1)) - 1;
                }
                num++;
                arrayListOfRecords.add(new ArrayList<SamplingCSV>(samplingCSVArrayList.subList(start, samplingCSVArrayList.size())));
            }

        }
        return arrayListOfRecords;


    }

    @Override
    public SamplingCSV newItem(Iterator<CSVRecord> csvRecordIterator) {
        String madaCode=null, idNum=null, sIdType=null, firstName=null, lastName = null;
        String city = null, barcode=null, street=null, buildingNumber=null, getDate=null, takeDate=null, resultDate=null;
        madaCode = String.valueOf(csvRecordIterator.next().get(0));
        idNum = csvRecordIterator.next().get(1);
        sIdType = (csvRecordIterator.next().get(2));
        firstName = csvRecordIterator.next().get(3);
        lastName = csvRecordIterator.next().get(4);
        if (csvRecordIterator.hasNext()) {
            city = csvRecordIterator.next().get(5);
            barcode = csvRecordIterator.next().get(8);
            street = csvRecordIterator.next().get(6);
            buildingNumber = csvRecordIterator.next().get(7);
            getDate = csvRecordIterator.next().get(9);
            takeDate = csvRecordIterator.next().get(10);
            resultDate = csvRecordIterator.next().get(11);
        }

        return new SamplingCSV(madaCode, idNum, sIdType, firstName, lastName, city, street, buildingNumber, barcode, getDate, takeDate, resultDate);


    }

}


