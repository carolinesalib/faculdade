package com.gifu.gifu;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResponse;
    private ImageView imageResponse;
    private Button buttonProcurar;
    private Button buttonSalvar;
    private EditText editTextCategoria;

    private CategoriaData categoriaData;

    private static String[] FROM = {CategoriaTable._ID, CategoriaTable.NOME, CategoriaTable.USUARIO_ID};
    private static String ORDER_BY = CategoriaTable.NOME + " DESC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Relaciona variáveis locals com componentes visuais
        this.imageResponse = (ImageView) findViewById(R.id.imageView);
        this.textViewResponse = (TextView) findViewById(R.id.textViewResponse);
        this.buttonProcurar = (Button) findViewById(R.id.buttonProcurarGif);
        this.buttonSalvar = (Button) findViewById(R.id.buttonSalvarCategoria);
        this.editTextCategoria = (EditText) findViewById(R.id.editTextCategoria);

        this.categoriaData = new CategoriaData(getApplicationContext());

        buttonProcurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findRandomGif();
            }
        });

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarCategoria();
            }
        });

        imageResponse.setOnClickListener(new View.OnClickListener() {
            int i;
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                i++;
                Handler handler = new Handler();
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        i = 0;
                    }
                };

                if (i == 1) {
                    //Single click
                    handler.postDelayed(r, 250);
                } else if (i == 2) {
                    //Double click
                    i = 0;
                    zoom(v);
                }
            }
        });

        imageResponse.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clockWise(v);
                return false;
            }
        });

        //Carrega um novo gif aleatório
        findRandomGif();
    }

    public void salvarCategoria() {
        SQLiteDatabase db = categoriaData.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CategoriaTable.NOME, editTextCategoria.getText().toString());
//        values.put(CategoriaTable.USUARIO_ID, );

        db.insertOrThrow(CategoriaTable.TABLE_NAME, null, values);

        Cursor cursor = getCategorias();
        showCategorias(cursor);
    }

    private void showCategorias(Cursor cursor) {
        StringBuilder builder = new StringBuilder("Eventos salvos:\n");
        while (cursor.moveToNext()) {
            long id = cursor.getLong(0);
            String nome = cursor.getString(1);
            long idUsuario = cursor.getLong(2);

            builder.append(id).append(": ");
            builder.append(idUsuario).append(": ");
            builder.append(nome).append("\n");
        }
//        TextView textView = (TextView) findViewById(R.id.text);
//        textView.setText(builder);
        System.out.println(builder);
    }

    private Cursor getCategorias() {
        SQLiteDatabase db = categoriaData.getReadableDatabase();

        Cursor cursor = db.query(CategoriaTable.TABLE_NAME, FROM, null, null, null, null, ORDER_BY);
        startManagingCursor(cursor);
        return cursor;
    }
    public void setGifIntoImage(String url) {
        Glide.with(this) // replace with 'this' if it's in activity
                .load(url)
                .asGif()
//                .error(R.drawable.) // show error drawable if the image is not a gif
                .into(this.imageResponse);

    }

    public void findRandomGif() {
        String url = "http://api.giphy.com/v1/gifs/random?api_key=dc6zaTOxFJmzC&";

        //Busca por c categoria caso tiver
        if (!editTextCategoria.getText().equals("")) {
            url += "tag="+editTextCategoria.getText();
        }

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

    public void zoom(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
        image.startAnimation(animation1);
    }

    public void clockWise(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
        image.startAnimation(animation1);
    }


}
