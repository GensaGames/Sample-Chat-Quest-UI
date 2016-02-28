package example.genka.fosquest.adapter;

import android.content.Context;
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

/**
 * Created by Genka on 27.10.2015.
 */
public class FavouriteGridAdapter extends RecyclerView.Adapter<FavouriteGridAdapter.ViewHolder> {

    private List<Contact> contactList;
    private Context context;

    public FavouriteGridAdapter (Context context, List<Contact> list) {
        super();
        this.context = context;
        this.contactList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_favourite_adapter, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact curContact = contactList.get(position);
        holder.contactPhoto.setImageDrawable(ContextCompat
                .getDrawable(context, curContact.getImageUrl()));

        holder.imageOnline.setVisibility(curContact.isOnline() ? View.VISIBLE : View.GONE);
        holder.textName.setText(curContact.getName());
        holder.textSurname.setText(curContact.getLastName());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView contactPhoto;
        public ImageView imageOnline;
        public ImageView imageMenu;
        public TextView textName;
        public TextView textSurname;


        public ViewHolder(View itemView) {
            super(itemView);
            contactPhoto = (ImageView) itemView.findViewById(R.id.contact_photo);
            imageOnline = (ImageView) itemView.findViewById(R.id.favourite_image_online);
            imageMenu = (ImageView) itemView.findViewById(R.id.favourite_icon_menu);
            textName = (TextView) itemView.findViewById(R.id.favourite_text_name);
            textSurname = (TextView) itemView.findViewById(R.id.favourite_text_surname);
        }
    }
}
