package JavaCollections.BinarySearch.TheaterSeatBooking;

import java.util.ArrayList;
import java.util.List;

public class Theater {
  private final String theaterName;
  public List<Seat> seats = new ArrayList<>();

  public Theater(String theatreName, int numRows, int seatsPerRow) {
    this.theaterName = theatreName;

    int lastRow = 'A' + (numRows -1);
    for (char row = 'A'; row <= lastRow; row++) {
      for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
        Seat seat = new Seat(row + String.format("%02d", seatNum));
        seats.add(seat);
      }
    }
  }

  public String getTheaterName() {
    return theaterName;
  }

  public boolean reserveSeat(String seatNumber) {
    int low = 0;
    int high = seats.size()-1;

    while (low <= high) {
      System.out.print(".");
      int mid = (low + high) / 2;
      Seat midVal = seats.get(mid);
      int cmp = midVal.getSeatNumber().compareTo(seatNumber);

      if (cmp < 0) {
        low = mid + 1;
      } else if (cmp > 0) {
        high = mid - 1;
      } else {
        return seats.get(mid).reserve();
      }
    }
    System.out.println("There is no seat " + seatNumber);
    return false;
  }

  // for testing
  public void getSeats() {
    for(Seat seat : seats) {
      System.out.println(seat.getSeatNumber());
    }
  }

  public static void main(String[] args) {
    Theater theatre = new Theater("Olympian", 8, 12);
//        theatre.getSeats();
    if(theatre.reserveSeat("D12")) {
      System.out.println("Please pay");
    } else {
      System.out.println("Sorry, seat is taken");
    }
//        if(theatre.reserveSeat("H11")) {
//            System.out.println("Please pay");
//        } else {
//            System.out.println("Sorry, seat is taken");
//        }
  }

}
