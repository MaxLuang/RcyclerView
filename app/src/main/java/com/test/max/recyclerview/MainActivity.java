package com.test.max.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private  RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rv = new RecyclerView(this);
        setContentView(rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//          编辑UI所创的类
            class ViewHolder extends RecyclerView.ViewHolder {

                private TextView tv;
//                  下ViewHolder为default packbage为引入RecyclerView
                public ViewHolder(TextView itemView) {
                    super(itemView);

                    tv=  itemView;//tv即为itemview与viewholder进行关联
                }

                public TextView getTv() {
                    return tv;
                }
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
//                此方法是个绑定的试图，需要在上放自定义一个类，后在此类中修改在这里可以创建 textview。。
//                创建完毕，再次常见UI
//                    return new ViewHolder(new TextView(ViewGroup.getContext()));


                return new ViewHolder(new TextView(viewGroup.getContext()));
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder viewholder, int i) {
//                在BindViewHolder可以惊醒对view的赋值
            ViewHolder vh = (ViewHolder) viewholder;
                vh.getTv().setText(data[i]);//i为索引
            }

            @Override
            public int getItemCount() {
                return data.length;
            }
            public String[] data = new String[]{"max","leung","janny"};
        });










    }






}
