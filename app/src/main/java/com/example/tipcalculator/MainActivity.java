package com.example.tipcalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText billAmount, noOfPeople;

    private TextView totalAmount,tipAmount,perPerson;
    private Spinner tipRate;
    private Button calculate;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billAmount =findViewById(R.id.editTextAmount);
        noOfPeople=findViewById(R.id.noOfMembers);
        tipRate=findViewById(R.id.spinnerTIpRate);
        calculate=findViewById(R.id.buttonCalculate);
        totalAmount=findViewById(R.id.TotalAmount);
        tipAmount=findViewById(R.id.TipAmount);
        perPerson =findViewById(R.id.perPerson);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double amount =Double.parseDouble(billAmount.getText().toString());
                int peopleCount = Integer.parseInt(noOfPeople.getText().toString());
                double tipPercentage = Double.parseDouble(tipRate.getSelectedItem().toString());

                if(amount==0||peopleCount==0||tipPercentage==0){
                    Toast.makeText(MainActivity.this,"Please Provide all the information Correctly",Toast.LENGTH_SHORT).show();
                    return;
                }

                double tip = amount*tipPercentage/100;
                double total = amount+tip;
                double perPersonCount= total/peopleCount;


                totalAmount.setText("The Total Amount is: "+String.valueOf(total));
                tipAmount.setText("The Tip Amount is: "+String.valueOf(tip));
                perPerson.setText("Per Person Amount is:"+String.valueOf(perPersonCount));


                billAmount.setText("");
                noOfPeople.setText("");


            }
        });



    }
}