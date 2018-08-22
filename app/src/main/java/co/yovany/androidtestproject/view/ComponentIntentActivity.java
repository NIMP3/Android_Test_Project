package co.yovany.androidtestproject.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import co.yovany.androidtestproject.R;

public class ComponentIntentActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component_intent);

        Button btnWebPage = findViewById(R.id.btnWebPage);
        Button btnCall = findViewById(R.id.btnCall);
        Button btnMaps = findViewById(R.id.btnMaps);
        Button btnTakePhoto = findViewById(R.id.btnTakePhoto);
        Button btnSendEmail = findViewById(R.id.btnSendEmail);

        btnWebPage.setOnClickListener(this);
        btnCall.setOnClickListener(this);
        btnMaps.setOnClickListener(this);
        btnTakePhoto.setOnClickListener(this);
        btnSendEmail.setOnClickListener(this);


    }

    /*==============================================================================================
     * FUNCIONES*/

    /*----------------------------------------------------------------------------------------------
     * Abre una página web con una URL determinada
     *
     * @param page : URL de la pagina web*/
    public void openWebPage(String page) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(page));
        startActivity(intent);
    }

    /*----------------------------------------------------------------------------------------------
     * Realiza una llamada telefonica a un numero determinado
     *
     * @param phone : numero de telefono*/
    private void callPhone(String phone) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(phone));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[] {Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);
            return;
        }

        startActivity(intent);
    }

    /*----------------------------------------------------------------------------------------------
    * Abre Google Maps con una posición determinada
    *
    * @param latitude : Latitud
    * @param longitude : Longitud*/
    private void openGoogleMaps(float latitude, float longitude) {
        String position = "geo:" + latitude + "," + longitude;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(position));
        startActivity(intent);
    }

    /*----------------------------------------------------------------------------------------------
    * Abre la camara para tomar una fotografia*/
    private void takePhoto() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }

    /*----------------------------------------------------------------------------------------------
    * Envia un correo determinado
    *
    * @param subject : Asunto del correo
    * @param message : Mensaje o contenido del correo
    * @param emails : Direcciones de correo destinatarias*/
    private void sendEmail(String subject, String message, String[] emails) {
        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.putExtra(Intent.EXTRA_EMAIL, emails);

        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnWebPage:
                openWebPage("https://github.com/NIMP3");
                break;
            case R.id.btnCall:
                callPhone("tel:3168460999");
                break;
            case R.id.btnMaps:
                openGoogleMaps(41.656313f, -0.877351f);
                break;
            case R.id.btnTakePhoto:
                takePhoto();
                break;
            case R.id.btnSendEmail:
                sendEmail("PRUEBA","Hola Edwin",new String[] {"yovany.dev@gmail.com"});
                break;
        }
    }
}
