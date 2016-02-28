package example.genka.fosquest.model;

/**
 * Created by Genka on 27.10.2015.
 */
public class Message {

    private Contact contact;
    private String message;
    private String time;
    private boolean owner;

    public Message (Contact _contact, String _message,
                    String _time, boolean _owner) {

        contact = _contact;
        message = _message;
        time = _time;
        owner = _owner;
    }

    public Contact getContact() {
        return contact;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public boolean isOwner() {
        return owner;
    }
}
