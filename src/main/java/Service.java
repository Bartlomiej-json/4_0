import java.util.Collection;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Service {

  // Dodaje studenta do pliku
  public void addStudent(Student student) throws IOException {
    var f = new FileWriter("db.txt", true);
    var b = new BufferedWriter(f);
    b.append(student.toString());
    b.newLine();
    b.close();
  }

  // Wczytuje wszystkich studentów z pliku
  public Collection<Student> getStudents() throws IOException {
    var ret = new ArrayList<Student>();
    var f = new FileReader("db.txt");
    var reader = new BufferedReader(f);
    String line;
    while ((line = reader.readLine()) != null) {
      ret.add(Student.parsuj(line));
    }
    reader.close();
    return ret;
  }

  // Metoda do wyszukiwania studenta po imieniu
  public Student findStudentByName(String name) {
    try {
      // Wczytanie studentów
      Collection<Student> students = getStudents();

      // Przeszukiwanie kolekcji studentów i zwrócenie pierwszego pasującego
      for (Student student : students) {
        if (student.getImie().equalsIgnoreCase(name)) {
          return student;  // Zwrócenie pierwszego studenta o podanym imieniu
        }
      }
    } catch (IOException e) {
      System.out.println("Błąd przy wczytywaniu studentów: " + e.getMessage());
    }

    // Jeśli student o podanym imieniu nie został znaleziony, zwróć null
    return null;
  }
}
