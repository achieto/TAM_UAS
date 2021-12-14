package com.example.prianly;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListLyricsAdapter extends RecyclerView.Adapter<ListLyricsAdapter.ListViewHolder> {
    private Context context;
    private ArrayList<Lyrics> lyricsLyrics;

    public ArrayList<Lyrics> getListLyrics() {
        return lyricsLyrics;
    }

    public void setListLyrics(ArrayList<Lyrics> lyricsLyrics) {
        this.lyricsLyrics = lyricsLyrics;
    }

    public ListLyricsAdapter(ArrayList<Lyrics> lyrics, Context context) {
        this.lyricsLyrics = lyrics;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Lyrics lyrics = lyricsLyrics.get(position);
        Glide.with(holder.itemView.getContext())
            .load(lyrics.getImage())
            .apply(new RequestOptions().override(350, 350))
            .into(holder.image);
        holder.tvTitle.setText(lyrics.getTitle());
        holder.tvSinger.setText(lyrics.getSinger());
    }

    @Override
    public int getItemCount() {
        return lyricsLyrics.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView image;
        TextView tvTitle, tvSinger;

        ListViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.textView1);
            tvSinger = view.findViewById(R.id.textView2);
            image = view.findViewById(R.id.image);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Lyrics lyrics = getListLyrics().get(position);
            Intent intent = new Intent(context, DetailLyricsActivity.class);
            intent.putExtra(DetailLyricsActivity.ITEM_EXTRA, lyrics);

            context.startActivity(intent);
        }
    }
}
