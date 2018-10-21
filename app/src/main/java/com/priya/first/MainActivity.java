package com.priya.first;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    TextView total;
    EditText percen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /*final TextView totalTextView = (TextView) findViewById(R.id.res);
        final EditText percentage_text = (EditText) findViewById(R.id.percentage_text);*/

        final Button post = (Button) findViewById(R.id.calc_button);
        Button whatsapp = (Button) findViewById(R.id.whatsapp_button);
        final TextView mTextView = (TextView) findViewById(R.id.text);

        final String toNumber = "17203458680";
        final String text = "Hi. I am at the accident spot! What can I help with ?";

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                float percentage = Float.parseFloat(percentage_text.getText().toString());
                String res;
                if(percentage > 50)
                    res = "more";
                else
                    res = "less";
                totalTextView.setText(res);*/

                try {

                    final TextView mTextView = (TextView) findViewById(R.id.text);
// ...

// Instantiate the RequestQueue.
                    RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                    String url ="http://www.google.com";

// Request a string response from the provided URL.
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    // Display the first 500 characters of the response string.
                                    mTextView.setText("Response is: "+ response.substring(0,500));
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            mTextView.setText("That didn't work!");
                        }
                    });

// Add the request to the RequestQueue.
                    queue.add(stringRequest);
                }
                catch (Exception e){
                    e.printStackTrace();
                }


            }
        });



        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                float percentage = Float.parseFloat(percentage_text.getText().toString());
                String res;
                if(percentage > 50)
                    res = "more";
                else
                    res = "less";
                totalTextView.setText(res);*/

                try {

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
                    startActivity(intent);
                }
                catch (Exception e){
                    e.printStackTrace();
                }


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
