package ListsAutoboxingUnboxing.List.LinkedList;

import java.util.*;

public class MainForSong {

  private static ArrayList<Album> albums = new ArrayList<>();

  public static void main(String[] args) {
    Album album = new Album("Vermem Seni Ellere", "Kutay");
    album.addSong("Dahi Bakalim", 2.33);
    album.addSong("Dahi Bakalim1", 2.21);
    album.addSong("Dahi Bakalim2", 4.12);
    album.addSong("Dahi Bakalim3", 3.33);

    albums.add(album);

    album = new Album("Time to Song", "Michael Jackson");

    album.addSong("ABC", 2.21);
    album.addSong("DEF", 4.12);
    album.addSong("Go away", 3.33);
    albums.add(album);


    LinkedList<Song> playList = new LinkedList<>();
    albums.get(0).addToPlayList("Dahi Bakalim", playList);
    albums.get(0).addToPlayList("Dahi Bakalim2", playList);
    albums.get(1).addToPlayList("Go away", playList);

    play(playList);
  }

  private static void play(LinkedList<Song> playList) {
    Scanner scanner = new Scanner(System.in);

    boolean quit = false;
    boolean forward = true;

    ListIterator<Song> listIterator = playList.listIterator();

    if (playList.size() == 0) {
      System.out.println("No song in playlist");
      return;
    }else {
      System.out.println("Playing " + listIterator.next().toString());
      printMenu();
    }

    while(!quit) {
      int action = scanner.nextInt();
      scanner.nextLine();

      switch (action) {
        case 0:
          System.out.println("Playlist Complete");
          quit =true;
          break;
        case 1:
          if (!forward && listIterator.hasNext()) {
            listIterator.hasNext();
          }
          forward = true;
          if (listIterator.hasNext()) {
            System.out.println("Playing " + listIterator.next().toString());

          } else {
            System.out.println("We have reached the end of playlist");
            forward = false;
          }
          break;

        case 2:
          if (forward && listIterator.hasPrevious()){
            listIterator.previous();
          }
          if (listIterator.hasPrevious()){
            System.out.println("Now playing " + listIterator.previous().toString() );
          }else {
            System.out.println("We are at the start of the playlist");
            forward = true;
          }
          break;
        case 3:
          if (forward) {
            if ( listIterator.hasPrevious()){
              System.out.println("Now playing " + listIterator.previous().toString());
            }else {
              System.out.println("We are at the start of the List");
             }
          }else {
            if (listIterator.hasNext()) {
              System.out.println("Now replaying " +  listIterator.next().toString());
              forward = true;
            }else {
              System.out.println("We have reached the end of List");
            }
          }

          break;
        case 4:
          printList(playList);
          break;
        case 5:
          printMenu();
          break;

      }
    }
  }

  private static void printMenu() {
    System.out.println("Available actions:\npress ");
    System.out.println("0 - to quit\n" +
            "1 - play next song\n" +
            "2 - play previous song\n" +
            "3 - to replay current song\n" +
            "4 - list songs in the playlist\n" +
            "5 - print available action");
  }

  private static void printList(LinkedList<Song> playList) {
    Iterator<Song> iterator = playList.iterator();
    System.out.println("================");
    while (iterator.hasNext()){
      System.out.println(iterator.next());

    }
    System.out.println("===================");
  }
}
