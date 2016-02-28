package example.genka.fosquest.utils;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import example.genka.fosquest.R;
import example.genka.fosquest.model.Contact;
import example.genka.fosquest.model.Message;

/**
 * Created by Genka on 27.10.2015.
 */
public class StaticData {


    public static LoremIpsum loremIpsum = LoremIpsum.getInstance();
    private static Random rand = new Random();



    public static List<Contact> getListContacts (int contactSize, boolean isFavourite)  {
        List<Contact> arrayList = new ArrayList<>();

        for (int i = 0; i < contactSize; i++) {
            Contact current = new Contact(
                    loremIpsum.getFirstName(),
                    loremIpsum.getLastName(),
                    "4 hours ago",
                     isFavourite,
                    rand.nextBoolean(),
                    contactPhotos[rand.nextInt(6)]);
            arrayList.add(current);
        }

        return arrayList;
    }

    public static Message getLastMessage () {

        Contact simpleContact = new Contact(
                loremIpsum.getFirstName(),
                loremIpsum.getLastName(),
                "4 hours ago",
                loremIpsum.getName().length()>3,
                loremIpsum.getName().length()>3,
                contactPhotos[rand.nextInt(6)]);

        Message lastMessage = new Message(simpleContact,
                loremIpsum.getWords(3, 8),
                "Time",
                false);

        return lastMessage;
    }

    public static List<Message> getListMessages (int messagesSize) {
        List<Message> list = new ArrayList<>();

        Contact friend = new Contact( loremIpsum.getName(), loremIpsum.getLastName(),
                "Time online", false, true, contactPhotos[rand.nextInt(5)]);

        Contact owner = new Contact( loremIpsum.getName(), loremIpsum.getLastName(),
                "Time online", false, true, contactPhotos[5]);

        for (int i = 0; i < messagesSize; i++) {
            boolean bool = i%2==0;
            Contact current = bool ? owner: friend;
            Message message = new Message(current, loremIpsum.getWords(3, 10), "4 hours ago", bool);
            list.add(message);

        }

        return list;
    }

    public static int[] contactPhotos = new int[] {
        R.drawable.sample_contact_0, R.drawable.sample_contact_1,
            R.drawable.sample_contact_2, R.drawable.sample_contact_3,
            R.drawable.sample_contact_4, R.drawable.sample_contact_5};
}
