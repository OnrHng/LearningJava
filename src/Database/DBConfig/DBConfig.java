package Database.DBConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConfig {

  public static final String DB_NAME = "music.db";
  public static final String CONNECTION_STR = "jdbc:sqlite:C:\\Users\\onur\\Databases\\" + DB_NAME;

  public static final String TABLE_ALBUMS = "albums";
  public static final String COLUMN_ALBUM_ID = "_id";
  public static final String COLUMN_ALBUM_NAME = "name";
  public static final String COLUMN_ALBUM_ARTIST = "artist";
  public static final int INDEX_ALBUM_ID = 1;
  public static final int INDEX_ALBUM_NAME = 2;
  public static final int INDEX_ALBUM_ARTIST = 3;

  public static final String TABLE_ARTISTS = "artists";
  public static final String COLUMN_ARTIST_ID = "_id";
  public static final String COLUMN_ARTIST_NAME = "name";
  public static final int INDEX_ARTIST_ID = 1;
  public static final int INDEX_ARTIST_NAME = 2;

  public static final String TABLE_SONGS = "songs";
  public static final String COLUMN_SONG_ID = "_id";
  public static final String COLUMN_SONG_TRACK = "track";
  public static final String COLUMN_SONG_TITLE = "title";
  public static final String COLUMN_SONG_ALBUM = "album";
  public static final int INDEX_SONG_ID = 1;
  public static final int INDEX_SONG_TRACK = 2;
  public static final int INDEX_SONG_TITLE = 3;
  public static final int INDEX_SONG_ALBUM = 4;

  public static final int ORDER_BY_NONE = 1;
  public static final int ORDER_BY_ASC = 2;
  public static final int ORDER_BY_DESC = 3;

  public static final String QUERY_ALBUMS_BY_ARTIST_START =
          "SELECT " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_NAME + " FROM " + TABLE_ALBUMS +
                  " INNER JOIN " +TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
                  " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
                  " WHERE " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + " = \"";

  public static final String QUERY_ALBUMS_BY_ARTIST_SORT =
          " ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";

  public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";

  public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " +
          TABLE_ARTIST_SONG_VIEW + " AS SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
          TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " AS " + COLUMN_SONG_ALBUM + ", " +
          TABLE_SONGS + "." + COLUMN_SONG_TRACK + ", " + TABLE_SONGS + "." + COLUMN_SONG_TITLE +
          " FROM " + TABLE_SONGS +
          " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS +
          "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
          " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
          " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
          " ORDER BY " +
          TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
          TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
          TABLE_SONGS + "." + COLUMN_SONG_TRACK;

  public static final String QUERY_VIEW_SONG_INFO =  "SELECT " + COLUMN_ARTIST_NAME + ", " +
          COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW +
          " WHERE " + COLUMN_SONG_TITLE + " = \"";

  public static final String QUERY_VIEW_SONG_INFO_PREP = "SELECT " + COLUMN_ARTIST_NAME + ", " +
          COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW +
          " WHERE " + COLUMN_SONG_TITLE + " = ?";

  // SELECT name, album, track FROM artist_list WHERE title = ?

  public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS +
          '(' + COLUMN_ARTIST_NAME + ") VALUES(?)";

  public static final String INSERT_ALBUMS = "INSERT INTO " + TABLE_ALBUMS +
          '(' + COLUMN_ALBUM_NAME + ", " + COLUMN_ALBUM_ARTIST + ") VALUES(?, ?)";

  public static final String INSERT_SONGS = "INSERT INTO " + TABLE_SONGS +
          '(' + COLUMN_SONG_TRACK + ", " + COLUMN_SONG_TITLE + ", " + COLUMN_SONG_ALBUM +
          ") VALUES(?, ?, ?)";

  public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " +
          TABLE_ARTISTS + " WHERE " + COLUMN_ARTIST_NAME + " = ?";

  public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID + " FROM " +
          TABLE_ALBUMS + " WHERE " + COLUMN_ALBUM_NAME + " = ?";

  private Connection connection;
  private PreparedStatement querySongInfoView;

  private PreparedStatement insertIntoArtists;
  private PreparedStatement insertIntoAlbums;
  private PreparedStatement insertIntoSongs;

  private PreparedStatement queryArtist;
  private PreparedStatement queryAlbum;

  public boolean connectDB() {
    try {
      connection = DriverManager.getConnection(CONNECTION_STR);
      querySongInfoView = connection.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);

      insertIntoArtists = connection.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
      insertIntoAlbums = connection.prepareStatement(INSERT_ALBUMS, Statement.RETURN_GENERATED_KEYS);
      insertIntoSongs = connection.prepareStatement(INSERT_SONGS);
      queryArtist = connection.prepareStatement(QUERY_ARTIST);
      queryAlbum = connection.prepareStatement(QUERY_ALBUM);

      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public void closeDBConnection() {
    try {
      if(querySongInfoView != null) querySongInfoView.close();

      if(insertIntoArtists != null) insertIntoArtists.close();
      if(insertIntoAlbums != null) insertIntoAlbums.close();
      if(insertIntoSongs !=  null) insertIntoSongs.close();
      if(queryArtist != null) queryArtist.close();
      if(queryAlbum != null) queryAlbum.close();

      if (connection != null) connection.close();

    }catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public List<Artist> queryArtists(int sortOrder) {

    StringBuilder sb = new StringBuilder("SELECT * FROM ");
    sb.append(TABLE_ARTISTS);
    if(sortOrder != ORDER_BY_NONE) {
      sb.append(" ORDER BY ");
      sb.append(COLUMN_ARTIST_NAME);
      sb.append(" COLLATE NOCASE ");
      if(sortOrder == ORDER_BY_DESC) {
        sb.append("DESC");
      } else {
        sb.append("ASC");
      }
    }

    try(Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(sb.toString())) {

      List<Artist> artists = new ArrayList<>();
      // create an Artist instance and add it to artist array list using loop
      while(results.next()) {
        Artist artist = new Artist();
//        artist.setId(results.getInt(COLUMN_ARTIST_ID));
        artist.setId(results.getInt(INDEX_ARTIST_ID));
//        artist.setName(results.getString(COLUMN_ARTIST_NAME));
        artist.setName(results.getString(INDEX_ARTIST_NAME));
        artists.add(artist);
      }

      return artists;

    } catch(SQLException e) {
      System.out.println("Query failed: " + e.getMessage());
      return null;
    }

  }

  public List<String> queryAlbumsForArtist(String artistName, int sortOrder) {
    StringBuilder sb = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
    sb.append(artistName);
    sb.append("\"");

    if(sortOrder != ORDER_BY_NONE) {
      sb.append(QUERY_ALBUMS_BY_ARTIST_SORT);
      if(sortOrder == ORDER_BY_DESC) {
        sb.append("DESC");
      } else {
        sb.append("ASC");
      }
    }

    System.out.println("SQL statement = " + sb.toString());

    try (Statement statement = connection.createStatement();
         ResultSet results = statement.executeQuery(sb.toString())) {

      List<String> albums = new ArrayList<>();
      while(results.next()) {
        albums.add(results.getString(1));
      }

      return albums;

    } catch(SQLException e) {
      System.out.println("Query failed: "+ e.getMessage());
      return null;
    }
  }

  // get MEta data using jdbc
  public void querySongsMetaData() {
    String sql = "SELECT * FROM " + TABLE_SONGS;

    try (Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(sql)) {

      ResultSetMetaData metaData = resultSet.getMetaData();
      int numColumns = metaData.getColumnCount();
      for (int i = 1; i < numColumns; i++) {
        System.out.printf("Column %d in the songs table is names %s \n", i, metaData.getColumnName(i));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public int getCount(String table) {
    String sql = "SELECT COUNT(*) FROM " + table;

    try (Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(sql)) {
      int count = resultSet.getInt(1);
      return count;

    } catch (SQLException e){
      e.printStackTrace();
      return -1;
    }
  }

  public boolean createViewForSongArtists() {

    try(Statement statement = connection.createStatement()) {

      statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
      return true;

    } catch(SQLException e) {
      System.out.println("Create View failed: " + e.getMessage());
      return false;
    }
  }

  public List<SongArtist> querySongInfoView(String title) {
//    StringBuilder sb = new StringBuilder(QUERY_VIEW_SONG_INFO);
//    sb.append(title);
//    sb.append("\"");
//
//    System.out.println(sb.toString());

    try {
      querySongInfoView.setString(1, title);
      ResultSet results = querySongInfoView.executeQuery();

      List<SongArtist> songArtists = new ArrayList<>();
      while (results.next()) {
        SongArtist songArtist = new SongArtist();
        songArtist.setArtistName(results.getString(1));
        songArtist.setAlbumName(results.getString(2));
        songArtist.setTrack(results.getInt(3));
        songArtists.add(songArtist);
      }

      return songArtists;

    } catch (SQLException e) {
      System.out.println("Query failed: " + e.getMessage());
      return null;
    }
  }

  private int insertArtist (String name)  throws SQLException{
    queryArtist.setString(1, name);
    ResultSet resultSet = queryArtist.executeQuery();

    if (resultSet.next()){
      return resultSet.getInt(1);
    }else {
      // insert the Artist
      insertIntoArtists.setString(1, name);
      int affectedRows= insertIntoArtists.executeUpdate();

      if (affectedRows != 1) {
        throw new SQLException("Couldnt insert artist!");
      }

      ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
      if (generatedKeys.next()){
        return generatedKeys.getInt(1);
      }else{
        throw new SQLException("Couldnt get _id for artist");
      }
    }
  }

  private int insertAlbum (String name, int artistID)  throws SQLException{
    queryAlbum.setString(1, name);
    ResultSet resultSet = queryAlbum.executeQuery();

    if (resultSet.next()){
      return resultSet.getInt(1);
    }else {
      // insert the Artist
      insertIntoAlbums.setString(1, name);
      insertIntoAlbums.setInt(2, artistID);
      int affectedRows= insertIntoAlbums.executeUpdate();

      if (affectedRows != 1) {
        throw new SQLException("Couldnt insert album!");
      }

      ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
      if (generatedKeys.next()){
        return generatedKeys.getInt(1);
      }else{
        throw new SQLException("Couldnt get _id for album");
      }
    }
  }

  public void insertSong (String title, String artist, String album, int track) {
    /*
      1- Turn off the default auto commit behaviour by callling Connection.setAutoCommit(false)

      2- Perform the SQL operations that form the transaction

      3- If there are no errors, call Connection.commit() to commit the changes. If there are errors, call
      Connection.rollBack() to rollback any changes made since the transaction began.

      4- Turn default auto-commit behaviour back on by calling setAutoCommit(true).
    */


    try {
      //1- Turn off the default auto commit behaviour by callling Connection.setAutoCommit(false)
      connection.setAutoCommit(false);

      int artistId = insertArtist(artist);
      int albumId = insertAlbum(album, artistId);

      insertIntoSongs.setInt(1, track);
      insertIntoSongs.setString(2, title);
      insertIntoSongs.setInt(3, albumId);

      //2- Perform the SQL operations that form the transaction
      int affectedRows = insertIntoSongs.executeUpdate();

      if(affectedRows == 1) {
        //If there are no errors, call Connection.commit() to commit the changes.
        connection.commit();
      } else {
        throw new SQLException("The song insert failed");
      }

    } catch(Exception e) {
      System.out.println("Insert song exception: " + e.getMessage());
      try {
        //If there are errors, call
//      Connection.rollBack() to rollback any changes made since the transaction began.
        System.out.println("Performing rollback");
        connection.rollback();
      } catch(SQLException e2) {
        System.out.println("Oh boy! Things are really bad! " + e2.getMessage());
      }
    } finally {
      try {
        //Turn default auto-commit behaviour back on by calling setAutoCommit(true).
        System.out.println("Resetting default commit behavior");
        connection.setAutoCommit(true);
      } catch(SQLException e) {
        System.out.println("Couldn't reset auto-commit! " + e.getMessage());
      }

    }

  }
}
