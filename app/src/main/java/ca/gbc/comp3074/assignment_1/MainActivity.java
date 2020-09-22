package ca.gbc.comp3074.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtHours,txtRate;
    private Button btnCalc;
    private TextView viewPay, viewOT, viewTotPay,viewTax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtHours=findViewById(R.id.txthrs);
        txtRate=findViewById(R.id.txtRate);
        btnCalc=findViewById(R.id.btnCalc);
        viewPay=findViewById(R.id.lblPay);
        viewOT=findViewById(R.id.lblOT);
        viewTotPay=findViewById(R.id.lblTotPay);
        viewTax=findViewById(R.id.lblTax);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double pay = 0.0,ot=0.0,tax=0.0;
                double hrs=Double.parseDouble(txtHours.getText().toString());
                double rate=Double.parseDouble(txtRate.getText().toString());
                if(hrs<=40) {
                    pay = hrs * rate;
                }
                if(hrs>40){
                    pay=40*rate;
                    ot=(hrs-40)*rate;
                }
                tax=(pay+ot)*.18;
                viewPay.setText(String.format("%.2f",pay));
                viewOT.setText(String.format("%.2f",ot));
                viewTotPay.setText(String.format("%.2f",(pay+ot)));
                viewTax.setText(String.format("%.2f",tax));
            }
        });
    }
}