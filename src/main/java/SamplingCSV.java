import java.util.Date;

public class SamplingCSV {
    protected String madaCode;
    protected String idNum;
    protected String idType;
    protected String firstName;
    protected String lastName;
    protected String city;
    protected String street;
    protected String buildingNumber;
    protected String barcode;
    protected String getDate;
    protected String takeDate;
    protected String resultDate;

    public SamplingCSV(String madaCode, String idNum, String idType, String firstName, String lastName, String city, String street, String buildingNumber, String barcode, String getDate, String takeDate, String resultDate) {
        this.madaCode = madaCode;
        this.idNum = idNum;
        this.idType = idType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.barcode = barcode;
        this.getDate = getDate;
        this.takeDate = takeDate;
        this.resultDate = resultDate;
    }


}
