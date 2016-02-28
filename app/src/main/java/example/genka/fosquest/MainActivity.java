package example.genka.fosquest;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;


import android.os.Bundle;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import example.genka.fosquest.fragment.SectionFragment;
import example.genka.fosquest.model.Contact;
import example.genka.fosquest.model.Message;
import example.genka.fosquest.utils.CircleCrop;
import example.genka.fosquest.utils.StaticData;
/**
 * Created by Genka on 27.10.2015.
 */
public class MainActivity extends AppCompatActivity {

    public final static int MAX_MESSAGE_DESC = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadLastMessage();
        setAutoCompleteText();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, new SectionFragment(),
                        SectionFragment.class.getSimpleName())
                .commit();

    }

    private void setAutoCompleteText() {

        /** Set searching by user contacts
         *  and load adapter for AutoCompleteText
         *  TODO: Create SearchWidget and AutoCompleteText
         *  */
    }


    private void loadLastMessage() {
        final CardView cardLastMess = (CardView) findViewById(R.id.last_message_field);
        Message lastMessage = StaticData.getLastMessage();
        StringBuilder descBuilder = new StringBuilder();

        cardLastMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardLastMess.setVisibility(View.GONE);
            }
        });

        TextView lastMesName = (TextView) findViewById(R.id.name_last_text);
        TextView lastMesDesc = (TextView) findViewById(R.id.desc_last_text);
        ImageView lastMesImage = (ImageView) findViewById(R.id.last_mess_image);

        lastMesImage.setImageBitmap(CircleCrop.getRoundedShape(
                BitmapFactory.decodeResource(getResources(),
                        lastMessage.getContact().getImageUrl())));

        lastMesName.setText(lastMessage.getContact().getName());

        descBuilder.append(lastMessage.getMessage().substring(0, MAX_MESSAGE_DESC))
                .append("...")
                .append("2 Hours ago");

        lastMesDesc.setText(descBuilder.toString());
    }

    public static Contact getMyContact () {

        return new Contact(LoremIpsum.getInstance().getFirstName(),
                LoremIpsum.getInstance().getLastName(), "", false, true,
                StaticData.contactPhotos[5]);
    }

}
