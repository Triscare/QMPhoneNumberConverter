import org.junit.Assert;

import static org.junit.Assert.*;

public class ConverterTest {

    private String[] sArray = {"+49 0201 123456","+44 0201123456","0033 0201/123456","0049201123456","(0)201 1234 56","+49 (941) 790-4780",
            "015115011900","+91 09870987 899","[+49] (0)89-800/849-50","+49 (8024) [990-477]"};
    private String[] sArrayFail = {"Fail","21312378127497123712312387"};

    @org.junit.Test
    public void convertPhoneNumber() {
    Converter converter = new Converter();

        for (String phoneNumber: sArray) {
            PhoneNumber testNumber = converter.convertPhoneNumber(phoneNumber);
            Assert.assertNotNull(testNumber);
        }

    }

    @org.junit.Test
    public void convertPhoneNumberFail() {
        Converter converter = new Converter();

        for (String phoneNumber: sArrayFail) {
            PhoneNumber testNumber = converter.convertPhoneNumber(phoneNumber);
            Assert.assertNull(testNumber);
        }

    }
}