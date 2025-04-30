import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service serwis = new Service();  // Poprawiona nazwa instancji
      Scanner scanner = new Scanner(System.in);

      while (true) {
        System.out.println("Wybierz opcję:");
        System.out.println("1. Dodaj studenta");
        System.out.println("2. Wyświetl wszystkich studentów");
        System.out.println("3. Zakończ");

        int wybor = Integer.parseInt(scanner.nextLine());

        switch (wybor) {
          case 1:
            System.out.print("Podaj imię studenta: ");
            String imie = scanner.nextLine();

            System.out.print("Podaj nazwisko studenta: ");
            String nazwisko = scanner.nextLine();

            System.out.print("Podaj wiek studenta: ");
            int wiek = Integer.parseInt(scanner.nextLine());

            System.out.print("Podaj datę urodzenia (format: RRRR-MM-DD): ");
            String dataUrodzenia = scanner.nextLine();

            if (!czyPoprawnaData(dataUrodzenia)) {
              System.out.println("Nieprawidłowa data. Student nie został dodany.");
              break;
            }

            serwis.addStudent(new Student(imie, nazwisko, wiek, dataUrodzenia));
            System.out.println("Student został dodany!");
            break;

          case 2:
            var studenci = serwis.getStudents();
            if (studenci.isEmpty()) {
              System.out.println("Brak studentów w bazie.");
            } else {
              for (Student student : studenci) {
                System.out.println(student.toString());
              }
            }
            break;

          case 3:
            System.out.println("Zakończono program.");
            scanner.close();
            return;

          default:
            System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
        }
      }
    } catch (IOException e) {
      System.out.println("Błąd operacji na pliku: " + e.getMessage());
    }
  }

  public static boolean czyPoprawnaData(String data) {
    String[] czesci = data.split("-");
    if (czesci.length != 3) return false;

    try {
      int rok = Integer.parseInt(czesci[0]);
      int miesiac = Integer.parseInt(czesci[1]);
      int dzien = Integer.parseInt(czesci[2]);

      return (rok >= 1 && rok <= 3000) &&
             (miesiac >= 1 && miesiac <= 12) &&
             (dzien >= 1 && dzien <= 31);
    } catch (NumberFormatException e) {
      return false;
    }
  }
}