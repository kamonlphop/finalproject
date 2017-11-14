package comsci.kamonlphop.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import comsci.kamonlphop.finalproject.Adapter.AdapterNetwork;

public class network extends AppCompatActivity {

    private LessonTABLE objLessonTABLE;
    private ListView networkListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        Bindwidget();
        cdatabase();
        creatlist();
    }

    private void creatlist() {
        AdapterNetwork objAdapterNetwork = new AdapterNetwork();
    }

    private void cdatabase() {
        objLessonTABLE = new LessonTABLE(this);
    }

    private void Bindwidget() {
        networkListView = (ListView) findViewById(R.id.idlistnet);

    }

    public void back(){
        finish();
    }
}
