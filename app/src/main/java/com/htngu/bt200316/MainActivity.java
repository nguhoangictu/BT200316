package com.htngu.bt200316;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.htngu.bt200316.adapter.SinhVienAdapter;
import com.htngu.bt200316.database.DBManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edtName, edtBirth, edtSchool;
    private RadioGroup ragSex;
    private RadioButton rabMale, rabFemale;
    private CheckBox checkSport, checkTravel, checkReadBook;
    private DBManager manager;
    private SinhVienAdapter adapter;
    private ArrayList<SinhVien> svList;
    private ListView lvSv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        event();


    }

    private void event() {
        lvSv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int pos, long l) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Xoá "+svList.get(pos).getName())
                        .setMessage("Bạn có chắc chắn muốn xoá "+svList.get(pos).getName())
                        .setCancelable(true)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                                manager.deleteSV(svList.get(pos).getId());
                                svList.remove(pos);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .show();
                return false;
            }
        });

        lvSv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int pos, long l) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Cập nhật cho "+svList.get(pos).getName())
                        .setMessage("Bạn có chắc chắn muốn cập nhật dữ liệu cho "+svList.get(pos).getName()+"? Dữ liệu trước đó sẽ bị mất!")
                        .setCancelable(true)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                String sex;
                                if (ragSex.getCheckedRadioButtonId() == rabMale.getId()){
                                    sex = "Nam";
                                }else if (ragSex.getCheckedRadioButtonId() == rabFemale.getId()){
                                    sex = "Nữ";
                                }else sex = null;
                                SinhVien sv = new SinhVien(edtName.getText().toString(), edtBirth.getText().toString(), sex, checkSport.isChecked(), checkTravel.isChecked(), checkReadBook.isChecked());

                                manager.updateSV(svList.get(pos).getId(), sv);
                                svList.set(pos, sv);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .show();
            }
        });
    }

    private void init() {
        manager = new DBManager(MainActivity.this);
        edtName = findViewById(R.id.edtname);
        edtBirth = findViewById(R.id.edtbirth);
        edtSchool = findViewById(R.id.edtschool);

        ragSex = findViewById(R.id.rag_sex);
        rabMale = findViewById(R.id.rab_male);
        rabFemale = findViewById(R.id.rab_female);

        checkSport = findViewById(R.id.check_sport);
        checkTravel = findViewById(R.id.check_travel);
        checkReadBook = findViewById(R.id.check_read_book);

        lvSv = findViewById(R.id.lv_sv);
        svList = manager.getAllStudent();
        adapter = new SinhVienAdapter(MainActivity.this, svList);

        lvSv.setAdapter(adapter);
    }

    public void addDB(View view) {

        try {
            String sex;
            if (ragSex.getCheckedRadioButtonId() == rabMale.getId()){
                sex = "Nam";
            }else if (ragSex.getCheckedRadioButtonId() == rabFemale.getId()){
                sex = "Nữ";
            }else sex = null;
            SinhVien sv = new SinhVien(edtName.getText().toString(), edtBirth.getText().toString(), sex, checkSport.isChecked(), checkTravel.isChecked(), checkReadBook.isChecked());
            manager.addStudent(sv);
            svList.add(sv);
            adapter.notifyDataSetChanged();
        }catch (Exception e){
            Log.d("addDBException", e.toString());
            Toast.makeText(MainActivity.this, "Thêm không thành công", Toast.LENGTH_SHORT).show();

        }
    }
    public void refrest(View view) {
        edtName.setText("");
        edtBirth.setText("");
        edtSchool.setText("");
        ragSex.clearCheck();
        checkSport.setChecked(false);
        checkTravel.setChecked(false);
        checkReadBook.setChecked(false);
    }
}
