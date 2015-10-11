package io.bloc.android.blocly.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import io.bloc.android.blocly.BloclyApplication;
import io.bloc.android.blocly.R;

/**
 * Created by Kartik on 04-Oct-15.
 */

public class BloclyActivity extends Activity {


    private TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocly);
        Toast.makeText(this,
                BloclyApplication.getSharedDataSource().getFeeds().get(0).getTitle(),
                Toast.LENGTH_LONG).show();

        myTextView = (TextView)findViewById(R.id.myTextView);
        myTextView.setText(BloclyApplication.getSharedDataSource().getFeeds().get(0).getTitle());

    }
}



