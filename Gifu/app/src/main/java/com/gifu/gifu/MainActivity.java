package com.gifu.gifu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResponse;
    private ImageView imageResponse;
    private Button buttonFindGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Relaciona variáveis locals com componentes visuais
        this.imageResponse = (ImageView) findViewById(R.id.imageView);
        this.textViewResponse = (TextView) findViewById(R.id.textViewResponse);
        this.buttonFindGif = (Button) findViewById(R.id.buttonProcurarGif);


        buttonFindGif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findRandomGif();
            }
        });

        //Carrega um novo gif aleatório
        findRandomGif();
    }

    public void setGifIntoImage(String url) {
        Glide.with(this) // replace with 'this' if it's in activity
                .load(url)
                .asGif()
//                .error(R.drawable.) // show error drawable if the image is not a gif
                .into(this.imageResponse);
    }

    public void findRandomGif() {
        String url = "http://api.giphy.com/v1/gifs/random?api_key=dc6zaTOxFJmzC";

        Response.Listener<JSONObject> responseListener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    //Seta log de erro para vazio
                    textViewResponse.setText("");
                    if(response != null && response.length() > 0) {
                        JSONObject data = response.getJSONObject("data");

                        //Pega url do gif de tamanho fixo
                        String gifUrl = data.getString("fixed_width_downsampled_url");

                        //Seta url do gif para aparecer no imageView
                        setGifIntoImage(gifUrl);

                    } else { textViewResponse.setText("Nenhum gif foi encontrado."); }
                } catch (Exception e) { textViewResponse.setText("ERRO: " + e.getMessage()); }
            }
        };
        Response.ErrorListener responseErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) { textViewResponse.setText("ERRO: " + error.getMessage()); }
        };
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, responseListener, responseErrorListener);

        RestRequestManager.getInstance(MainActivity.this).addToRequestQueue(jsObjRequest);
    }
}
