package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.project.newapp.news.NetworkController;
import com.project.newapp.news.R;

import java.util.ArrayList;
import java.util.List;
import model.articles;
import model.sources;

public class DetailsRecyclerviewAdapter extends RecyclerView.Adapter<DetailsRecyclerviewAdapter.DetailsViewHolder> {

    private List<articles>articlesList = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;

    public DetailsRecyclerviewAdapter(Context context,List<articles>articlesList){

        this.context=context;
        this.articlesList=articlesList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public DetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.details_items,parent,false);

        DetailsViewHolder detailsViewHolder=new DetailsViewHolder(view);

        return detailsViewHolder;

    }

    @Override
    public void onBindViewHolder(DetailsViewHolder holder, int position) {
        articles articles = articlesList.get(position);

        holder.txttitle.setText(articles.getTitle());
        holder.txtauthor.setText(articles.getAuthor());
        holder.networkImageView.setImageUrl(articles.getUrlToImage(), NetworkController.getNetworkController(context).geImageLoader());
    }

    @Override
    public int getItemCount() {
        if(articlesList!=null) {
            return articlesList.size();
        }

        return  0;
    }

   public static class DetailsViewHolder extends RecyclerView.ViewHolder{

        TextView txtauthor;
        TextView txttitle;
        NetworkImageView networkImageView;
        public DetailsViewHolder(View itemView) {
            super(itemView);
            txtauthor=(TextView)itemView.findViewById(R.id.txtauthor);
            txttitle=(TextView)itemView.findViewById(R.id.txtdetailstitle);
            networkImageView=(NetworkImageView)itemView.findViewById(R.id.detailsimage);

        }
    }
}
