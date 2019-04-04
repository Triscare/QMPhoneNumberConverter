import lombok.Data;

@Data
public class PhoneNumber {

    private String countryCode;
    private String areaCode;
    private String number;
    private String directDialing;

    private String internationalNumber;

    private PhoneNumber(){}

    public PhoneNumber(String countryCode, String areaCode, String number){
        System.out.println("New number without direct dialing");
        this.countryCode=countryCode;
        this.areaCode=areaCode;
        this.number=number;
    }

    public PhoneNumber(String countryCode, String areaCode, String number, String directDialing){
        System.out.println("New number with direct dialing");
        this.countryCode=countryCode;
        this.areaCode=areaCode;
        this.number=number;
        this.directDialing=directDialing;
    }

    public PhoneNumber(String internationalNumber){
        System.out.println("New international Number with no matching DB pattern found");
        this.internationalNumber=internationalNumber;
    }
}
