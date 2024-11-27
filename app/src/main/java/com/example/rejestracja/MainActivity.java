package com.example.rejestracja;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private TextView Komunikat;
    private EditText Email;
    private EditText Haslo;
    private EditText PHaslo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Komunikat = findViewById(R.id.Comm);
        Email = findViewById(R.id.Mail);
        Haslo = findViewById(R.id.Pass1);
        PHaslo = findViewById(R.id.Pass2);
        Button Przycisk = findViewById(R.id.Przycisk);

        Przycisk.setOnClickListener(v -> walidacja());
    }

    private void walidacja() {
        String Mail = Email.getText().toString().trim();
        String Pass = Haslo.getText().toString().trim();
        String PassC = PHaslo.getText().toString().trim();

        if (Mail.isEmpty()) {
            Komunikat.setText("Proszę wprowadzić adres e-mail");
        } else if (!Mail.contains("@")) {
            Komunikat.setText("Niepoprawny adres e-mail");
        } else if (Pass.isEmpty()) {
            Komunikat.setText("Proszę wprowadzić hasło");
        } else if (PassC.isEmpty()) {
            Komunikat.setText("Proszę powtórzyć hasło");
        } else if (!Pass.equals(PassC)) {
            Komunikat.setText("Hasła się różnią");
        } else
            Komunikat.setText("Witaj " + Mail);
    }
}