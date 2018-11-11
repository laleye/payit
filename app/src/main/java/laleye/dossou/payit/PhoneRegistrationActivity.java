package laleye.dossou.payit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class PhoneRegistrationActivity extends AppCompatActivity {

    CountryCodePicker ccp;
    EditText phoneNumber ;
    Button get_verification_code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_registration);
        ccp = (CountryCodePicker) findViewById(R.id.ccp);
        phoneNumber = (EditText)findViewById(R.id.phoneNumber);
        ccp.registerCarrierNumberEditText(phoneNumber);
        get_verification_code = (Button)findViewById(R.id.get_registration_code);
        ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                Toast.makeText(PhoneRegistrationActivity.this, ccp.getSelectedCountryName(), Toast.LENGTH_SHORT).show();
            }
        });

        get_verification_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PhoneRegistrationActivity.this,ccp.getFullNumberWithPlus(),Toast.LENGTH_LONG).show();
            }
        });
    }


}
