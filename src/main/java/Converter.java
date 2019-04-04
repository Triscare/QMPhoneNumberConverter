import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

/**
 * The Controller class, which converts a non standard phone number into an standard international number.
 */
public class Converter {

    /**
     * Instance of the phoneNumber library
     */
    private PhoneNumberUtil phoneNumberUtil;

    /**
     * Constructor, which initialize the phoneNumber library
     */
    public Converter(){
        phoneNumberUtil=PhoneNumberUtil.getInstance();
    }

    /**
     * Converts a given non standard phone number into an standard intenational number.
     * @param phoneNumber the phoneNumber as String
     * @return A PhoneNumber Object, which contains the separate Codes like country-code or area-code
     */
    public PhoneNumber convertPhoneNumber(String phoneNumber){

        //Deletes all spaces of the String
        phoneNumber.replaceAll("\\s+","");

        try {
            Phonenumber.PhoneNumber tempNumber;
            if(phoneNumber.startsWith("+")) //if the number starts with a '+', the phoneNumber library defines the country automatically

                tempNumber=phoneNumberUtil.parse(phoneNumber,"");

            else if (phoneNumber.startsWith("00")){ //if the number starts with '00', the two zeros gets replaced by a '+' and the same algorithm as before gets called

                phoneNumber="+"+phoneNumber.substring(2);
                tempNumber=phoneNumberUtil.parse(phoneNumber,"");

            }
            else { //if the number starts with anything else than before checked, the default countryCode is used
                tempNumber=phoneNumberUtil.parse(phoneNumber, Config.defaultCountryCode);
            }

            //TODO direct dial

            //Converts the phoneNumber
            String intNumber=phoneNumberUtil.format(tempNumber, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);

            String[] splited = intNumber.split("\\s|\\-");

            //Gets the countryCode as String
            String ISOCountryCode=phoneNumberUtil.getRegionCodeForCountryCode(Integer.valueOf(splited[0].toString().substring(1)));

            //if the converted phone number has 3 substring, this db-pattern is called
            if(splited.length==3) {
                return new PhoneNumber(splited[0], splited[1], splited[2], intNumber, ISOCountryCode);
            }
            //else the number is written into the internationalNumber field
            return new PhoneNumber(intNumber, ISOCountryCode);
        } catch (NumberParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
