package comsci.kamonlphop.finalproject;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ebookhome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebookhome);
    }

    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                tab1 tab1 = new tab1();
                return tab1;
            case 1:
                tap2 tap2 = new tap2();
                return tap2;
            case 2:
                tap3 tap3 = new tap3();
                return tap3;
            default:
                return null;

        }
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "contacte";
            case 1:
                return "chat";
            case 2:
                return "online";
        }
            return null;
    }


}//end
