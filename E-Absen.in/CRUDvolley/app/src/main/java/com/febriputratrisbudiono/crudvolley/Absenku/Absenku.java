package com.febriputratrisbudiono.crudvolley.Absenku;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.febriputratrisbudiono.crudvolley.Absen.Absen;
import com.febriputratrisbudiono.crudvolley.Login.SessionManager;
import com.febriputratrisbudiono.crudvolley.Profile.Profile;
import com.febriputratrisbudiono.crudvolley.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Absenku extends AppCompatActivity{

    private static final String TAG = Profile.class.getSimpleName(); //getting the info
    ArrayList<DataObjekAbsenku> list;
    ListView listView;
    SessionManager sessionManager;
    String getId;
    TextView id, id_user;

    private static String URL_READ = "http://workshopjti.com/e-absenin/app/Http/Controllers/volley/profile.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.absenku);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        HashMap<String, String> user = sessionManager.getUserDetail();
        getId = user.get(sessionManager.ID);

        id = findViewById(R.id.id);

        listView = findViewById(R.id.listview);
        absenku();

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
                            Toast.makeText(Absenku.this, "Error Reading Detail "+e.toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(Absenku.this, "Error Reading Detail "+error.toString(), Toast.LENGTH_SHORT).show();
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

    void absenku(){
        list = new ArrayList<>();
        String url = "http://workshopjti.com/e-absenin/app/Http/Controllers/volley/absenku.php";
        StringRequest request = new StringRequest(Request.Method.GET,
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

//    void absenku() {
//        String url = "http://workshopjti.com/e-absenin/app/Http/Controllers/volley/absensi.php";
//        StringRequest respon = new StringRequest(
//                Request.Method.POST,
//                url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//                            String status = jsonObject.getString("status");
//                            if (status.equals("oke"))
//                            {
//                                AlertDialog.Builder builder = new AlertDialog.Builder(Absenku.this);
//                                builder.setTitle("Sukses");
//                                builder.setMessage("Data Sukses Tersimpan");
//                                builder.setPositiveButton("oke", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        dialog.dismiss();
//                                        finish();
//                                    }
//                                });
//                                AlertDialog dialog = builder.create();
//                                dialog.show();
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
//                    }
//                }
//        ){
//            @Nullable
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> form = new HashMap<>();
//                form.put("id", id.getText().toString());
//                return form;
//            }
//        };
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(respon);
//    }

}