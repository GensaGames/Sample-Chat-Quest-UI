package example.genka.fosquest.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import example.genka.fosquest.model.Contact;

/**
 * Created by Genka on 27.10.2015.
 */
public class ContactSort {

    public static List<Contact> sortAlphabetically (List<Contact> contactList) {

        if (contactList.size() > 0) {
            Collections.sort(contactList, new Comparator<Contact>() {
                @Override
                public int compare(final Contact object1, final Contact object2) {
                    return object1.getName().compareTo(object2.getName());
                }
            });
        }

        return contactList;
    }
}
