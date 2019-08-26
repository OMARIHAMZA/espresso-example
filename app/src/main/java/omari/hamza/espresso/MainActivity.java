package omari.hamza.espresso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import omari.hamza.espresso.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Handlers {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setHandlers(this);
    }


    @Override
    public void launchNextActivity() {
        Intent intent = new Intent(this, ActivityTwo.class);
        intent.putExtra("message", mBinding.messageEditText.getText().toString());
        startActivity(intent);
    }
}
