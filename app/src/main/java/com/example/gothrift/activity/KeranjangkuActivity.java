package com.example.gothrift.activity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import com.example.gothrift.R;

public class KeranjangkuActivity extends AppCompatActivity {

    Button show;
    BottomSheetDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjangku);

        show = findViewById(R.id.show);

        dialog = new BottomSheetDialog(this);
        // inflate view
        CreateDialog();

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    private void CreateDialog() {
        View view = getLayoutInflater().inflate(R.layout.checkout_activity, null, false);

        Button submit = view.findViewById(R.id.btnSubmit);
        EditText name = view.findViewById(R.id.name);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(KeranjangkuActivity.this, name.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setContentView(view);
    }
}