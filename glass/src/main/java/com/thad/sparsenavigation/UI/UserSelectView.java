package com.thad.sparsenavigation.UI;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;



/**
 * Created by tinggu on 11/5/18.
 */

public class UserSelectView extends LinearLayout {
    private static final String TAG = "|UserSelectView|";

    private TextView userSelectHintView;
    private ListView userSelectListView;
    private String[] userIdValues = new String[] {"1", "2", "3", "4", "5", "6",
                                            "7", "8", "9", "10", "11", "12"};

    private Context context;
    //private TextView columnTag, author_view, title_view, aisle_letter_view;
    //private TextView[] rackNumTag;
    //private LinearLayout[] racks;
    //private ImageView[] shelves;

    private int MP = ViewGroup.LayoutParams.MATCH_PARENT;
    private int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
    //int[] colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA};
    // CONSTRUCTOR
    public UserSelectView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init(){
        this.setLayoutParams(new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        this.setOrientation(VERTICAL);

        userSelectHintView = new TextView(context);
        applyTextStyle(userSelectHintView);
        userSelectHintView.setText("Please select User ID");
        this.addView(userSelectHintView);

        userSelectListView = new ListView(context);

//        final ArrayList<String> lists = new ArrayList<String>();
//        for (int i = 0; i < userIdValues.length; ++i) {
//            lists.add(userIdValues[i]);
//        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_list_item_1, userIdValues);

        userSelectListView.setAdapter(adapter);


        userSelectListView .setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // selected item
                String product = ((TextView) view).getText().toString();

                Toast.makeText(context, "Selected User :" +product, Toast.LENGTH_SHORT).show();

            }
        });

        this.addView(userSelectListView);
    }

    private void applyTextStyle(TextView textView){
        textView.setTextColor(Color.rgb(255,255,255));
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f);

    }


}

