package com.febriputratrisbudiono.crudvolley.Absenku;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

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

public class Absenku extends AppCompatActivity{

    ArrayList<DataObjekAbsenku> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.absenku);

        listView = findViewById(R.id.listview);
        absenku();

    }

    void absenku(){
        list = new ArrayList<>();
        String url = "http://192.168.1.14/volley/absenku.php";
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
                                String tgl = getData.getString("tgl");
                                String waktu = getData.getString("waktu");
                                String keterangan = getData.getString("keterangan");
                                String id_user = getData.getString("id_user");
                                String longlat = getData.getString("longlat");
                                list.add(new DataObjekAbsenku(tgl,waktu,keterangan,id_user,longlat));
                            }
                            Adapter adapter = new Adapter(Absenku.this, list);
                            listView.setAdapter(adapter);

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
    ArrayList<DataObjekAbsenku> model;
    public Adapter(Context context, ArrayList<DataObjekAbsenku>model){
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

    TextView tgl, waktu, keterangan, id_user, longlat;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.list_data_absenku, parent, false);
        tgl = view.findViewById(R.id.tgl);
        waktu = view.findViewById(R.id.waktu);
        keterangan = view.findViewById(R.id.keterangan);
        id_user = view.findViewById(R.id.id_user);
        longlat = view.findViewById(R.id.longlat);

        tgl.setText(model.get(position).getTgl());
        waktu.setText(model.get(position).getWaktu());
        keterangan.setText(model.get(position).getKeterangan());
        id_user.setText(model.get(position).getId_user());
        longlat.setText(model.get(position).getLonglat());
        return view;
    }
}