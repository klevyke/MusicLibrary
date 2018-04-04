package com.example.android.musiclibrary;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Levy on 21.03.2018.
 */

public class SongAdapter extends ArrayAdapter<Song> {
    // Constant used to get the result from the other activities

    static final String TRACK_INDEX = "trackIndex";

    // the xml resource id of the file that will be used for rendering an element
    private int mResource;

    private Activity parentActivity = new Activity();
    /**
     * Constructor
     * @param context
     * @param song
     * @param activity parent activity
     */
    public SongAdapter(Activity context, ArrayList<Song> song, int resource, Activity activity) {
        super(context, 0, song);
        // call constructor form parent
        mResource = resource;
        parentActivity = activity;
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    mResource, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final Song currentSong = getItem(position);

        // Find the TextView with the ID artist_text_view
        TextView artist = (TextView) listItemView.findViewById(R.id.artist_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        artist.setText(currentSong.getArtist());

        // Find the TextView with the ID song_text_view)
        TextView song = (TextView) listItemView.findViewById(R.id.song_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        song.setText(currentSong.getSong());

        // Find the TextView with the ID genre_text_view
        TextView genre = (TextView) listItemView.findViewById(R.id.genre_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        genre.setText(currentSong.getGenre());

        // Find the add button with the ID genre_text_view
        Button addToPlayList = (Button) listItemView.findViewById(R.id.add_to_playlist);

        // Check if the button is created (in MainActivity there is no add button in the playlist)
        if (addToPlayList != null) {

            // Set a click listener on that View
            addToPlayList.setOnClickListener(new View.OnClickListener() {

                // When songs is clicked on.
                @Override
                public void onClick(View view) {

                    // Set an Intent to be returned (inspiration: https://stackoverflow.com/questions/39943058/listview-adapter-setresult-and-finish-error)
                    Intent resultIntent = new Intent();

                    // Set the index of clicked song
                    resultIntent.putExtra(TRACK_INDEX, currentSong.getSongId());

                    // Return the index as result and finish this activity
                    parentActivity.setResult(Activity.RESULT_OK, resultIntent);
                    parentActivity.finish();
                }
            });
        }

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
