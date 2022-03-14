package com.example.mypicker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.app.Activity;
import java.util.Calendar;

    public class MainActivity extends AppCompatActivity {
        private TextView time;
        private Calendar calendar;
        private String format="";
        private TimePicker timePicker1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            timePicker1=(TimePicker)findViewById(R.id.timePicker1);
            calendar=Calendar.getInstance();
            int hour=calendar.get(Calendar.HOUR_OF_DAY);
            int min=calendar.get(Calendar.MINUTE);

        }
        public void setTime(View view)
        {
            int hour=timePicker1.getCurrentHour();
            int min=timePicker1.getCurrentMinute();
            showTime(hour,min);
        }

        private void showTime(int hour, int min) {
            if (hour==0)
            {
                hour+=12;
                format="AM";

            }
            else if(hour==12)
            {
                format="PM";
            }
            else if (hour>12)
            {
                hour-=12;
                format="PM";
            }
            else
            {
                format="AM";
            }
            time.setText(new StringBuilder().append(hour).append(":").append(min).append("").append(format));
        }
    }
