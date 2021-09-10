package com.example.videoeditor;

import android.os.Bundle;

import com.example.videoeditor.base.viewbinding.BaseActivityBinding;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewbinding.ViewBinding;

import com.example.videoeditor.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivityBinding<ActivityMainBinding> {

    private ActivityMainBinding binding;

    @Override
    protected ViewBinding binding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews(Bundle bundle) {
    }

}