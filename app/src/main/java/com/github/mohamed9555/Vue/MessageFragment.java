package com.github.mohamed9555.Vue;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.github.mohamed9555.R;

public class MessageFragment extends Fragment {
    private EditText phone;
    private EditText message;
    private Button envoi;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sms, container,false);

    }

    public void createOnClickEnvoiButton(){
        envoi.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){
                SmsManager.getDefault().sendTextMessage(phone.getText().toString(), null,
                        message.getText().toString(),null,null);
            }
        });
}}
