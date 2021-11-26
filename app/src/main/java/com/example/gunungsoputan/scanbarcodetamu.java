 package com.example.gunungsoputan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.net.URL;
import java.util.regex.Pattern;

import Capture.capture;


 public class scanbarcodetamu extends AppCompatActivity {
      //Initialize variable
     Button btScan;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_scanbarcodetamu);

         //Assign variable
         btScan = findViewById(R.id.bt_scan);

         btScan.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //Initialize intent integrator
                 IntentIntegrator intentIntegrator = new IntentIntegrator(
                         scanbarcodetamu.this
                 );
                 //Set prompt text
                 intentIntegrator.setPrompt("For flash use volume up key");
                 //Set beep
                 intentIntegrator.setBeepEnabled(true);
                 //Locked orientation
                 intentIntegrator.setOrientationLocked(true);
                 //Set capture activity
                 intentIntegrator.setCaptureActivity(capture.class);
                 //Initiate scan
                 intentIntegrator.initiateScan();
             }
         });
     }

     public static boolean checkURL(CharSequence input) {
         if (TextUtils.isEmpty(input)) {
             return false; } Pattern URL_PATTERN = Patterns.WEB_URL;
         boolean isURL = URL_PATTERN.matcher(input).matches();
         if (!isURL) { String urlString = input + "";
             if (URLUtil.isNetworkUrl(urlString)) {
                 try { new URL(urlString); isURL = true; }
                 catch (Exception e) { } } } return isURL; }

     @Override
     protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
         super.onActivityResult(requestCode, resultCode, data);
         //Initialize intent result
         IntentResult intentResult = IntentIntegrator.parseActivityResult(
                 requestCode,resultCode,data
         );
         //Check condition
         if (intentResult.getContents() !=null){
             //When result content is not null
             //Initialize alert dialog
             AlertDialog.Builder builder = new AlertDialog.Builder(
                     scanbarcodetamu.this
             );
             //Set title
             builder.setTitle("Result");
             //Set message
             builder.setMessage(intentResult.getContents());
             //Set positive button
             builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {
                     //Dismiss dialog
                     dialogInterface.dismiss();

                 }
             });
             //Show alert dialog
             builder.show();
         }else {
             //When result content is null
             //Display toast
             Toast.makeText(getApplicationContext()
                     ,"OOPS. . . You did not scan anything",Toast.LENGTH_SHORT)
                     .show();
         }
     }

 }