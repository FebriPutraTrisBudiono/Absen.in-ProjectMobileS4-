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
        String url = "http://workshopjti.com/e-absenin/app/Http/Controllers/volley/anggota.php";
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
                                String name = getData.getString("name");
                                String jabatan = getData.getString("jabatan");
                                String no_telepon = getData.getString("no_telepon");
                                String alamat = getData.getString("alamat");
                                list.add(new DataObjek(name,jabatan,no_telepon,alamat));
                            }
                            Adapter adapter = new Adapter(Tampil_data.this, list);
                            listView.setAdapter(adapter);

                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getApplicationContext(), Lihat_data.class);

                                    intent.putExtra("name", list.get(position).getName());
                                    intent.putExtra("jabatan", list.get(position).getJabatan());
                                    intent.putExtra("no_telepon", list.get(position).getNo_telepon());
                                    intent.putExtra("alamat", list.get(position).getAlamat());

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

    TextView name, jabatan, no_telepon, alamat;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.list_data, parent, false);
        name = view.findViewById(R.id.name);
        jabatan = view.findViewById(R.id.jabatan);
        no_telepon = view.findViewById(R.id.no_telepon);
        alamat = view.findViewById(R.id.alamat);

        name.setText(model.get(position).getName());
        jabatan.setText(model.get(position).getJabatan());
        no_telepon.setText(model.get(position).getNo_telepon());
        alamat.setText(model.get(position).getAlamat());
        return view;
    }
}