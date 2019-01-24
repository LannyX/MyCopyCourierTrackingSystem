package com.rjt.b16couriertrackingsystem.termncondition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.rjt.b16couriertrackingsystem.R;
import com.rjt.b16couriertrackingsystem.countrylist.CountryListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TermConditionScreenActivity extends AppCompatActivity {

    @BindView(R.id.textView2)
    TextView termConditionTitle;
    @BindView(R.id.checkBox)
    CheckBox checkBoxAccept;
    @BindView(R.id.button)
    Button buttonAccpet;
    @BindView(R.id.textView3)
    TextView termConditionBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_condition_screen);
        ButterKnife.bind(this);

        termConditionTitle.setText("Terms and Conditions (\"Terms\")");
        termConditionBody.setText("Please read these Terms and Conditions (\"Terms\", \"Terms and Conditions\") carefully before using the mobile application (the \"Service\") operated by us.\n" +
                "\n" +
                "Your access to and use of the Service is conditioned on your acceptance of and compliance with these Terms. These Terms apply to all visitors, users and others who access or use the Service.\n" +
                "\n" +
                "By accessing or using the Service you agree to be bound by these Terms. If you disagree with any part of the terms then you may not access the Service.\n");


    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        if(checkBoxAccept.isChecked()){
            Intent i = new Intent(this, CountryListActivity.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "Please confirm to proceed", Toast.LENGTH_SHORT).show();

        }
    }

//    public void onCheckboxClicked(View view) {
//        boolean checked = ((CheckBox) view).isChecked();
//        if (checked){
//
//        }else {
//        }
//
//    }

}
