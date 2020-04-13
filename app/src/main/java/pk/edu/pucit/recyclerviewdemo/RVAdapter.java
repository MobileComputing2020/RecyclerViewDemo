package pk.edu.pucit.recyclerviewdemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    Context context;

    private String[] maintitle;
    private String[] subtitle;
    private Integer[] imgid;

    public RVAdapter(Context context, String[] maintitle, String[] subtitle, Integer[] imgid) {
        this.context = context;
        this.maintitle = maintitle;
        this.subtitle = subtitle;
        this.imgid = imgid;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(context).inflate(R.layout.list_item, null);
        ViewHolder holder = new ViewHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tv_title.setText(maintitle[position]);
        holder.tv_subtitle.setText(subtitle[position]);
        holder.iv_icon.setImageResource((position % 2 == 1) ? imgid[0] : imgid[1]);


        Log.e("title at pos-"+position,maintitle[position]);


        holder.iv_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, maintitle[position], Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return maintitle.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_title;
        public TextView tv_subtitle;
        public ImageView iv_icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.title);
            tv_subtitle = itemView.findViewById(R.id.subtitle);
            iv_icon = itemView.findViewById(R.id.imageView);
        }
    }
}
