package com.xu.sayhi.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.xu.sayhi.R;
import com.xu.sayhi.bean.SayCoMesaage;

import java.util.List;

/**
 * Created by wangxu on 2016/4/19.
 * 消息
 */
public class MessageAdapter extends BaseAdapter {

    public final static int MAX_TYPE = 7;
    public final static int RECEIVE_TEXT = 1;
    public final static int RECEIVE_PHOTO = 2;
    public final static int RECEIVE_TIME = 3;
    public final static int SEND_TEXT = 4;
    public final static int SEND_PHOTO = 5;
    public final static int SEND_TIME = 6;
    private Context context;
    private List<SayCoMesaage> list;

    public List<SayCoMesaage> getList() {
        return list;
    }

    public void setList(List<SayCoMesaage> list) {
        this.list = list;
    }

    @Override
    public int getViewTypeCount() {
        return MAX_TYPE;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        int currentType = getItemViewType(position);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = getView(currentType, parent);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            viewHolder.text = (TextView) convertView.findViewById(R.id.text);
            viewHolder.progressbar = (ProgressBar) convertView.findViewById(R.id.progressbar);
            viewHolder.re_send = (ImageView) convertView.findViewById(R.id.re_send);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    private View getView(int currentType, ViewGroup parent) {
        View convertView;
        switch (currentType) {
            case RECEIVE_TEXT:
                convertView = LayoutInflater.from(context).inflate(R.layout.layout_chat_recive, parent, false);
                break;

            default:
                convertView = LayoutInflater.from(context).inflate(R.layout.layout_chat_send, parent, false);
                break;
        }
        return convertView;
    }

    public class ViewHolder {
        public ImageView avatar;
        public TextView text;
        public ProgressBar progressbar;
        public ImageView re_send;
    }

}
