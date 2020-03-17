package com.htngu.bt200316.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.htngu.bt200316.R;
import com.htngu.bt200316.SinhVien;

import java.util.ArrayList;

public class SinhVienAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<SinhVien> objects;

    public SinhVienAdapter(@NonNull Context context, @NonNull ArrayList<SinhVien> objects) {
        this.context = context;
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_sinhvien, viewGroup, false);
        TextView txtName, txtSex, txtBirth, txtFav;
        txtName = view.findViewById(R.id.txt_name);
        txtBirth = view.findViewById(R.id.txt_birth);
        txtSex = view.findViewById(R.id.txt_sex);
        txtFav = view.findViewById(R.id.txt_fav);

        SinhVien sv = objects.get(i);
        txtName.setText(sv.getName());
        txtBirth.setText(sv.getBirth());
        txtSex.setText(sv.getSex());

        String fav = new String();
        if (sv.isCheckSport()) fav+="Thể thao ";
        if (sv.isCheckTravel()) fav+="Du lịch ";
        if (sv.isCheckReadBook()) fav+="Đọc sách ";
        txtFav.setText("Sở thích: "+fav);

        return view;
    }
}
