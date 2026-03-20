package com.example.a10pr_03;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AlertDialog(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setNegativeButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    EditText fio;
    EditText phone;
    EditText adress;

    private boolean isPhoneValid(String phoneNumber) {
        String phonePattern = "^\\+8 \\(9\\d{2}\\)-\\d{3}-\\d{2}-\\d{2}$";
        return phoneNumber.matches(phonePattern);
    }

    public void OnArrange(View view){
        fio = findViewById(R.id.etName);
        phone = findViewById(R.id.etPhone);
        adress = findViewById(R.id.etAddress);
        String phoneText = phone.getText().toString().trim();

        if(fio.getText().length() == 0) AlertDialog("!ВНИМАНИЕ!", "ВВЕДИ ФИО, НАМ НЕЧЕГО КРАСТЬ.!");
        else if (phone.getText().length() == 0) AlertDialog("!ВНИМАНИЕ!", "ВВЕДИ НОМЕР, НАМ НЕЧЕГО КРАСТЬ.!");
        else if (!isPhoneValid(phoneText)) {
            AlertDialog("!ВНИМАНИЕ!", "ВВЕДИ НОМЕР В ФОРМАТЕ:\n+8 (912)-345-67-89\nНАМ НЕЧЕГО КРАСТЬ.!");
        }
        else if (adress.getText().length() == 0) AlertDialog("!ВНИМАНИЕ!", "ВВЕДИ АДРЕС, НАМ НЕЧЕГО КРАСТЬ.!");

        else {
            AlertDialog("Mission Complete", "Данные успешно украдены)");
        }
    }
}