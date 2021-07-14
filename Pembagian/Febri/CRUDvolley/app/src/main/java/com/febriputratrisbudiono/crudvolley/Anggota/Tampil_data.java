package com.febriputratrisbudiono.crudvolley.Anggota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.febriputratrisbudiono.crudvolley.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Tampil_data extends AppCompatActivity {

    ArrayList<DataObjek> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampil_data);
        listView = findViewById(R.id.listview);
        tampil_data();
    }

    void tampil_data(){
        list = new ArrayList<>();
        String url = "http://192.168.1.5/volley/read.php";
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
                                String nama = getData.getString("nama_mahasiswa");
                                String jenis_kelamin = getData.getString("jenis_kelamin");
                                String kelas = getData.getString("kelas");
                                String no_handphone = getData.getString("no_handphone");
                                list.add(new DataObjek(nama,kelas,no_handphone,jenis_kelamin));
                            }
                            Adapter adapter = new Adapter(Tampil_data.this, list);
                            listView.setAdapter(adapter);

                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getApplicationContext(), Lihat_data.class);

                                    intent.putExtra("nama", list.get(position).getNama());
                                    intent.putExtra("kelas", list.get(position).getKelas());
                                    intent.putExtra("jenis_kelamin", list.get(position).getJenis_kelamin());
                                    intent.putExtra("no_handphone", list.get(position).getNo_handphone());

                                    startActivity(intent);
                                }
                            });

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

    TextView nama, jenis_kelamin, kelas, no_handphone;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.list_data, parent, false);
        nama = view.findViewById(R.id.nama);
        jenis_kelamin = view.findViewById(R.id.jenis_kelamin);
        kelas = view.findViewById(R.id.kelas);
        no_handphone = view.findViewById(R.id.no_handphone);

        nama.setText(model.get(position).getNama());
        jenis_kelamin.setText(model.get(position).getJenis_kelamin());
        kelas.setText(model.get(position).getKelas());
        no_handphone.setText(model.get(position).getNo_handphone());
        return view;
    }
}