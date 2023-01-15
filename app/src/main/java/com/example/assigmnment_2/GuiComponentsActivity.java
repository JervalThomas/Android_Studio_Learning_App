package com.example.assigmnment_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterViewAnimator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class GuiComponentsActivity extends AppCompatActivity {
    Button pickDateBtn;
    TextView selectedDateTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_components);

        pickDateBtn = findViewById(R.id.idBtnPickDate);
        selectedDateTV = findViewById(R.id.idTVSelectedDate);

        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        pickDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog dialog = new DatePickerDialog(GuiComponentsActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        i1 = i1 + 1;
                        String date = i2+"/" + i1 + "/" + i;
                        selectedDateTV.setText(date);
                    }
                },year,month,day);
                dialog.show();
                Toast.makeText(GuiComponentsActivity.this, "DatePicker Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        NumberPicker numberPicker = findViewById(R.id.number_Picker);
        TextView textView = findViewById(R.id.numberPickerText) ;

        numberPicker.setMaxValue(100);
        numberPicker.setMinValue(0);
        textView.setText(String.format("User's number: %s",numberPicker.getValue()));
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                textView.setText(String.format("User's number: %s",i1));
            }
        });

        int[] images={R.drawable.pie, R.drawable.oreo, R.drawable.nougat, R.drawable.marshmellow, R.drawable.lollipop, R.drawable.kitkat};

        ViewAnimator simpleViewAnimator = findViewById(R.id.viewAnimator);

        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(getApplicationContext()); // create a new object  for ImageView
            imageView.setImageResource(images[i]);
            simpleViewAnimator.addView(imageView);
        }

        Button button1 = findViewById(R.id.prev);
        Button button3 = findViewById(R.id.next);

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        simpleViewAnimator.setOutAnimation(out);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleViewAnimator.setInAnimation(in);
                simpleViewAnimator.showPrevious();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleViewAnimator.setOutAnimation(out);
                simpleViewAnimator.showNext();
            }
        });

        Button buttonPB = findViewById(R.id.progressbar_btn);

        buttonPB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(GuiComponentsActivity.this);
                dialog.setContentView(R.layout.progress_bar);
                dialog.show();
            }
        });

        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add("Grapes");
        list.add("Pear");
        ListView view = findViewById(R.id.listView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        view.setAdapter(arrayAdapter);

    }
}