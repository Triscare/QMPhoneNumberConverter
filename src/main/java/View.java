import java.io.Console;
import java.util.Scanner;
import java.util.regex.Pattern;

public class View {
    private final static String CHANGE_COUNTRY_CODE = "CountryCode:";
    public View(){}

    public void startReading(){
            Console cnsl = null;
            Scanner scan = null;

            try {
                // creates a console object
                cnsl = System.console();

                // if console is not null
                if (cnsl != null) {

                    System.out.println("If you want to change the country Code please enter %n 'CountryCode:' %n followed by an ISO Country code like 'de'");

                    // prints

                    // create new scanner object
                    scan = new Scanner(cnsl.reader());
                    String number = "";
                    // read till the end of data
                    System.out.print("Enter Phone Number : ");
                    Pattern delimiters = Pattern.compile(System.getProperty("line.separator")+"|\\s");
                    scan.useDelimiter(delimiters);
                    //TODO Space signs will split the String somehow.

                    while (scan.hasNext()) {
                        // read next
                        String str = scan.next();
                        number = str;
                        if(number.startsWith(CHANGE_COUNTRY_CODE)){
                            String[] code = number.split(":");
                            if(code.length == 1){
                                System.out.println("If you want to change the country Code please enter %n 'CountryCode:' %n followed by an ISO Country code like 'de'");
                                System.out.print("Enter Phone Number : ");
                                continue;
                            }
                            System.out.println("CC: " + code[1]);
                            System.out.print("Enter Phone Number : ");
                            number = "";
                            str = "";
                            continue;
                        }
                        System.out.println("Full Number found: " + number);
                        System.out.print("Enter Phone Number : ");
                        str = "";
                        number = "";

                    }
                }

            } catch(Exception ex) {
                // if any error occurs
                ex.printStackTrace();
            }
        }
}
