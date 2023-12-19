package com.example.logowanie;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class activity_welcome extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        progressBar = findViewById(R.id.progressBar);

        Button buttonLogout = findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Rozpocznij AsyncTask do symulacji wylogowywania
                new LogoutTask().execute();
            }
        });
    }

    private class LogoutTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected void onPreExecute() {
            // Wyświetl ProgressBar przed rozpoczęciem wylogowywania
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            // Tutaj dodaj kod do faktycznego wylogowywania (np. wywołaj odpowiednie API)

            // Zwróć true, jeśli wylogowanie powiodło się (tutaj możesz dodać warunki)
            return true;
        }

        @Override
        protected void onPostExecute(Boolean success) {
            // Ukryj ProgressBar po zakończeniu wylogowywania
            progressBar.setVisibility(View.GONE);

            // Wyświetl komunikat sukcesu lub niepowodzenia
            if (success) {
                Toast.makeText(activity_welcome.this, "Logout successful", Toast.LENGTH_SHORT).show();

                // Przenieś się na ekran logowania (MainActivity)
                Intent intent = new Intent(activity_welcome.this, MainActivity.class);
                startActivity(intent);

                // Zakończ obecną aktywność
                finish();

            }
        }
    }
}
