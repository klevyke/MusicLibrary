package com.example.android.musiclibrary;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Levy on 21.03.2018.
 */

public class SongAdapter extends ArrayAdapter<Song> {
    // the xml resource id of the file that will be used for rendering an element
    private int mResource;
    /**
     * Constructor
     * @param context
     * @param song
     */
    public SongAdapter(Activity context, ArrayList<Song> song, int resource) {
        super(context, 0, song);
        // call constructor form parent
        mResource = resource;
    }
    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    mResource, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Song currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView artist = (TextView) listItemView.findViewById(R.id.artist_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        artist.setText(currentWord.getArtist());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView song = (TextView) listItemView.findViewById(R.id.song_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        song.setText(currentWord.getSong());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView genre = (TextView) listItemView.findViewById(R.id.genre_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        genre.setText(currentWord.getGenre());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
