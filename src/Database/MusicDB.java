package Database;

import Database.DBConfig.Artist;
import Database.DBConfig.DBConfig;
import Database.DBConfig.DBConfigWithEnum;
import Database.DBConfig.SongArtist;

import java.util.ArrayList;
import java.util.List;

public class MusicDB {

  public static void main(String[] args) {
    DBConfig dbConfig = new DBConfig();
    DBConfigWithEnum dbConfigWithEnum = DBConfigWithEnum.INSTANCE;
    if (!dbConfig.connectDB()) {
      System.out.println("Can not connected DB");
      return;
    } else {
      System.out.println("CONNECTED DB");
    }

    // get data of artists
    List<Artist> artists = dbConfig.queryArtists(3);
//    dbConfigWithEnum.open();
//    List<Artist> artists = dbConfigWithEnum.queryArtists(DBConfigWithEnum.ORDER.ORDER_BY_ASC);

    if(artists == null) {
      System.out.println("No artists!");
      return;
    }

    // write all artists on console.
    for(Artist artist : artists) {
      //System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
    }

    List<String> albumsForArtist = dbConfig.queryAlbumsForArtist("Pink Floyd", DBConfig.ORDER_BY_DESC);

    for (String album : albumsForArtist) {
      System.out.println(album);
    }

    dbConfig.querySongsMetaData();

    // see count of table e.g songs
    int count = dbConfig.getCount(DBConfig.TABLE_SONGS);
    System.out.printf("Count of Table %d \n" , count);

    dbConfig.createViewForSongArtists();

    List<SongArtist> songArtists = dbConfig.querySongInfoView("She's On Fire");
    if(songArtists.isEmpty()) {
      System.out.println("Couldn't find the artist for the song");
      return;
    }

    for(SongArtist artist : songArtists) {
      System.out.println("FROM VIEW - Artist name = " + artist.getArtistName() +
              " Album name = " + artist.getAlbumName() +
              " Track number = " + artist.getTrack());
    }

    dbConfigWithEnum.close();
    dbConfig.closeDBConnection();
    System.out.println("ClOSED DB CONNECTION");
  }
}
