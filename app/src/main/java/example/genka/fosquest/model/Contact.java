package example.genka.fosquest.model;

/**
 * Created by Genka on 27.10.2015.
 */
public class Contact {

    private String name;
    private String lastName;
    private String lastOnline;
    private boolean favourite;
    private boolean online;
    private int imageUrl;

    /** Change Contact model to action with server
     * TODO: Change fields to action with server
     * ---------------------------------------
     * */


    public Contact (String _name, String _lastName, String _lastOnline,
                    boolean _favourite, boolean _online, int _imageUrl) {
        name = _name;
        lastName = _lastName;
        lastOnline = _lastOnline;
        favourite = _favourite;
        online = _online;
        imageUrl = _imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLastOnline() {
        return lastOnline;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public boolean isOnline() {
        return online;
    }

    public int getImageUrl() {
        return imageUrl;
    }
}
