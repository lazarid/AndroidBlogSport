package com.example.idanl.blogsport.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.idanl.blogsport.Fragments.HomeFragmentDirections;
import com.example.idanl.blogsport.Models.Post;
import com.example.idanl.blogsport.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    Context mContext;
    List<Post> mData;

    public PostAdapter(Context mContext, List<Post> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(mContext).inflate(R.layout.row_post_item, parent, false);

        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        Post selected = mData.get(position);

        holder.tvTitle.setText(selected.getTitle());
        holder.tvSecondTitle.setText(selected.getSecond_title());
        holder.tvCategory.setText(selected.getCategory());
        holder.tvWriterName.setText(selected.getUserName());
        Glide.with(mContext).load(selected.getPicture()).into(holder.imgPost);
        Glide.with(mContext).load(selected.getUserPhoto()).into(holder.imgPostProfile);



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tvTitle, tvSecondTitle, tvCategory, tvWriterName;
        ImageView imgPost, imgPostProfile;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.post_item_title);
            tvSecondTitle = itemView.findViewById(R.id.post_item_sec_title);
            tvCategory = itemView.findViewById(R.id.post_item_category);
            tvWriterName = itemView.findViewById(R.id.post_item_writer_name);
            imgPost = itemView.findViewById(R.id.post_item_image);
            imgPostProfile = itemView.findViewById(R.id.comment_item_writer_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    HomeFragmentDirections.ActionHomeFragmentToPostDetailsFragment action = HomeFragmentDirections.actionHomeFragmentToPostDetailsFragment(mData.get(position));
                    Navigation.findNavController(v)
                            .navigate(action);
                }
            });
        }
    }
}