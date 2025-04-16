/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      while (true) {
        System.out.println("Wybierz opcję:  " );
        System.out.println("1. Dodaj studenta");
        System.out.println("2. Wyświetl wszystkich studentów");
        System.out.println("3. Zakończ");

        int wybor = Integer.parseInt(scanner.nextLine());

        switch (wybor) {
          case 1:
            System.out.print("Podaj imię studenta: ");
            String imie = scanner.nextLine();

            System.out.print("Podaj wiek studenta: ");
            int wiek = Integer.parseInt(scanner.nextLine());

            s.addStudent(new Student(imie, wiek));
            System.out.println("Student dodany!");
            break;

          case 2:
            var students = s.getStudents();
            if (students.isEmpty()) {
              System.out.println("Brak studentów w bazie.");
            } else {
              for (Student current : students) {
                System.out.println(current.ToString());
              }
            }
            break;

          case 3:
            System.out.println("Zakończono program.");
            scanner.close();
            return; // Zakończenie programu

          default:
            System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
        }
      }
    } catch (IOException e) {
      System.out.println("Błąd operacji na pliku: " + e.getMessage());
    }
  }
}