package Database.DBConfig;

public class Artist {

  private int id;
  private String name;

  public Artist() {

  }

  public Artist(int artistID, String artistName) {
    this.id = artistID;
    this.name = artistName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
