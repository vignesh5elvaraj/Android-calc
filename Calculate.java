package com.microblink.ocr;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.Text;
import java.util.StringTokenizer;

/**
 * Created by Vignesh on 4/4/2016.
 */
public class Calculate extends Activity {

    TextView tvView, tvView2;
    EditText ed1;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cal);


        tvView = (TextView) findViewById(R.id.textView);
        tvView2 = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        String full = intent.getStringExtra("full");
        tvView.setText("Scanned Text is " + full);
        String sep = full;
        // Pattern p = Pattern.compile("[^+]");
        //Matcher m = p.matcher(sep);
        // boolean b=m.find();
        if (sep.indexOf("+")!=-1)
        {
            StringTokenizer st = new StringTokenizer(sep, "+");
            String a = st.nextToken();
            String b = st.nextToken();
            int one=Integer.parseInt(a.trim());
            int two=Integer.parseInt(b.trim());
            try {
                int val1=one + two;
                tvView2.setText("output is"+val1);
            } catch(NumberFormatException nfe) {
                tvView2.setText("Couldn't parse.");
                nfe.printStackTrace();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else if(sep.indexOf("-")!=-1)
        {
            StringTokenizer st = new StringTokenizer(sep, "-");
            String a = st.nextToken();
            String b = st.nextToken();
            int one=Integer.parseInt(a.trim());
            int two=Integer.parseInt(b.trim());
            try {
                int val1=one - two;
                tvView2.setText("output is"+val1);
            } catch(NumberFormatException nfe) {
                tvView2.setText("Couldn't parse.");
                nfe.printStackTrace();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else if(sep.indexOf("*")!=-1)
        {
            StringTokenizer st = new StringTokenizer(sep, "*");
            String a = st.nextToken();
            String b = st.nextToken();
            int one=Integer.parseInt(a.trim());
            int two=Integer.parseInt(b.trim());
            try {
                int val1=one * two;
                tvView2.setText("output is"+val1);
            } catch(NumberFormatException nfe) {
                tvView2.setText("Couldn't parse.");
                nfe.printStackTrace();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else if(sep.indexOf("/")!=-1)
        {
            StringTokenizer st = new StringTokenizer(sep, "/");
            String a = st.nextToken();
            String b = st.nextToken();
            int one=Integer.parseInt(a.trim());
            int two=Integer.parseInt(b.trim());
            try {
                int val1=one / two;
                tvView2.setText("output is"+val1);
            } catch(NumberFormatException nfe) {
                tvView2.setText("Couldn't parse.");
                nfe.printStackTrace();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

else
        {
            tvView2.setText("Not an airtmetic character");
        }
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Calculate Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.microblink.ocr/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Calculate Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.microblink.ocr/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}