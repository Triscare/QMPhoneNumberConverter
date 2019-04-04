public class main {

    public static void main(String[] args) {
        View view = new View();
        view.startReading();
        Converter converter = new Converter();
        converter.convertPhnoneNumber("+3554 1111111");
    }
}
