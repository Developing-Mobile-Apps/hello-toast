package com.example.hellotoast;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button buttonZero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get view reference
        mShowCount = findViewById(R.id.show_count);
        buttonZero = findViewById(R.id.button_zero);

        // set background to gray
        buttonZero.setBackgroundColor(Color.GRAY);
    }

    // display a toast message
    public void showToast(View view) {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show();
    }

    // reset count value to zero
    public void resetCount(View view) {
        mCount = 0;
        showCount();
        view.setBackgroundColor(Color.GRAY);
    }

    // increment count by one
    public void countUp(View view) {
        ++mCount;
        showCount();
        if (isCountEven()) {
            view.setBackgroundColor(Color.GREEN);
        } else {
            view.setBackgroundColor(Color.RED);
        }
        buttonZero.setBackgroundColor(Color.MAGENTA);
    }

    // set the text in show_count TextView to the value of mCount
    private void showCount() {
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    // check if count is even
    private boolean isCountEven() {
        return (mCount % 2) == 0;
    }
}