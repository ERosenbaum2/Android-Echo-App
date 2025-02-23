package com.example.echoapp;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import com.example.echoapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Snackbar mSnackBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        setupSnackbar();
        binding.fab.setOnClickListener(this::handleFabClick);
    }

    private void setContentView() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    private void setupSnackbar() {
        View rootView = findViewById(android.R.id.content);
        mSnackBar = Snackbar.make(rootView, "", Snackbar.LENGTH_INDEFINITE);
        mSnackBar.setAnchorView(binding.fab);
    }

    private void handleFabClick(View view) {
        String inputText = binding.contentMain.etInput.getText().toString().trim();
        binding.contentMain.tvOutput.setText(inputText);

        mSnackBar.setText("You typed: " + inputText);
        mSnackBar.show();
    }
}