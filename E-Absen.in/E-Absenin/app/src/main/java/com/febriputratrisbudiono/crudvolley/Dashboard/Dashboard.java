package com.febriputratrisbudiono.crudvolley.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.febriputratrisbudiono.crudvolley.Dashboard.DataObjek;
import com.febriputratrisbudiono.crudvolley.Anggota.Lihat_data;
import com.febriputratrisbudiono.crudvolley.Anggota.Tampil_data;
import com.febriputratrisbudiono.crudvolley.Login.SessionManager;
import com.febriputratrisbudiono.crudvolley.Profile.Profile;
import com.febriputratrisbudiono.crudvolley.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    TextView jabatan, users, jamkerja;
    int sum = 0;

    private static String URL_READ = "http://192.168.1.8/volley/read_detail.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        users = findViewById(R.id.users);

        tampil_data();
    }

    void tampil_data(){
        String url = "http://192.168.1.8/volley/dashboard.php";
        StringRequest request = new StringRequest(Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            for (int i=0; i<jsonArray.length(); i++) {
                                JSONObject getData = jsonArray.getJSONObject(i);
                                String getUsers = getData.getString("users");
                                users.setText(getUsers);
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
        );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}

class Adapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<DataObjek> model;
    public Adapter(Context context, ArrayList<DataObjek>model){
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.model = model;
    }

    @Override
    public int getCount() {
        return model.size();
    }

    @Override
    public Object getItem(int position) {
        return model.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    TextView users;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.dashboard, parent, false);
        users = view.findViewById(R.id.users);

        users.setText(model.get(position).getUsers());
        return view;
    }
}