package omari.hamza.espresso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import omari.hamza.espresso.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Handlers {

    private ActivityMainBinding mBinding;
    private final String[] entries = {"Home", "Work", "Personal", "Other"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setHandlers(this);
        mBinding.setEntries(entries);
        mBinding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String data = "Phone: " + mBinding.phoneEditText.getText().toString() + " - " + entries[i];
                Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                mBinding.phoneTextView.setText(data);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    @Override
    public void launchNextActivity() {
        Intent intent = new Intent(this, ActivityTwo.class);
        intent.putExtra("message", mBinding.messageEditText.getText().toString());
        startActivity(intent);
    }

    public String[] getEntries() {
        return entries;
    }
}
