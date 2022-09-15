import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaylistOperation {
    public static void main(String[] args) throws IOException, FullPlaylistException {
        List<Playlist> allPlayList = new ArrayList<>();
        Playlist currentplayList = null;
        String choice;
        Scanner sc = new Scanner(System.in);
        while(true) {

            System.out.println("this is the menue \n    N     Play List Name               N <Name> \n" +
                    "    Add Song:               A  <Title> <Artist> <Minutes> <Seconds> <Position>\n" +
                    "    Get Song:               G  <Position>\n" +
                    "    Remove Song:            R  <Position> \n" +
                    "    Print All Songs:        P  \n" +
                    "    Print Songs By Artist:  B  <Artist>\n" +
                    "    Size:                   S  \n" +
                    "    Quit:                   Q");
           choice = String.valueOf(sc.next().charAt(0));



            switch (choice) {
                case "N" :
                case "n": System.out.println("Enter playlist name");
                Playlist playlist = new Playlist(sc.next());
                allPlayList.add(playlist);
                    currentplayList = playlist;
                    break;
                case "A":
                case "a":
                  if(currentplayList == null)
                  {
                      System.out.println("PlayList not created");
                      break;
                  }else
                  {
                      SongRecord sr = new SongRecord();
                      System.out.println("Add title");
                      sr.setTitle(sc.next());
                      System.out.println("Add Artist");
                      String artist =sc.next();
                      sr.setArtist(artist);
                      System.out.println("Add Minutes");
                      sr.setMin(sc.nextInt());
                      System.out.println("Print seconds");
                      sr.setSec(sc.nextInt());
                      System.out.println("Enter position of the song");
                      int position = sc.nextInt();
                      currentplayList.addSong(sr, position);
                      System.out.println("Song Added : ");

                  }
                    break;
                case "G":
                case "g":
                    System.out.println("enter the position of the song you want");
                    int temp=sc.nextInt();
                    System.out.println(currentplayList.getSong(temp).toString());
                    break;
                case "R":
                case "r":
                    System.out.println("Enter the position of the song which you want to remove.");
                    int temp1=sc.nextInt();
                    currentplayList.removeSong(temp1);
                    break;
                case "p":
                case "P":
                    System.out.println("ALL song are:");
                    currentplayList.printAllSongs();
                    break;
                case "B":
                case"b":
                    System.out.println("Get Songs by artist");
                    String artist = sc.next();
                    System.out.println(currentplayList.getSongsByArtist(currentplayList, artist).toString());
                        break;
                case "S":
                case "s":
                    int numberOfSong = currentplayList.numberOfSong;
                    System.out.println("number of songs are:"+numberOfSong);
                    break;


                default:
                    System.out.println("nothing selected");
                    break;

            }

        }


    }
}
