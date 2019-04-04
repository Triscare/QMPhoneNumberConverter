import java.io.Console;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This will be the class which will read and display the phone numbers
 */
public class View {
    private final static String CHANGE_COUNTRY_CODE = "CountryCode:";
    private Converter converter;
    public View(){
        converter=new Converter();
    }

    /**
     * This will continously read the console and after every new line a formatted Number will be outputted
     * With 'CountryCode:en' the standard country code can be changed. The following signs should be an ISO Country Code
     */
    public void startReading(){
            Console cnsl = null;
            Scanner scan = null;

            try {
                cnsl = System.console();

                if (cnsl != null) {

                    System.out.println("If you want to change the country Code please enter %n 'CountryCode:' %n followed by an ISO Country code like 'de'");

                    scan = new Scanner(cnsl.reader());
                    String number = "";
                    System.out.print("Enter Phone Number : ");
                    //a new String is emitted after every line.seperator (Enter is pressed)
                    Pattern delimiters = Pattern.compile(System.getProperty("line.separator"));
                    scan.useDelimiter(delimiters);
                    //Continuosly scans the Console for new input
                    while (scan.hasNext()) {
                        //Enters when a enter is pressed
                        String str = scan.next();
                        number = str;

                        //Is used for changing the Country Code
                        if(number.startsWith(CHANGE_COUNTRY_CODE)){
                            String[] code = number.split(":");
                            if(code.length == 1){
                                System.out.println("If you want to change the country Code please enter %n 'CountryCode:' %n followed by an ISO Country code like 'de'");
                                System.out.print("Enter Phone Number : ");
                                continue;
                            }
                            System.out.println("CC: " + code[1]);
                            System.out.print("Enter Phone Number : ");
                            continue;
                        }

                        System.out.println("Formatted Number: " + converter.convertPhnoneNumber(number));
                        System.out.print("Enter Phone Number : ");

                    }
                }

            } catch(Exception ex) {
                // if any error occurs
                ex.printStackTrace();
            }
        }
}
