public class Main {

    public static void main(String[] args) {
        Converter converter= new Converter();
        View view = new View(converter);
        view.startReading();
    }
}
