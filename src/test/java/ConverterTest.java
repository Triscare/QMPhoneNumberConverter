import com.google.i18n.phonenumbers.NumberParseException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ConverterTest {

    private String[] sArray = {"+49 0201 123456","+44 0201123456","0033 0201/123456","0049201123456","(0)201 1234 56","+49 (941) 790-4780",
            "015115011900","+91 09870987 899","[+49] (0)89-800/849-50","+49 (8024) [990-477]"};
    private String[] sArrayFail = {"Fail","21312378127497123712312387"};

    private String[] sArrayCorrectFormated={"+49 201 123456","+44 201123456","+33 2 01 12 34 56","+49 201 123456","+49 201 123456","+49 941 7904780","+49 1511 5011900","+91 98709 87899","+49 89 80084950","+49 8024 990477"};

    @Test
    public void convertPhoneNumber() {
    Converter converter = new Converter();

        for (String phoneNumber: sArray) {
            PhoneNumber testNumber = converter.convertPhoneNumber(phoneNumber);
            Assert.assertNotNull(testNumber);
        }

    }

    @Test
    public void convertPhoneNumberFail() {
        Converter converter = new Converter();

        for (String phoneNumber: sArrayFail) {
            PhoneNumber testNumber = converter.convertPhoneNumber(phoneNumber);
            Assert.assertNull(testNumber);
        }
    }

    @Test
    public void checkIfNumberIsValid(){
        Converter converter = new Converter();
        String[] pList= new String[sArray.length];
        int i =0;

        for (String phoneNumber: sArray) {
            PhoneNumber testNumber = converter.convertPhoneNumber(phoneNumber);
            pList[i]=testNumber.getInternationalNumber();
            i++;
        }
        Assert.assertArrayEquals(sArrayCorrectFormated, pList);
    }
}