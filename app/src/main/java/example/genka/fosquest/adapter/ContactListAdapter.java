package example.genka.fosquest.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import example.genka.fosquest.R;
import example.genka.fosquest.model.Contact;
import example.genka.fosquest.utils.CircleCrop;

/**
 * Created by Genka on 27.10.2015.
 */
public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {

    private List<Contact> contactList;
    private Context context;

    public ContactListAdapter (Context _context, List<Contact> _list) {
        this.context = _context;
        this.contactList = _list;
    }

    @Override
    public ContactListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_contact_adapter, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ContactListAdapter.ViewHolder holder, int position) {
        Contact curContact = contactList.get(position);

        holder.textTitle.setText(String.valueOf(curContact.getName().charAt(0)));

        holder.contactPhoto.setImageBitmap(CircleCrop.getRoundedShape(
                BitmapFactory.decodeResource(context.getResources(),
                        curContact.getImageUrl())));

        holder.textContactName.setText(curContact.getName() + " "
                + curContact.getLastName());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textTitle;
        public TextView textContactName;
        public ImageView contactPhoto;
        public ImageView menuIcon;

        public ViewHolder(View itemView) {
            super(itemView);

            textTitle = (TextView) itemView.findViewById(R.id.text_contact_title);
            textContactName = (TextView) itemView.findViewById(R.id.text_contact_name);
            contactPhoto = (ImageView) itemView.findViewById(R.id.contact_photo);
            menuIcon = (ImageView) itemView.findViewById(R.id.contact_image_menu);
        }
    }
}
