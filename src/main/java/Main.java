import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service serwis = new Service();
      Scanner scanner = new Scanner(System.in);

      while (true) {
        System.out.println("\nWybierz opcję:");
        System.out.println("1. Dodaj studenta");
        System.out.println("2. Wyświetl wszystkich studentów");
        System.out.println("3. Wyszukaj studenta po imieniu");
        System.out.println("4. Usuń studenta po imieniu i nazwisku");
        System.out.println("5. Zakończ");

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
              for (Student s : studenci) {
                System.out.println(s.toString());
              }
            }
            break;

          case 3:
            System.out.print("Podaj imię studenta do wyszukania: ");
            String szukaneImie = scanner.nextLine();
            Student znaleziony = serwis.findStudentByName(szukaneImie);
            if (znaleziony != null) {
              System.out.println("Znaleziono: " + znaleziony);
            } else {
              System.out.println("Nie znaleziono studenta o imieniu: " + szukaneImie);
            }
            break;

          case 4:
            System.out.print("Podaj imię studenta do usunięcia: ");
            String imieDoUsuniecia = scanner.nextLine();
            System.out.print("Podaj nazwisko studenta do usunięcia: ");
            String nazwiskoDoUsuniecia = scanner.nextLine();
            serwis.removeStudent(imieDoUsuniecia, nazwiskoDoUsuniecia);
            break;

          case 5:
            System.out.println("Zakończono program.");
            scanner.close();
            return;

          default:
            System.out.println("Nieprawidłowy wybór.");
        }
      }
    } catch (IOException e) {
      System.out.println("Błąd pliku: " + e.getMessage());
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
