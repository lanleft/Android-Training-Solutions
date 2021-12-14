package com.example.fragment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragment.R;

public class ConvertFragment extends Fragment {

    Spinner spF, spT;
    EditText textIn;
    Button convert;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_convert, container, false);
        textIn = (EditText)view.findViewById(R.id.input);
        spF = (Spinner)view.findViewById(R.id.spFrom);
        spT = (Spinner)view.findViewById(R.id.spTo);
        convert = (Button) view.findViewById(R.id.convert);
        TextView result = (TextView)view.findViewById(R.id.result);

        String[] lib = {"BIN", "OCT", "DEC", "HEX"};
        ArrayAdapter ad = new ArrayAdapter <String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, lib);

        spF.setAdapter(ad);
        spT.setAdapter(ad);

        convert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String input = textIn.getText().toString();
                String fr = spF.getSelectedItem().toString();
                String to = spT.getSelectedItem().toString();
                String s;
                if (fr.equals(to)) {
                    s = "No thing to convert";
                    result.setText(s);
                } else {
                    if (fr == "HEX") {
                        int hex = Integer.parseInt(input, 16);
                        input = Integer.toString(hex);
                    }
                    if (fr == "OCT") {
                        int oct = Integer.parseInt(input, 8);
                        input = Integer.toString(oct);
                    }
                    if (fr == "BIN") {
                        int bin = Integer.parseInt(input, 2);
                        input = Integer.toString(bin);
                    }
                    int change = Integer.parseInt(input);
                    if (to == "HEX") {
                        s = Integer.toHexString(change);
                        result.setText(s);
                    }
                    if (to == "DEC") {
                        s = input;
                        result.setText(s);
                    }
                    if (spT.getSelectedItem().toString() == "OCT") {
                        s = Integer.toOctalString(change);
                        result.setText(s);
                    }
                    if (spT.getSelectedItem().toString() == "BIN") {
                        s = Integer.toBinaryString(change);
                        result.setText(s);
                    }
                }
                }
            });
        return view;
    }
}
