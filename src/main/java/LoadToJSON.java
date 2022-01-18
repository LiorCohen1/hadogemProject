import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.File;

import org.json.simple.JSONObject;

public class LoadToJSON implements Load<SamplingCSV> {
    @Override
    public void writeIntoFile(List<ArrayList<SamplingCSV>> items, String folderPath) throws IOException {
        File file = new File(folderPath, "Jsons");
        file.createNewFile();
        for (int i = 0; i < items.size(); i++) {
            String name = "JSON" + i;
            FileWriter fileWriter = new FileWriter(new File("C:/Users/Liorc/Desktop/Jsons", name));
            JSONObject jsonObject = new JSONObject();
            for (int x = 0; x < items.get(i).size(); x++) {
                jsonObject.put("MADACODE", items.get(i).get(x).madaCode);
                jsonObject.put("IDNum", items.get(i).get(x).idNum);
                jsonObject.put("IDType", items.get(i).get(x).idType);
                jsonObject.put("FirstName", items.get(i).get(x).firstName);
                jsonObject.put("LastName", items.get(i).get(x).lastName);
                jsonObject.put("City", items.get(i).get(x).city);
                jsonObject.put("Street", items.get(i).get(x).street);
                jsonObject.put("BuildingNumber", items.get(i).get(x).buildingNumber);
                jsonObject.put("Barcode", items.get(i).get(x).barcode);
                jsonObject.put("GetDate", items.get(i).get(x).getDate);
                jsonObject.put("TakeDate", items.get(i).get(x).takeDate);
                jsonObject.put("ResultDate", items.get(i).get(x).resultDate);
                fileWriter.write(jsonObject.toJSONString());
                jsonObject.clear();

            }

            fileWriter.close();
        }

    }
}
