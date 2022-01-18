import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface ReadFile<T,T2> {
    public  List<ArrayList<T>> FileIntoList(String path) throws IOException;
    public T newItem(Iterator <T2> csvRecordIterator);


}
