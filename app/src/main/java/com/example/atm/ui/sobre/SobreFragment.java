package com.example.atm.ui.sobre;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.atm.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 */
public class SobreFragment extends Fragment {


    public SobreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_sobre, container, false);

        String descricao = "";

        Element versao = new Element();
        versao.setTitle("Versão 1.0");

        return  new AboutPage( getActivity() )
                .setImage( R.drawable.logo )
                //.setDescription( descricao )   -> Adicionar uma descrição personalizada

                .addGroup("Entre em contato")
                .addEmail("atendimento@atmconsultoria.com.br", "Envie um E-mail")
                .addWebsite("https://www.google.com", "Acesse nosso site")

                .addGroup("Redes Sociais")
                .addFacebook("douglasghiraldello", "Facebook")
                .addInstagram("rdouggg","Instagram")
                .addTwitter("","Twitter")
                .addYoutube("","Youtube")
                .addGitHub("douglasgrodrigues","GitHub")

                .addItem( versao )


                .create();




    }

}
