package com.example.acildurumuygulamas



import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var SharedPreferences = this.getSharedPreferences("kullanicibilgi",Context.MODE_PRIVATE)
        var editor = SharedPreferences.edit()
        var kayitkontrol = SharedPreferences.getInt("kontrol",0)



        if (kayitkontrol==1)
        {

            val intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)

        }





       radioButton.setOnClickListener {

           radioButton2.isChecked=false


       }
        radioButton2.setOnClickListener {


            radioButton.isChecked=false
        }




buton1.setOnClickListener {
//
    var SharedPreferences = this.getSharedPreferences("kullanicibilgi",Context.MODE_PRIVATE)
    var editor = SharedPreferences.edit()







  //


if (((editTextTextPersonName.text.toString()!="")&&(editTextTextPersonName2.text.toString()!=""))&&(radioButton.isChecked==true||radioButton2.isChecked==true)) {

    if (editTextTextPersonName2.length() == 11) {



        startActivity(intent)


    }
    else{

        Toast.makeText(this,"Telefon Numarasını eksik girdiniz!",Toast.LENGTH_SHORT).show()
    }
}
else
{
    if (editTextTextPersonName.text.toString()=="")
    {

    Toast.makeText(this,"Ad Soyad Girmediniz",Toast.LENGTH_SHORT).show()
    }
    if (editTextTextPersonName2.text.toString()=="")
    {
        Toast.makeText(this,"Telefon Numarası Girmediniz",Toast.LENGTH_SHORT).show()


    }
    if (radioButton.isChecked==false&&radioButton2.isChecked==false
    )
    {
        Toast.makeText(this,"Cinsiyet Seçmediniz",Toast.LENGTH_SHORT).show()



    }



}

    editor.putInt("kontrol",1).apply()
    editor.putString("isim",editTextTextPersonName.text.toString()).apply()
    editor.putString("telefon",editTextTextPersonName2.text.toString()).apply()
    var kayitisim = SharedPreferences.getString("isim","")
    var kayittelefon = SharedPreferences.getString("telefon","")


  if (radioButton2.isChecked==true)
  {
editor.putString("cinsiyet","kadin").apply()
      editor.putString("cinsiyet2","").apply()

  }
    if (radioButton.isChecked==true)
    {
        editor.putString("cinsiyet2","erkek").apply()
        editor.putString("cinsiyet","").apply()

    }

    var kayitcinsiyet = SharedPreferences.getString("cinsiyet","")
    var kayitcinsiyet2 = SharedPreferences.getString("cinsiyet2","")


}
        //

        //



    }
}
