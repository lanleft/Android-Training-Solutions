package com.example.homework;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        Log.v("TAG","id :" + id);
        new GetInformation().execute(id);

    }

    class GetInformation extends AsyncTask<Integer, Void, JSONObject>{

        @Override
        protected JSONObject doInBackground(Integer... value) {
            try {
                URL url = new URL("https://lebavui.github.io/jsons/users.json");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                String line;
                StringBuilder builder = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                while ((line = reader.readLine()) != null){
                    builder.append(line);
                }

                reader.close();

                String jsonString = builder.toString();
                JSONArray jarr = new JSONArray(jsonString);

                JSONObject jobj = jarr.getJSONObject(value[0]);
                return jobj;

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            ImageView imageAvatar = findViewById(R.id.avatar);
            TextView textUsername = findViewById(R.id.username);
            TextView textName = findViewById(R.id.text_name);
            TextView textEmail = findViewById(R.id.text_email);
            TextView textAddress = findViewById(R.id.text_address);
            TextView textPhone = findViewById(R.id.text_phone);
            TextView textCompany = findViewById(R.id.text_company);
            try {
                JSONObject javatar = jsonObject.getJSONObject("avatar");
                JSONObject jaddress = jsonObject.getJSONObject("address");
                JSONObject jcompany = jsonObject.getJSONObject("company");
                String username = jsonObject.getString("username");
                String name = jsonObject.getString("name");
                String email = jsonObject.getString("email");
                String avatar = "https://lebavui.github.io" + javatar.getString("photo");
                Log.v("Tag", avatar);
                String address = jaddress.getString("city") + " " + jaddress.getString("street") + " " + jaddress.getString("suite");
                String phone = jsonObject.getString("phone");
                String company = jcompany.getString("name");

                Picasso.get().load(avatar).into(imageAvatar);
                textUsername.setText(username);
                textName.setText(name);
                textEmail.setText(email);
                textAddress.setText(address);
                textCompany.setText(company);
                textPhone.setText(phone);

            } catch (Exception e) {
                e.printStackTrace();
            }



        }
    }

}