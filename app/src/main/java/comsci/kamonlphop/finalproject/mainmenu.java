package comsci.kamonlphop.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class mainmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);


    }

    public void clickbacktomenu(){
        finish();
    }
    public void network(){
        Intent intentnetwork = new Intent(mainmenu.this,network.class);
        startActivity(intentnetwork);
    }
    public void data(){
        Intent intentdata = new Intent(mainmenu.this,database.class);
        startActivity(intentdata);

    }
    public void multi(){
        Intent intentmulti = new Intent(mainmenu.this,multi.class);
        startActivity(intentmulti);
    }
}
