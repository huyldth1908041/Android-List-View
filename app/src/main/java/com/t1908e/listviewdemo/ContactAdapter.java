package com.t1908e.listviewdemo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private List<Contact> listContacts;
    private Activity activity;
    public ContactAdapter(List<Contact> listContacts, Activity activity) {
        this.listContacts = listContacts;
        this.activity = activity;
    }
    @Override
    public int getCount() {
        return listContacts.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    // mỗi thg item của list view sẽ gọi hàm này để render list view trả về 1 view mà thg view này
    // sẽ lại dc truyền vào từ những lần gọi của item kế tiếp
    //tham số position là index của thg gọi
    //view là view hiện tại đang gọi
    //parentView ?
    @Override
    public View getView(int position, View view, ViewGroup parentView) {
        if(view == null) {
            //init item view == contact_item when first item call this method
            LayoutInflater layoutInflater = activity.getLayoutInflater();
            view = layoutInflater.inflate(R.layout.item_contact, parentView, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.txtName = (TextView) view.findViewById(R.id.contactName);
            viewHolder.txtPhone = (TextView) view.findViewById(R.id.contactPhone);
            viewHolder.imageAvatar = (ImageView) view.findViewById(R.id.contactAvatar);
            view.setTag(viewHolder);
        }
        //set data for item view when it is initialized
        ViewHolder holder = (ViewHolder) view.getTag();
        Contact contact = listContacts.get(position);
        holder.txtName.setText(contact.getName());
        holder.txtPhone.setText(contact.getPhone());
        holder.imageAvatar.setImageResource(contact.getImage());
        return view;
    }
    static class ViewHolder {
        TextView txtName;
        TextView txtPhone;
        ImageView imageAvatar;

    }
}
