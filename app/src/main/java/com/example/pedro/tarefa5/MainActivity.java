package com.example.pedro.tarefa5;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends Activity implements setData.DateListener, setHora.TimeListener {
    private TextView data_view;
    private TextView hora_view;
    private Calendar hora_data = Calendar.getInstance(Locale.ENGLISH);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data_view = findViewById(R.id.data);
        hora_view = findViewById(R.id.hora);
        setHoraAgora();
        setDataAgora();
    }

    public void setHoraAgora(){
        if (hora_data.get(Calendar.HOUR_OF_DAY) < 10 && hora_data.get(Calendar.MINUTE) < 10){
            hora_view.setText("0" + hora_data.get(Calendar.HOUR_OF_DAY) + ":0" + hora_data.get(Calendar.MINUTE));
        } else if (hora_data.get(Calendar.HOUR_OF_DAY) < 10){
            hora_view.setText("0" + hora_data.get(Calendar.HOUR_OF_DAY) + ":" + hora_data.get(Calendar.MINUTE));
        } else if (hora_data.get(Calendar.MINUTE) < 10){
            hora_view.setText(hora_data.get(Calendar.HOUR_OF_DAY) + ":0" + hora_data.get(Calendar.MINUTE));
        } else {
            hora_view.setText(hora_data.get(Calendar.HOUR_OF_DAY) + ":" + hora_data.get(Calendar.MINUTE));
        }
    }

    public void setDataAgora(){
        int mes = hora_data.get(Calendar.MONTH) + 1;
        if (hora_data.get(Calendar.DAY_OF_MONTH) < 10 && mes < 10){
            data_view.setText("0" + hora_data.get(Calendar.DAY_OF_MONTH) + "/0" + mes + "/" + hora_data.get(Calendar.YEAR));
        } else if (mes < 10){
            data_view.setText(hora_data.get(Calendar.DAY_OF_MONTH) + "/0" + mes + "/" + hora_data.get(Calendar.YEAR));
        } else if ( hora_data.get(Calendar.DAY_OF_MONTH) < 10) {
            data_view.setText("0" + hora_data.get(Calendar.DAY_OF_MONTH) + "/0" + mes + "/" + hora_data.get(Calendar.YEAR));
        } else {
            data_view.setText(hora_data.get(Calendar.DAY_OF_MONTH) + "/" + mes + "/" + hora_data.get(Calendar.YEAR));
        }
    }

    public void seeData(View view){
        setData sh = new setData();
        sh.show(getFragmentManager(), "data");
    }

    public void seeHora(View view){
        setHora shora = new setHora();
        shora.show(getFragmentManager(), "hora");
    }

    @Override
    public void onDateSelected(int day, int month, int year) {

        if (day < 10 && month < 10){
            data_view.setText("0" + day + "/0" + month + "/" + year);
        } else if (month < 10){
            data_view.setText(day + "/0" + month + "/" + year);
        } else if ( day < 10) {
            data_view.setText("0" + day + "/0" + month + "/" + year);
        } else {
            data_view.setText(day + "/" + month + "/" + year);
        }
        Log.i("onDateSelected override", "data deu certo");
    }

    @Override
    public void onTimeSelected(int hour, int minutes) {
        if (hour < 10 && minutes < 10){
            hora_view.setText("0" + hour + ":0" + minutes);
        } else if (hour < 10){
            hora_view.setText("0" + hour + ":" + minutes);
        } else if (minutes < 10){
            hora_view.setText(hour + ":0" + minutes);
        } else {
            hora_view.setText(hour + ":" + minutes);
        }

        Log.i("onTimeSelected override", "hora deu certo");
    }
}
