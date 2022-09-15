public class FullPlaylistException extends Exception{
    public FullPlaylistException(){
        super("Invalid playlist is full cant add any song.");
    }
    public FullPlaylistException(String message)
    {
        super(message);
    }
}
