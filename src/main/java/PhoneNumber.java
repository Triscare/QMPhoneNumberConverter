import lombok.Data;

/**
 * Data class for storing the converted phone numbers.
 */
@Data
public class PhoneNumber {

    /**
     * Country code of a number
     */
    private String countryCode;
    /**
     * Area code of a number
     */
    private String areaCode;
    /**
     * The direct number of a phone number
     */
    private String number;
    /**
     * The direct dialing of a number
     */
    private String directDialing;

    /**
     * If the converted number does not match the db pattern, the whole number gets stored in this field.
     */
    private String internationalNumber;

    private PhoneNumber(){}

    /**
     * Constructor for Number without direct dialing
     * @param countryCode Country code of a number
     * @param areaCode Area code of a number
     * @param number The direct number of a phone number
     */
    public PhoneNumber(String countryCode, String areaCode, String number){
        System.out.println("New number without direct dialing");
        this.countryCode=countryCode;
        this.areaCode=areaCode;
        this.number=number;
    }

    /**
     * Constructor for Number without direct dialing
     * @param countryCode Country code of a number
     * @param areaCode Area code of a number
     * @param number The direct number of a phone number
     * @param directDialing The direct dialing of a number
     */
    public PhoneNumber(String countryCode, String areaCode, String number, String directDialing){
        System.out.println("New number with direct dialing");
        this.countryCode=countryCode;
        this.areaCode=areaCode;
        this.number=number;
        this.directDialing=directDialing;
    }

    /**
     * Constructor for Number without db pattern match
     * @param internationalNumber the whole international Number
     */
    public PhoneNumber(String internationalNumber){
        System.out.println("New international Number with no matching DB pattern found");
        this.internationalNumber=internationalNumber;
    }
}
