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

      System.out.print("Podaj imię studenta: ");
      String imie = scanner.nextLine();

      System.out.print("Podaj wiek studenta: ");
      int wiek = Integer.parseInt(scanner.nextLine());

      s.addStudent(new Student(imie, wiek));

      System.out.println("Student dodany!");
      scanner.close();

      var students = s.getStudents();
      for (Student current : students) {
        System.out.println(current.ToString());
      }
    } catch (IOException e) {
      System.out.println("Błąd operacji na pliku: " + e.getMessage());
    }
  }
}