package br.com.mybrowser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wvPrincipal.webViewClient = object : WebViewClient(){


            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }

        }

        wvPrincipal.settings.javaScriptEnabled = true

        //wvPrincipal.loadUrl("https://polar-lowlands-34490.herokuapp.com/")

        wvPrincipal.loadUrl("https://www.pubg.com/")

        //Barra de Endereços
        edtBarraEndereco.setOnClickListener {

            var urlPesquisada =  "https://" + edtBarraEndereco.text.toString()
            wvPrincipal.loadUrl("$urlPesquisada")

            Log.d("MainActivity","Propriedade URL = ${wvPrincipal.url}")
            Log.d("MainActivity", "Valor campo urlPesquisada =  $urlPesquisada")

            edtBarraEndereco.getText().clear()
        }

        //botão voltar
        btnVoltar.setOnClickListener{

            //verificando se WebViewpode voltar páginas
            if(wvPrincipal.canGoBack()) {
                wvPrincipal.goBack()
            } else {
                Toast.makeText(this, "Não existem páginas para Voltar", Toast.LENGTH_LONG).show()
            }

        }

        //botão avançar
        btnAvancar.setOnClickListener{

            //verificando se WebViewpode voltar páginas
            if(wvPrincipal.canGoForward()) {
                wvPrincipal.goForward()
            } else {
                Toast.makeText(this, "Não existem páginas para Avançar", Toast.LENGTH_LONG).show()
            }

        }

        //botão Home
        imgBtnHome.setOnClickListener{

            wvPrincipal.loadUrl("https://www.google.com.br/")

        }

    }
}







