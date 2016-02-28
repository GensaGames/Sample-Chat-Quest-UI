package example.genka.fosquest.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import example.genka.fosquest.R;
import example.genka.fosquest.model.Message;
import example.genka.fosquest.utils.CircleCrop;
/**
 * Created by Genka on 27.10.2015.
 */
public class MessageListAdapter extends  RecyclerView.Adapter<MessageListAdapter.ViewHolder> {

    private List<Message> messageList;
    private Context context;

    public MessageListAdapter (Context _context, List<Message> _list) {
        super();
        this.context = _context;
        this.messageList = _list;
    }

    public void addMessage (Message message) {
        messageList.add(message);
        notifyDataSetChanged();
    }

    @Override
    public MessageListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_message_adapter, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MessageListAdapter.ViewHolder holder, int position) {
        Message curMessage = messageList.get(position);
        int timeGravity = curMessage.isOwner()? Gravity.START : Gravity.END;
        int messGravity = curMessage.isOwner()? Gravity.END : Gravity.START;

        holder.textTime.setGravity(timeGravity);
        holder.textTime.setText(curMessage.getTime());

        holder.textMessage.setGravity(messGravity);
        holder.textMessage.setText(curMessage.getMessage());


        if (curMessage.isOwner()) {
            holder.contactPhoto.setVisibility(View.GONE);
            holder.ownerPhoto.setVisibility(View.VISIBLE);
            holder.imageView.setImageDrawable(ContextCompat
                    .getDrawable(context, R.drawable.bubble_image_right));

            holder.ownerPhoto.setImageBitmap(CircleCrop.getRoundedShape(
                    BitmapFactory.decodeResource(context.getResources(),
                            curMessage.getContact().getImageUrl())));
        }
        else {
            holder.ownerPhoto.setVisibility(View.GONE);
            holder.contactPhoto.setVisibility(View.VISIBLE);
            holder.imageView.setImageDrawable(ContextCompat
                    .getDrawable(context, R.drawable.bubble_image_left));

            holder.contactPhoto.setImageBitmap(CircleCrop.getRoundedShape(
                    BitmapFactory.decodeResource(context.getResources(),
                            curMessage.getContact().getImageUrl())));
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView contactPhoto;
        public ImageView ownerPhoto;
        public FrameLayout linearBubble;
        public TextView textTime;
        public TextView textMessage;

        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            contactPhoto = (ImageView) itemView.findViewById(R.id.contact_photo);
            ownerPhoto = (ImageView) itemView.findViewById(R.id.contact_my_photo);
            linearBubble = (FrameLayout) itemView.findViewById(R.id.linear_bubble);
            textTime = (TextView) itemView.findViewById(R.id.text_time_message);
            textMessage = (TextView) itemView.findViewById(R.id.text_message);
        }
    }
}
