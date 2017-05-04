package comsci.kamonlphop.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void clickbackmain(View view) {
        finish();
    }


    public void onClicklo (View view) {
        Intent intent = new Intent(register.this, MainActivity.class);
        startActivity(intent);
    }
}
