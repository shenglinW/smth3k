package com.jimidigi.smth3k.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.jimidigi.smth3k.R;
import com.jimidigi.smth3k.bean.Mail;
import com.jimidigi.smth3k.common.DateUtils;

import java.util.List;

/**
 * 用户留言Adapter类
 *
 * @author liux (http://my.jimidigi.net/liux)
 * @version 1.0
 * @created 2012-3-21
 */
public class ListViewMailAdapter extends BaseAdapter {
    private Context context;//运行上下文
    private List<Mail> listItems;//数据集合
    private LayoutInflater listContainer;//视图容器
    private int itemViewResource;//自定义项视图源

    static class ListItemView {                //自定义控件集合
        public TextView plant;
        public TextView sendid;
        public TextView date;
        public TextView title;

    }

    /**
     * 实例化Adapter
     *
     * @param context
     * @param data
     * @param resource
     */
    public ListViewMailAdapter(Context context, List<Mail> data, int resource) {
        this.context = context;
        this.listContainer = LayoutInflater.from(context);    //创建视图容器并设置上下文
        this.itemViewResource = resource;
        this.listItems = data;
    }

    public int getCount() {
        return listItems.size();
    }

    public Object getItem(int arg0) {
        return null;
    }

    public long getItemId(int arg0) {
        return 0;
    }

    /**
     * ListView Item设置
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        //Log.d("method", "getView");

        //自定义视图
        ListItemView listItemView = null;

        if (convertView == null) {
            //获取list_item布局文件的视图
            convertView = listContainer.inflate(this.itemViewResource, null);

            listItemView = new ListItemView();
            //获取控件对象
            listItemView.plant = (TextView) convertView.findViewById(R.id.message_listitem_plant);
            listItemView.sendid = (TextView) convertView.findViewById(R.id.message_listitem_sendid);
            listItemView.date = (TextView) convertView.findViewById(R.id.message_listitem_date);
            listItemView.title = (TextView) convertView.findViewById(R.id.message_listitem_title);

            //设置控件集到convertView
            convertView.setTag(listItemView);
        } else {
            listItemView = (ListItemView) convertView.getTag();
        }

        //设置文字和图片
        Mail msg = listItems.get(position);

        listItemView.plant.setText(msg.getFloor() + "");
        listItemView.sendid.setText(msg.getSenderID());
        listItemView.date.setText(DateUtils.niceDay(msg.getDate()));
        listItemView.title.setText(msg.getTitle());
        listItemView.title.setTag(msg);

        return convertView;
    }

    private View.OnClickListener faceClickListener = new View.OnClickListener() {
        public void onClick(View v) {
//			Messages msg = (Messages)v.getTag();
//			UIHelper.showUserCenter(v.getContext(), msg.getFriendId(), msg.getFriendName());
        }
    };
}