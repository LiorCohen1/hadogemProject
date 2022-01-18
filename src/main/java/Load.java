import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Load<T> {
    public void writeIntoFile(List<ArrayList<T>> items, String folderPath) throws IOException;
}
