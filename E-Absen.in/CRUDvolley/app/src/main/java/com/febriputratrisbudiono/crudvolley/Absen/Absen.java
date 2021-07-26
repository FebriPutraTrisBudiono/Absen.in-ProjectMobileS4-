package com.febriputratrisbudiono.crudvolley.Absen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.febriputratrisbudiono.crudvolley.Absenku.Absenku;
import com.febriputratrisbudiono.crudvolley.Login.SessionManager;
import com.febriputratrisbudiono.crudvolley.MainActivity;
import com.febriputratrisbudiono.crudvolley.Profile.Profile;
import com.febriputratrisbudiono.crudvolley.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Absen extends AppCompatActivity implements LocationListener{

    private static final String TAG = Profile.class.getSimpleName(); //getting the info
    TextView id_user, waktu, tgl, text_location, keterangan, created_at, updated_at, id;
    SessionManager sessionManager;
    String getId;
    LocationManager locationManager;
//    EditText tgl, waktu, keterangan, id_user, longlat;
    Button btn_masuk, btn_pulang, btn_longlat;

    private static String URL_READ = "http://workshopjti.com/e-absenin/app/Http/Controllers/volley/profile.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.absen);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        id = findViewById(R.id.id);

        waktu = findViewById(R.id.waktu);
        tgl = findViewById(R.id.tgl);
        text_location = findViewById(R.id.text_location);
        keterangan = findViewById(R.id.keterangan);
        created_at = findViewById(R.id.created_at);
        updated_at = findViewById(R.id.updated_at);

        waktu.setText(getCurrentTime());
        tgl.setText(getCurrentDate());
        created_at.setText(getCurrentandDate());
        updated_at.setText(getCurrentandDate());

        HashMap<String, String> user = sessionManager.getUserDetail();
        getId = user.get(sessionManager.ID);

        btn_masuk = findViewById(R.id.btn_masuk);
        btn_longlat = findViewById(R.id.btn_longlat);

        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
                input_data();
            }
        });

        btn_longlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
            }
        });

        //Runtime permissions
        if (ContextCompat.checkSelfPermission(Absen.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Absen.this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            },100);
        }
    }

    //location
    @SuppressLint("MissingPermission")
    private void getLocation() {

        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,5, (LocationListener) Absen.this);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onLocationChanged(Location location) {
        text_location.setText(location.getLatitude()+", "+location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    // waktu dan tanggal
    private String getCurrentTime(){
        return new SimpleDateFormat("kk:mm:ss", Locale.getDefault()).format(new Date());
    }

    private String getCurrentDate(){
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }

    private String getCurrentandDate(){
        return new SimpleDateFormat("yyyy-MM-dd kk:mm:ss", Locale.getDefault()).format(new Date());
    }

    void input_data() {
        String url = "http://workshopjti.com/e-absenin/app/Http/Controllers/volley/absensi.php";
        StringRequest respon = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");
                            if (status.equals("oke"))
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Absen.this);
                                builder.setTitle("Sukses");
                                builder.setMessage("Data Sukses Tersimpan");
                                builder.setPositiveButton("oke", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        finish();
                                    }
                                });
                                AlertDialog dialog = builder.create();
                                dialog.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> form = new HashMap<>();
                form.put("waktu", waktu.getText().toString());
                form.put("tgl", tgl.getText().toString());
                form.put("keterangan", keterangan.getText().toString());
                form.put("longlat", text_location.getText().toString());
                form.put("id_user", id.getText().toString());
                form.put("created_at", created_at.getText().toString());
                form.put("updated_at", updated_at.getText().toString());
                return form;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(respon);
    }

    //getUserDetail
    private void getUserDetail(){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_READ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        Log.i(TAG, response.toString());

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("read");

                            if (success.equals("1")){

                                for (int i =0; i < jsonArray.length(); i++){

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String strId = object.getString("id").trim();

                                    id.setText(strId);
                                }

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDialog.dismiss();
                            Toast.makeText(Absen.this, "Error Reading Detail "+e.toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(Absen.this, "Error Reading Detail "+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String > params = new HashMap<>();
                params.put("id", getId);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getUserDetail();
    }
}