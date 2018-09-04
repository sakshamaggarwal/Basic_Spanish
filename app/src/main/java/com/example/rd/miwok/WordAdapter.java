package com.example.rd.miwok;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rd on 14-07-2016.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    private int colorBackground;
    private int colorForText;

    /*Custom ArrayAdapter constructor*/
    public WordAdapter(Activity context, ArrayList<Word> words, int colorParam, int colorTextParam)
    {
        // 0 is for the layout resource id because we do not need to rely on the super class ArrayAdapter inflating or creating a list item view for us,
        // Instead our getView method will manually handle the inflating of the layout from the layout resource id ourselves
        super(context, 0, words);
        colorBackground = colorParam;
        colorForText = colorTextParam;
    }


    // getView method provides a list item view for an Adapter view(adapter view can be a listView or GridView or some other type of adapter view)
    // @param position ---- is the position in the list of data this layout should represent
    // @param convertView which is the recycle view that needs to be populated
    // So list item views will be added to the parent ViewGroup as children
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // conertView is an existing view which we can reuse
        View listItemView = convertView;
        // sometimes this view is null which means that there is no view which we can reuse
        // when we open the app the view is always null
        // if this is null then we inflate the list_view
        // we are manually inflating the view this is the reasn we did nit pass layout resource id to the super class constructor
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }

        // getItem method is defined in the superclass ArrayAdapter
        // this method return the item in the list at a given index position
        // return value of this method is an object of the datatype Word and this is because in the class declaration we have mentioned ArrayAdapter<Word> which means ArrayAdapter expects a list of Word objects
        //
        final Word currentWord = getItem(position);

        // Find the TextView in the list_view.xml layout with the ID spanish_text_view
        TextView spanishTextView = (TextView) listItemView.findViewById(R.id.spanish_text_view);
        // Get the spanish text for numbers from the current Word object and
        // set this text on the name TextView
        spanishTextView.setText(currentWord.getMiwokTranslation());
        int colorText = ContextCompat.getColor(getContext(), colorForText);
        spanishTextView.setTextColor(colorText);
        // Find the TextView in the list_item.xml layout with the ID english_text_view
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        englishTextView.setText(currentWord.getEnglishTranslation());
        englishTextView.setTextColor(colorText);

        //Find the ImageView in the list_view.xml layout with id image_icon
        ImageView imageIcon = (ImageView) listItemView.findViewById(R.id.image_icon);
        // Get the image icon from the current AndroidFlavor object and
        // set this image on the ImageView
        if(currentWord.hasImage())
        imageIcon.setImageResource(currentWord.getImageResourceId());
        else
        imageIcon.setVisibility(View.GONE);

        LinearLayout twoText = (LinearLayout) listItemView.findViewById(R.id.two_texts);

        int color = ContextCompat.getColor(getContext(), colorBackground);
        twoText.setBackgroundColor(color);



        // returning list item view with the updated information from the currentWord object
        // so this listItemView will be added as a child to the AdapterView
        return listItemView;
    }
}


//Modify list_view for images
//Run app
//Modify Wod class for image
//Run app
//Addd images to teh app
//Run app
//