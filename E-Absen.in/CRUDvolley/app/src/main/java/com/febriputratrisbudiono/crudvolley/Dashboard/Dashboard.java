package com.febriputratrisbudiono.crudvolley.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.febriputratrisbudiono.crudvolley.R;

import org.json.JSONException;
import org.json.JSONObject;

public class Dashboard extends AppCompatActivity {

    TextView jabatans, users, jamkerja_start, jamkerja_finish;
    int sum = 0;

    private static String URL_READ = "http://workshopjti.com/e-absenin/app/Http/Controllers/volley/read_detail.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        users = findViewById(R.id.users);
        jabatans = findViewById(R.id.jabatans);
        jamkerja_start = findViewById(R.id.jamkerja_start);
        jamkerja_finish = findViewById(R.id.jamkerja_finish);

        tampil_data();
    }

    private void tampil_data(){
        AndroidNetworking.get("http://workshopjti.com/e-absenin/app/Http/Controllers/volley/dashboard.php")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            users.setText(response.getString("users"));
                            jabatans.setText(response.getString("jabatans"));
                            jamkerja_start.setText(response.getString("jamkerja_start"));
                            jamkerja_finish.setText(response.getString("jamkerja_finish"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        //handle error
                    }
                });
    }
}