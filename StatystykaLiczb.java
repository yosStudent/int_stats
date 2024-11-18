public class StatystykaLiczb {
    public static void main(String[] args) throws java.io.IOException {
        int suma = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int licznikParzystych = 0;
        int licznik = 0;
        char odpowiedz;

        System.out.println("Wprowadź liczby. Po każdej liczbie zapytamy, czy chcesz kontynuować.");

        do {
            System.out.print("Podaj liczbę: ");
            int liczba = wczytajLiczbe();

            suma += liczba;
            if (liczba > max) max = liczba;
            if (liczba < min) min = liczba;
            if (liczba % 2 == 0) licznikParzystych++;
            licznik++;

            System.out.print("Czy koniec wprowadzania (t/n)? ");
            odpowiedz = (char) System.in.read();

            while (System.in.read() != '\n') System.in.read();

        } while (odpowiedz == 'n' || odpowiedz == 'N');

        if (licznik == 0) {
            System.out.println("Nie podano żadnych liczb.");
        } else {
            double srednia = (double) suma / licznik;

            System.out.println("Statystyki wprowadzonych liczb:");
            System.out.println("Suma wszystkich liczb: " + suma); //dodałem od siebie :)
            System.out.println("Średnia: " + srednia);
            System.out.println("Maksymalna: " + max);
            System.out.println("Minimalna: " + min);
            System.out.println("Ilość liczb parzystych: " + licznikParzystych);
        }
    }

    private static int wczytajLiczbe() throws java.io.IOException {
        int liczba = 0;
        boolean poprawna = false;

        while (!poprawna) {
            liczba = 0;
            boolean ujemna = false;
            char znak = (char) System.in.read();

            if (znak == '-') {
                ujemna = true;
                znak = (char) System.in.read();
            }

            while (znak >= '0' && znak <= '9') {
                liczba = liczba * 10 + (znak - '0');
                znak = (char) System.in.read();
            }

            if (znak == '\n' || znak == '\r') {
                poprawna = true;
                if (ujemna) liczba = -liczba;
            } else {
                System.out.println("To nie jest poprawna liczba! Spróbuj ponownie.");
                while (System.in.read() != '\n') System.in.read();
            }
        }
        return liczba;
    }
}
