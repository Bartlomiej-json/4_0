public class Student {

  private String Name;
  private String Surname;  // Nowe pole dla nazwiska
  private int Age;

  // Zaktualizowany konstruktor
  public Student(String name, String surname, int age) {
    Name = name;
    Surname = surname;
    Age = age;
  }

  // Gettery dla imienia, nazwiska i wieku
  public String GetName() { return Name; }
  public String GetSurname() { return Surname; }  // Getter dla nazwiska
  public int GetAge() { return Age; }

  // Zaktualizowana metoda ToString() z nazwiskiem
  public String ToString() {
    return Name + " " + Surname + " " + Integer.toString(Age);
  }

  // Zaktualizowana metoda Parse() do przetwarzania imienia, nazwiska i wieku
  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length != 3)  // Oczekujemy imienia, nazwiska i wieku
      return new Student("Parse Error", "Parse Error", -1);
    return new Student(data[0], data[1], Integer.parseInt(data[2]));
  }
}