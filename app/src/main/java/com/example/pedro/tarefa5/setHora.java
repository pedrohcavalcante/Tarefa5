package com.example.pedro.tarefa5;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class setHora extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    GregorianCalendar hora = new GregorianCalendar();
    private TimeListener timeListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(!(getActivity() instanceof setHora.TimeListener)){
            throw new ClassCastException("ops, não é instancia de TimeListener");
        }
        timeListener = (TimeListener) getActivity();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new TimePickerDialog(getActivity(), this, hora.get(Calendar.HOUR_OF_DAY), hora.get(Calendar.MINUTE), true);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        timeListener.onTimeSelected(hourOfDay, minute);
    }

    public interface TimeListener{
        void onTimeSelected(int hour, int minutes);
    }
}
