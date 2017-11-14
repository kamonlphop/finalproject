package comsci.kamonlphop.finalproject;
import android.content.Context;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AlertDialog;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by USER on 14/11/2560.
 */

public class tab1 extends Fragment {

    private LessonTABLE objLessonTABLE;
    private ListView listView ;



    public tab1() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        return inflater.inflate(R.layout.tabnetwork,container,false);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bindwidget();
        Cdaabase();
        createListview();
    }

    private void createListview() {

    }

    private void Cdaabase() {

        objLessonTABLE = new LessonTABLE(getContext());
    }

    private void Bindwidget() {

    }
}
