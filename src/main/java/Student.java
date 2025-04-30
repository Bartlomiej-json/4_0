public class Student {

  private String imie;
  private String nazwisko;
  private int wiek;
  private String dataUrodzenia;

  // Konstruktor
  public Student(String imie, String nazwisko, int wiek, String dataUrodzenia) {
    this.imie = imie;
    this.nazwisko = nazwisko;
    this.wiek = wiek;
    this.dataUrodzenia = dataUrodzenia;
  }

  // Gettery
  public String getImie() { return imie; }
  public String getNazwisko() { return nazwisko; }
  public int getWiek() { return wiek; }
  public String getDataUrodzenia() { return dataUrodzenia; }

  // Metoda toString do zapisu do pliku i wyświetlania
  @Override
  public String toString() {
    return imie + " " + nazwisko + " " + wiek + " " + dataUrodzenia;
  }

  // Metoda do wczytywania studenta z linii tekstu
  public static Student parsuj(String linia) {
    String[] dane = linia.split(" ");
    if (dane.length != 4) {
      return new Student("Błąd", "Parsowania", -1, "0000-00-00");
    }
    return new Student(dane[0], dane[1], Integer.parseInt(dane[2]), dane[3]);
  }
}
