package com.example.acildurumuygulamas


import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*


class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        // izinler

        fun hasPermissions(context: Context, vararg permissions: String): Boolean = permissions.all {
            ActivityCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
        }
        val PERMISSION_ALL = 1
        val PERMISSIONS = arrayOf(




            Manifest.permission.SEND_SMS,
                    Manifest.permission.CALL_PHONE,
                            Manifest.permission.ACCESS_FINE_LOCATION

        )

        if (!hasPermissions(this, PERMISSIONS.toString())) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL)
        }












//

//
        var SharedPreferences = this.getSharedPreferences("kullanicibilgi", Context.MODE_PRIVATE)
        var editor = SharedPreferences.edit()

        var kayitisim = SharedPreferences.getString("isim","")
        var kayittelefon = SharedPreferences.getString("telefon","")
        var kayitcinsiyet = SharedPreferences.getString("cinsiyet","")
        var kayitcinsiyet2 = SharedPreferences.getString("cinsiyet2","")

//


        val permissionRequest = 101
        val phoneNumber = "905455598898"
        val phoneNumber2 = "05455598898"

        data class SomeDataClass(
            var alinanveri3: String,
            var alinanveri4: String,


        )
        fun myMessage(someDataClass: SomeDataClass) {
            ///

            ///
//

            lateinit var fusedLocationClient: FusedLocationProviderClient
            fusedLocationClient = LocationServices.getFusedLocationProviderClient(applicationContext!!)
            fusedLocationClient.lastLocation.addOnSuccessListener {location->
                if (location != null) {
                  var  wayLatitude = location.getLatitude()
                  var  wayLongitude = location.getLongitude()
                  var yeni= String.format(Locale.US, "%s,%s", wayLatitude, wayLongitude)




                    val mesaj =yeni
                    if (TextUtils.isDigitsOnly(phoneNumber2)) {
                        val smsManager: SmsManager = SmsManager.getDefault()
                        smsManager.sendTextMessage("05455598898", null,mesaj, null, null)
                        Toast.makeText(this, "Mesaj Gönderildi", Toast.LENGTH_SHORT).show()

                    }


                }

            }




            //



                val mesaj ="Ad Soyad: "+kayitisim + "\n" + "Telefon Numarası: "+kayittelefon + "\n" +"Cinsiyet: "+kayitcinsiyet+kayitcinsiyet2
                if (TextUtils.isDigitsOnly(phoneNumber2)) {
                    val smsManager: SmsManager = SmsManager.getDefault()
                    smsManager.sendTextMessage("05455598898", null,mesaj, null, null)
                    Toast.makeText(this, "Mesaj Gönderildi", Toast.LENGTH_SHORT).show()

                }

        }


        //
        button.setOnClickListener {


            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)

        }
        yenibuton.setOnClickListener {

            val permissionCheck =
                ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                myMessage( someDataClass = SomeDataClass("sads","sasda"))
            } else {
                ActivityCompat.requestPermissions(
                    this, arrayOf(Manifest.permission.SEND_SMS),
                    permissionRequest
                )
            }




            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber))
            startActivity(intent)

        }
        editor.commit()



    }
}

