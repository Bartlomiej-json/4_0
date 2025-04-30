import java.util.Collection;
import java.util.ArrayList;
import java.io.*;

public class Service {

  public void addStudent(Student student) throws IOException {
    var b = new BufferedWriter(new FileWriter("db.txt", true));
    b.write(student.toString());
    b.newLine();
    b.close();
  }

  public Collection<Student> getStudents() throws IOException {
    var lista = new ArrayList<Student>();
    var reader = new BufferedReader(new FileReader("db.txt"));
    String line;
    while ((line = reader.readLine()) != null) {
      lista.add(Student.parsuj(line));
    }
    reader.close();
    return lista;
  }

  public Student findStudentByName(String name) {
    try {
      for (Student s : getStudents()) {
        if (s.getImie().equalsIgnoreCase(name)) {
          return s;
        }
      }
    } catch (IOException e) {
      System.out.println("Błąd odczytu bazy danych.");
    }
    return null;
  }

  public void removeStudent(String imie, String nazwisko) throws IOException {
    var wszyscy = new ArrayList<Student>(getStudents());
    var pozostali = new ArrayList<Student>();

    boolean usunieto = false;
    for (Student s : wszyscy) {
      if (!usunieto && s.getImie().equalsIgnoreCase(imie) && s.getNazwisko().equalsIgnoreCase(nazwisko)) {
        usunieto = true; // usuwa tylko pierwsze dopasowanie
        continue;
      }
      pozostali.add(s);
    }

    if (usunieto) {
      var writer = new BufferedWriter(new FileWriter("db.txt", false));
      for (Student s : pozostali) {
        writer.write(s.toString());
        writer.newLine();
      }
      writer.close();
      System.out.println("Student " + imie + " " + nazwisko + " został usunięty.");
    } else {
      System.out.println("Nie znaleziono studenta o imieniu i nazwisku: " + imie + " " + nazwisko);
    }
  }
}
