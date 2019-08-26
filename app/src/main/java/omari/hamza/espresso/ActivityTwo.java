package omari.hamza.espresso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import omari.hamza.espresso.databinding.ActivityTwoBinding;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTwoBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_two);
        mBinding.setMessage(getIntent().getStringExtra("message"));
    }
}
