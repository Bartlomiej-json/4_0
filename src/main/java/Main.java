import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();  // Instancja klasy Service
      Scanner scanner = new Scanner(System.in);

      while (true) {
        System.out.println("Wybierz opcję:  \n");
        System.out.println("1. Dodaj studenta");
        System.out.println("2. Wyświetl wszystkich studentów");
        System.out.println("3. Zakończ \n");

        int wybor = Integer.parseInt(scanner.nextLine());

        switch (wybor) {
          case 1:
            // Dodawanie studenta
            System.out.print("Podaj imię studenta: ");
            String imie = scanner.nextLine();

            System.out.print("Podaj nazwisko studenta: ");
            String nazwisko = scanner.nextLine();  // Nowe pytanie o nazwisko

            System.out.print("Podaj wiek studenta: ");
            int wiek = Integer.parseInt(scanner.nextLine());

            // Tworzenie nowego studenta z imieniem, nazwiskiem i wiekiem
            s.addStudent(new Student(imie, nazwisko, wiek));
            System.out.println("Student dodany!");
            break;

          case 2:
            // Wyświetlanie wszystkich studentów
            var students = s.getStudents();
            if (students.isEmpty()) {
              System.out.println("Brak studentów w bazie.");
            } else {
              for (Student current : students) {
                System.out.println(current.ToString());  // Wyświetlanie pełnych danych studenta
              }
            }
            break;

          case 3:
            // Zakończenie programu
            System.out.println("Zakończono program.");
            scanner.close();
            return;  // Zakończenie programu

          default:
            System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
        }
      }
    } catch (IOException e) {
      System.out.println("Błąd operacji na pliku: " + e.getMessage());
    }
  }
}