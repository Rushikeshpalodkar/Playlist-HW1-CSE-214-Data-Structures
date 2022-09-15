public class Playlist {
    final int count = 50;

    public void setList(SongRecord[] list) {
        this.list = list;
    }

    SongRecord[] list;

    public int getNumberOfSong() {
        return numberOfSong;
    }

    int numberOfSong = 0;
    String playListName;

    public String getPlayListName() {
        return playListName;
    }

    public  SongRecord[] getList() {
        return list;
    }





    public Playlist(String playListName) {
        list = new SongRecord[count];
        numberOfSong = 0;
        this.playListName = playListName;
    }

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }


//    public boolean equal(Object obj) {
//        for (int i = 0; i < numberOfSong; i++) {
//            if (this.playList[i] == obj) {
//                return true;
//            }
//        }
//        return false;
//    }

    public int size() {
        return numberOfSong;
        // return number of songs in playlist
    }

    public void addSong(SongRecord song, int position) throws IllegalArgumentException, FullPlaylistException {
        if(position > numberOfSong+1 || position < 0 || position > 50)
            throw new IllegalArgumentException();
        if(numberOfSong == 0)
        {
            list[0] = song;
            numberOfSong++;
            return;
        }
        if(numberOfSong == 50)
            throw new FullPlaylistException();
        if(list[position-1] instanceof SongRecord)
        {
            moveRight(position-1);
        }
            list[position-1] = song;
            numberOfSong++;
    }

    public void moveRight(int position) {
        int i= position;
        while(list[i] instanceof SongRecord)
        {
            i++;
        }
        for(int j=i;j>0;j--)
        {
            list[j] = list[j-1];
        }
//        position += 1;
//        while (playList[position] instanceof SongRecord) {
//            // SongRecord memory = playList[position+1];
//            playList[position] = playList[position - 1];
//            position++;
//        }
    }


    public void removeSong(int position) throws IllegalArgumentException {
        list[position - 1] = null;
        shiftLeft(position);
        numberOfSong--;
    }

    public void shiftLeft(int position) {
        while (list[position] instanceof SongRecord) {
            list[position - 1] = list[position];
            position++;
        }
    }


    public SongRecord getSong(int position) throws IllegalArgumentException {
        if(position < 0 || position >50)
            throw new IllegalArgumentException();
        return list[position - 1];
    }

    public void printAllSongs() {
        SongRecord[] songs = this.getList();
        int i=0;
        while(songs[i] instanceof SongRecord)
        {
            System.out.println(songs[i].toString());
            i++;
        }

    }

    @Override
    public String toString() {
       return "all Songs in playlist \n "+ this.getList().toString();
    }

    public static Playlist getSongsByArtist(Playlist originalList, String artist) throws FullPlaylistException {
            Playlist newPlayList = new Playlist("new_playList");
            SongRecord[] songs = originalList.getList();
            int i=0;
            while(songs[i] instanceof SongRecord)
            {
                if(songs[i].artist.equals(artist))
                newPlayList.addSong(songs[i],i+1);
                i++;
            }

        SongRecord[] songss = newPlayList.getList();
        int j=0;
        System.out.println("Song by artist are : ");
        while(songss[j] instanceof SongRecord)
        {
            System.out.println(songs[j].toString());
            j++;
        }


            return newPlayList;

    }


    // Get song by

}






