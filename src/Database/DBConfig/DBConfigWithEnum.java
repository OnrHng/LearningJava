package Database.DBConfig;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public enum DBConfigWithEnum {
  INSTANCE;

  private enum CONNECTIONS {
    DB_NAME("music.db"),
    DB_Connection("jdbc:sqlite:C:\\Users\\onur\\Databases\\" + DB_NAME);
    private final String value;

    CONNECTIONS(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }

  private enum TABLES {
    ALBUMS("albums"),
    ARTISTS("artists"),
    SONGS("songs");
    private final String value;

    TABLES(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }

  private enum COLUMNS {
    ALBUMS_ID(TABLES.ALBUMS + "._id", 1),
    ALBUMS_NAME(TABLES.ALBUMS + ".name", 2),
    ALBUMS_ARTIST(TABLES.ALBUMS + ".artist", 3),


    ARTISTS_ID(TABLES.ARTISTS + "._id", 1),
    ARTISTS_NAME(TABLES.ARTISTS + ".name", 2),

    SONGS_ID(TABLES.SONGS + "._id", 1),
    SONGS_TRACK(TABLES.SONGS + ".track", 2),
    SONGS_TITLE(TABLES.SONGS + ".title", 3),
    SONGS_ALBUM(TABLES.SONGS + ".album", 4);
    private final String value;
    private final int index;

    COLUMNS(String value, int index) {
      this.index = index;
      this.value = value;
    }

    public int getIndex() {
      return index;
    }

    @Override
    public String toString() {
      return value;
    }
  }

  private enum QUERY {
    ALBUMS("SELECT * FROM " + TABLES.ALBUMS),
    ARTISTS("SELECT * FROM " + TABLES.ARTISTS),
    SONGS("SELECT * FROM " + TABLES.SONGS),
    ALBUMS_BY_ARTIST_START("SELECT " + COLUMNS.ALBUMS_NAME + " FROM " + TABLES.ALBUMS + " INNER JOIN " +
            TABLES.ARTISTS + " ON " + COLUMNS.ALBUMS_ARTIST + " = " + COLUMNS.ARTISTS_ID + " WHERE " + COLUMNS.ARTISTS_NAME + " LIKE \"%");
    private String value;

    QUERY(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }

  public enum ORDER {
    ORDER_BY_NON(1, ""),
    ORDER_BY_ASC(2, " COLLATE NOCASE ASC"),
    ORDER_BY_DESC(3, " COLLATE NOCASE DESC");
    private final int number;
    private final String value;

    ORDER(int number, String value) {
      this.number = number;
      this.value = value;
    }

    public int getNumber() {
      return number;
    }

    @Override
    public String toString() {
      return value;
    }
  }

  private Connection connection;

  public boolean open() {
    try {
      connection = DriverManager.getConnection(CONNECTIONS.DB_Connection.toString());
      return true;
    } catch (SQLException e) {
      System.out.println("something go wrong in opening connection " + e.getMessage());
      e.printStackTrace();
      return false;
    }
  }

  public boolean close() {
    try {
      if (connection != null) {
        connection.close();
      }
      return true;
    } catch (SQLException e) {
      System.out.println("something go wrong in Closing connection " + e.getMessage());
      e.printStackTrace();
      return false;
    }
  }


  public List<Artist> queryArtists(ORDER order) {
    StringBuilder builder = new StringBuilder(QUERY.ARTISTS.toString());

    orderBy(builder, COLUMNS.ARTISTS_NAME, order);

    try (Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(builder.toString())) {
      List<Artist> result = new LinkedList<>();
      while (resultSet.next()) {
        result.add(new Artist(
                resultSet.getInt(COLUMNS.ARTISTS_ID.getIndex()),
                resultSet.getString(COLUMNS.ARTISTS_NAME.getIndex())
        ));
      }
      return result;
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
      return null;
    }
  }

  public List<String> queryAlbumsForArtist(String artistName, ORDER order) {
    final int columnPosition = 1;
    StringBuilder builder = new StringBuilder();
    builder.append(QUERY.ALBUMS_BY_ARTIST_START);
    builder.append(artistName + "%\"");

    orderBy(builder, COLUMNS.ARTISTS_NAME, order);

    try (Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(builder.toString())) {
      List<String> result = new LinkedList<>();
      while (resultSet.next()) {
        result.add(resultSet.getString(columnPosition));
      }
      return result;

    } catch (SQLException e) {
      System.out.println("Something go wrong " + e.getMessage());
      e.printStackTrace();
      throw new NullPointerException();
    }
  }

  private static StringBuilder orderBy(StringBuilder builder, COLUMNS baseOn, ORDER order) {
    if (order != ORDER.ORDER_BY_NON) {
      builder.append(" ORDER BY ").append(baseOn.toString()).append(order);
    }
    return builder;
  }



}