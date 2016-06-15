package com.gifu.gifu;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;

import org.json.JSONArray;

public class Gif {

    private static final String publicKey = "dc6zaTOxFJmzC";

    public void getGif(String tag) {
        tag = tag.equals("") ? "gif" : tag;

        String url = "http://api.giphy.com/v1/gifs/search?api_key="+this.publicKey+"&limit=1&q="+tag;

        Response.Listener<JSONArray> responseListener = new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                System.out.println("Entrou no response");
                try {
                    if(response != null && response.length() > 0) {
//                        String json = response.getJSONObject(0).toString();
//                        TypeToken<Promocao> typeToken = new TypeToken<Promocao>(){};
//                        Promocao promocao  = new Gson().fromJson(json, typeToken.getType());
//
//                        editTextPromocaoId.setText(promocao.getId());
//                        editTextPromocaoNome.setText(promocao.getNome());
//                        editTextPromocaoLoja.setText(promocao.getLoja());
//                        editTextPromocaoPreco.setText(promocao.getPreco());
//                        carregarImagem(promocao.getImagem());
                        System.out.println("teste1");
                        System.out.println(response);
                    } else { System.out.println("Nenhum gif foi encontrado."); }
                } catch (Exception e) { System.out.println("ERRO: " + e.getMessage()); }
            }
        };
        Response.ErrorListener responseErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) { System.out.println("ERRO: " + error.getMessage()); }
        };
        JsonArrayRequest jsObjRequest = new JsonArrayRequest(Request.Method.GET, url, responseListener, responseErrorListener);

//        RestRequestManager.getInstance(MainActivity.this).addToRequestQueue(jsObjRequest);
        System.out.println("teste2");
        System.out.println(jsObjRequest);

    }
}
