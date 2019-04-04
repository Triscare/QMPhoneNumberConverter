import lombok.Data;

@Data
public class PhoneNumber {

    private String countryCode;
    private String areaCode;
    private String number;
    private String directDialing;

    private PhoneNumber(){}

    public PhoneNumber(String countryCode, String areaCode, String number){
        this.countryCode=countryCode;
        this.areaCode=areaCode;
        this.number=number;
    }

    public PhoneNumber(String countryCode, String areaCode, String number, String directDialing){
        this.countryCode=countryCode;
        this.areaCode=areaCode;
        this.number=number;
        this.directDialing=directDialing;
    }
}
