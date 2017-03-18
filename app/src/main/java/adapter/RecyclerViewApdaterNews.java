package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.project.newapp.news.DetailsActivity;
import com.project.newapp.news.NetworkController;
import com.project.newapp.news.R;

import java.util.List;

import model.sources;

/**
 * Created by Eslam on 3/15/2017.
 */

public class RecyclerViewApdaterNews extends RecyclerView.Adapter<RecyclerViewApdaterNews.ViewHolder>  {




    private ImageLoader imageLoader;

    private List<sources>sourcesList;


     Context context;
    private LayoutInflater layoutInflater;

    public RecyclerViewApdaterNews(Context context,List<sources>sourcesList){
        this.sourcesList=sourcesList;
        this.context=context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_items,parent,false);

        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        sources sources = sourcesList.get(position);

        holder.txttitle.setText(sources.getId());
//        holder.txtname.setText(sources.getName());
        holder.networkImageView.setImageUrl(sources.getSmall(), NetworkController.getNetworkController(context).geImageLoader());
    }

    @Override
    public int getItemCount() {
        if(sourcesList!=null) {
            return sourcesList.size();
        }

        return  0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView txttitle;
        NetworkImageView networkImageView;

        public ViewHolder(View itemView) {
            super(itemView);

            networkImageView=(NetworkImageView) itemView.findViewById(R.id.image);
            //txtname=(TextView)itemView.findViewById(R.id.txtname);

            txttitle=(TextView)itemView.findViewById(R.id.txttitle);
            cardView=(CardView)itemView.findViewById(R.id.cardview);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context.getApplicationContext(), DetailsActivity.class);
                    context.startActivity(intent);

                }

            });
        }



    }
}
