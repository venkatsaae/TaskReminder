package com.saae.taskreminder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saae on 5/6/2017.
 */

public class RecyclerViewExample extends AppCompatActivity {



    RecyclerView rv_list;
    Adapter adapter;

    List<String>list;
      ItemTouchHelper itemTouchHelper;
    Paint p=new Paint();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycerview);
        rv_list= (RecyclerView) findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        list.add(0,"saae");
        list.add(1,"srinath");
        list.add(2,"enoch");
        list.add(3,"ravi");
        adapter=new Adapter(list);
        rv_list.setAdapter(adapter);
       // swipeOn();
       // itemTouchHelper.attachToRecyclerView(rv_list);

    }


    public class Adapter extends RecyclerView.Adapter<MyViewHolder>{

        List<String>list;
        public Adapter(List<String>list){
            this.list=list;

        }
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v=getLayoutInflater().inflate(R.layout.inflator,parent,false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.tv.setText(list.get(position));

            String dataObject = list.get(position);
            ViewBinderHelper viewBinderHelper=new ViewBinderHelper();

            // Save/restore the open/close state.
            // You need to provide a String id which uniquely defines the data object.
            viewBinderHelper.bind(holder.swipeLayout, dataObject);
            holder.img_remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    list.remove(position);
                    notifyDataSetChanged();
                }
            });

        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        TextView tv;
        ImageView img_remove;
        private SwipeRevealLayout swipeLayout;
        public MyViewHolder(View itemView) {
            super(itemView);

            tv= (TextView) itemView.findViewById(R.id.tv);
            swipeLayout = (SwipeRevealLayout) itemView.findViewById(R.id.swipe);
            img_remove= (ImageView) itemView.findViewById(R.id.img_remove);
        }
    }

    public void swipeOn() {
       ItemTouchHelper.SimpleCallback simpleCallback=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
           @Override
           public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
               return true;
           }

           @Override
           public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

               adapter.notifyDataSetChanged();

           }




           @Override
           public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

               Bitmap icon;
               if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE){

                   View itemView = viewHolder.itemView;
                   float height = (float) itemView.getBottom() - (float) itemView.getTop();
                   float width = height / 3;


                       p.setColor(Color.BLUE);
                       RectF background = new RectF((float) itemView.getRight() + dX, (float) itemView.getTop(),(float) itemView.getRight(), (float) itemView.getBottom());
                       c.drawRect(background,p);
                       icon = BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_btn_speak_now);
                       RectF icon_dest = new RectF((float) itemView.getRight() - 2*width ,(float) itemView.getTop() + width,(float) itemView.getRight() - width,(float)itemView.getBottom() - width);
                       c.drawBitmap(icon,null,icon_dest,p);
                   //}

                   if (dX>-700){
                       super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

                   }

                   else{

                      // Log.d("pos",dX+dY);
                       System.out.println(dX+"dy:"+dY);
                   }

           }


       }};
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rv_list);

    }

}
