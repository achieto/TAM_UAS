package com.example.prianly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailLyricsActivity extends AppCompatActivity {

    private Lyrics lyrics;
    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lyrics);

        ImageView imgItemPhoto = findViewById(R.id.img_item_photo);
        TextView tvName = findViewById(R.id.tv_item_name);
        TextView tvName2 = findViewById(R.id.tv_item_name2);
        TextView tvLyrics = findViewById(R.id.lyrics_detail);

        lyrics = getIntent().getParcelableExtra(ITEM_EXTRA);
        if (lyrics != null) {
            Glide.with(this)
                    .load(lyrics.getImage())
                    .into(imgItemPhoto);
            tvName.setText(lyrics.getTitle());
            tvName2.setText(lyrics.getSinger());
            tvLyrics.setText(lyrics.getLyric());
        }

        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Lyrics");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}