package com.app.pointme.voicenotificaction.fragments;

import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.app.pointme.voicenotificaction.R;

public class MaterialDialog extends DialogFragment implements View.OnClickListener {
    OnDateTimeSelectListner onDateTimeSelectListner;
    private TextView nagativeButton;
    private TextView positiveButton;
    private String positive;
    private String Nagative;
    private String message;
    OnPositiveButtonClick onPositiveButtonClick;
    OnNagativeButtonClick onNagativeButtonClick;
    private TextView messageView;

    public interface OnDateTimeSelectListner {
        void onDateTimeSelected(int day, int month, int year, int hour, int min);
    }

    public interface OnPositiveButtonClick {
        void onPositiveClick(View v);
    }

    public interface OnNagativeButtonClick {
        void onNagativeClick(View v);
    }

    @Override
    public int show(FragmentTransaction transaction, String tag) {
        return super.show(transaction, tag);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.alert_m, container, false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        nagativeButton = (TextView) root.findViewById(R.id.nagative_button);
        positiveButton = (TextView) root.findViewById(R.id.positive_button);
        messageView = (TextView) root.findViewById(R.id.message);
        positiveButton.setOnClickListener(this);
        nagativeButton.setOnClickListener(this);

        positiveButton.setText(getPositiveButton());
        nagativeButton.setText(getNagativeButton());
        messageView.setText(getMessage());

        return root;
    }

    

    public String getPositiveButton() {
        return positive;
    }

    public void setPositiveButton(String positive, OnPositiveButtonClick onPositiveButtonClick) {
        this.positive = positive;
        this.onPositiveButtonClick = onPositiveButtonClick;
    }


    public String getNagativeButton() {
        return Nagative;
    }

    public void setNagativeButton(String Nagative, OnNagativeButtonClick onNagativeButtonClick) {
        this.Nagative = Nagative;
        this.onNagativeButtonClick = onNagativeButtonClick;
    }


    public String getMessage() {
        return Nagative;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() == null)
            return;
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.positive_button:
                onPositiveButtonClick.onPositiveClick(v);
                break;

            case R.id.nagative_button:
                onNagativeButtonClick.onNagativeClick(v);
                break;
        }


        /*if (v.getId() == R.id.bSetTimeRange) {
            dismiss();

        }*/
    }
}
