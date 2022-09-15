public class SongRecord implements Cloneable{

    private String title;
    public String artist;
    public int min;
    public int sec;
    public SongRecord() {
        this.title =" ";
        this.artist="";
        this.min=0;
        this.sec=0;
    }

        public void setTitle (String stitle){
            this.title = stitle;
        }
        public String getTitle () {
            return title;
        }

        public void setArtist (String sartist){
            this.artist = sartist;
        }
        public String getartist() {
            return this.artist;
        }


        public void setMin ( int min1){
            if (min1<0){
                throw new IllegalArgumentException("value out of bound");
            }
            this.min = min1;
        }
        public int getMin () {
            return min;
        }

        public void setSec ( int sec1){

            if (sec1 <= 0 || sec1 > 59) {
                throw new IllegalArgumentException("value out of bound");
            }
            this.sec = sec1;
        }

        public int getSec () {
            return sec;
        }



    public String toString() {
        return "SongRecord{" +
                "title='" + getTitle() + '\'' +
                ", artist='" + getartist() + '\'' +
                ", min=" + getMin() +
                ", sec=" + getSec()+
                '}';
    }
}

