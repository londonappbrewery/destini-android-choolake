package com.londonappbrewery.destini;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private Button ans1Button,ans2Button;
    private TextView storyText;
    final Story[] mStories=new Story[]{
            new Story(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
            new Story(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new Story(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2),
            new Story(R.string.T4_End,0,0),
            new Story(R.string.T5_End,0,0),
            new Story(R.string.T6_End,0,0),
    };
    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        ans1Button=(Button) findViewById(R.id.buttonTop);
        ans2Button=(Button) findViewById(R.id.buttonBottom);
        storyText=(TextView) findViewById(R.id.storyTextView);
        if(savedInstanceState!=null){
            index=savedInstanceState.getInt("index");
            updateView();
        }
        else{
            index=0;
        }

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        ans1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStatus(1);
                updateView();
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        ans2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStatus(2);
                updateView();
            }
        });

    }
    private void updateStatus(int ans){
        if(index==0&& ans==1){
            index=2;
        }else if(index==0&& ans==2){
            index=1;
        }else if(index==1&& ans==1){
            index=2;
        }else if(index==1&& ans==2){
            index=3;
        }else if(index==2&& ans==1){
            index=5;
        }else if(index==2&& ans==2){
            index=4;
        }

    }
    private void updateView(){
        storyText.setText(mStories[index].getStoryID());
        if(mStories[index].getAns1ID()!=0){//for Button1
            ans1Button.setText(mStories[index].getAns1ID());
        }
        else{
            ans1Button.setVisibility(View.GONE);
        }
        if(mStories[index].getAns2ID()!=0){//for Button2
            ans2Button.setText(mStories[index].getAns2ID());
        }
        else{
            ans2Button.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("index",index);
        super.onSaveInstanceState(outState);
    }
}
