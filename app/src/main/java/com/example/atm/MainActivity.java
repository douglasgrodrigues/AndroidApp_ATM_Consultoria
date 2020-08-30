package com.example.atm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();  // Chama o comando ao clicar no button
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes,
                R.id.nav_contato, R.id.nav_sobre)
                .setDrawerLayout(drawer)
                .build();


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail() {


        String celular = "tel:51983320944";
        String imagem = "https://upload.wikimedia.org/wikipedia/pt/f/f6/Dark_%28s%C3%A9rie%29.jpg";
        String endereco ="https://www.google.com/maps/place/Dark/@-30.1155279,-51.3212458,11z/data=!4m8!1m2!2m1!1sdark!3m4!1s0x951975c6994bc125:0xf3af76db106fe43a!8m2!3d-30.0023613!4d-51.0798272?hl=pt-BR";
        //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("celular)); //Define uma Intent que faz ação for ado app
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));  //Abre uma imagem
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(endereco));  //Abre um endereço

        Intent intent = new Intent(Intent.ACTION_SEND);  //Abre um endereço
        intent.putExtra( Intent.EXTRA_EMAIL, new String[]{"atendimento@atmconsultoria"});
        intent.putExtra( Intent.EXTRA_SUBJECT, "Contato App");
        intent.putExtra( Intent.EXTRA_TEXT, "Não responda");

        //intent.setType("message/rfc822");
        //intent.setType("text/plain");
        intent.setType("image/*");        //para obter mais ações, verificar no GOOGLE MIME TYPES


        startActivity(Intent.createChooser( intent, "Compartilhar" ));  //inicia a intent

    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
