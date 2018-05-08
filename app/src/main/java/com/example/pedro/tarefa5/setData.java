package com.example.pedro.tarefa5;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class setData extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    GregorianCalendar data = new GregorianCalendar();
    private DateListener dateListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(getActivity() instanceof DateListener)){
            throw new ClassCastException("ops, não é instancia de DateListener\"");
        }
        dateListener = (DateListener) getActivity();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new DatePickerDialog(getActivity(), this, data.get(Calendar.YEAR), data.get(Calendar.MONTH), data.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        dateListener.onDateSelected(dayOfMonth, month + 1, year);
    }

    public interface DateListener{
        void onDateSelected(int day, int month, int year);
    }
}
