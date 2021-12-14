package com.example.prianly;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ListLyricsFragment extends Fragment {
    private RecyclerView rvListLyrics;
    private ArrayList<Lyrics> lyrics = new ArrayList<>();

    public ListLyricsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_list_lyrics, container, false);
        rvListLyrics = view.findViewById(R.id.listView);
        rvListLyrics.setHasFixedSize(true);

        lyrics.addAll(ListData.getListData());
        showRecyclerList();


        return view;
    }

    private void showRecyclerList() {
        rvListLyrics.setLayoutManager(new LinearLayoutManager(this.getContext()));
        ListLyricsAdapter listLyricsAdapter = new ListLyricsAdapter(lyrics, requireContext());
        listLyricsAdapter.setListLyrics(lyrics);
        rvListLyrics.setAdapter(listLyricsAdapter);
    }
}