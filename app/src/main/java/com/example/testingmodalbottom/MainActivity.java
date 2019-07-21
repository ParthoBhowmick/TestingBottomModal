package com.example.testingmodalbottom;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements TestFragment.OnFragmentInteractionListener,ExampleBottomSheetDialog.BottomSheetListener {

    Fragment fragment;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        fragment = manager.findFragmentById(R.id.frameContainer);
        if(fragment==null) {
            fragment = new TestFragment();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.frameContainer,fragment);
            transaction.commit();
        }
    }

    public void callFunc() {
        ExampleBottomSheetDialog bottomSheet = new ExampleBottomSheetDialog();
        bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onButtonClicked(String text) {
        manager = getSupportFragmentManager();
        fragment = (TestFragment) manager.findFragmentById(R.id.frameContainer);
        ((TestFragment) fragment).fragFunc(text);
    }

}