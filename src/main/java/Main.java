import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        LoadToJSON loadToJSON=new LoadToJSON();
        ReadCSV readCSV=new ReadCSV();
        String folderPath,filePath;
        Scanner s=new Scanner(System.in);
        System.out.println("Please enter the folder path");
        folderPath=s.next();
        System.out.println("Please enter the file path");
        filePath=s.next();
        loadToJSON.writeIntoFile(readCSV.FileIntoList(filePath),folderPath);
    }


}
