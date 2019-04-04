import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import java.util.Locale;

public class Converter {

    private PhoneNumberUtil phoneNumberUtil;
    private String[] locales;

    public Converter(){
        phoneNumberUtil=PhoneNumberUtil.getInstance();

        locales = Locale.getISOCountries();

    }

    public PhoneNumber convertPhnoneNumber(String phoneNumber){

        try {
            Phonenumber.PhoneNumber tempNumber;
            if(phoneNumber.startsWith("+"))
                tempNumber=phoneNumberUtil.parse(phoneNumber,"");
            else if (phoneNumber.startsWith("00")){
                phoneNumber="+"+phoneNumber.substring(2);
                tempNumber=phoneNumberUtil.parse(phoneNumber,"");
            }
            else {
                tempNumber=phoneNumberUtil.parse(phoneNumber, Config.defaultCountryCode);
            }

            String intNumber=phoneNumberUtil.format(tempNumber, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);

            System.out.println(intNumber);
            String[] splited = intNumber.split("\\s+");

            if(splited.length==3) {
                System.out.println(phoneNumberUtil.getRegionCodeForCountryCode(Integer.valueOf(splited[0].toString().substring(1))));
                return new PhoneNumber(splited[0], splited[1], splited[2]);
            }
            if(splited.length==4)
                return new PhoneNumber(splited[0], splited[1], splited[2], splited[3]);


        } catch (NumberParseException e) {
            e.printStackTrace();
        }



        return null;
    }

}
