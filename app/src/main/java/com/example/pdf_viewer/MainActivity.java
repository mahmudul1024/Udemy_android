package com.example.pdf_viewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class MainActivity extends AppCompatActivity {
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pdfView=findViewById(R.id.pdfViewid);

        //uploaded pdf to Asset folder

        // getting pdf files from assets
       // pdfView.fromAsset("_SSF_Intro.pdf").pages(1,2,3).load();
        //organ is linked or assigned with object
        // load->pages 1 2 3,from ->pdf name->...from assets---> assigned
        //pdfView.fromAsset("_SSF_Intro.pdf").enableSwipe(true).load();
       // pdfView.fromAsset("_SSF_Intro.pdf").pages(1,2,3).nightMode(true).load();

       //pages and nightmode are methods ..they should be called after fromAssets according to
        // github syntax
        pdfView.fromAsset("_SSF_Intro.pdf").nightMode(true).load();


    }
}