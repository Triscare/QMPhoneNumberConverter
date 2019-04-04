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
            System.out.printf(getCountryCode(phoneNumber));
            Phonenumber.PhoneNumber tempNumber=phoneNumberUtil.parse(phoneNumber, Config.defaultCountryCode);
            String intNumber=phoneNumberUtil.format(tempNumber, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);

            System.out.println(intNumber);
            String[] splited = intNumber.split("\\s+");

            if(splited.length==3)
                return new PhoneNumber(splited[0], splited[1], splited[2]);
            if(splited.length==4)
                return new PhoneNumber(splited[0], splited[1], splited[2], splited[3]);


        } catch (NumberParseException e) {
            e.printStackTrace();
        }



        return null;
    }

    private String getCountryCode(String phoneNumber){

        if(phoneNumber.startsWith("+")){
            String tempTwo=String.valueOf(phoneNumber.charAt(1))+String.valueOf(phoneNumber.charAt(2));
            String tempThree=String.valueOf(phoneNumber.charAt(1))+String.valueOf(phoneNumber.charAt(2))+String.valueOf(phoneNumber.charAt(3));
            int alphaTwo=Integer.valueOf(tempTwo);
            int alphaThree=Integer.valueOf(tempThree);

            System.out.println(CountryCode.getByCode(tempTwo));
            if(CountryCode.getByCode(alphaThree)!=null)
                return CountryCode.getByCode(alphaThree).getAlpha3();

            if(CountryCode.getByCode(alphaTwo)!=null){
                return CountryCode.getByCode(alphaTwo).getAlpha2();
            }
        }
        if(phoneNumber.startsWith("00")){

        }
        if(phoneNumber.startsWith("0")){

        }
       return "Test";
    }
}
