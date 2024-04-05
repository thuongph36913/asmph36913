package com.thuonght.asignmentapiph36913;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.thuonght.asignmentapiph36913.adapter.sanphamadapter;
import com.thuonght.asignmentapiph36913.model.sanpham;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imgProfile;
    RecyclerView rcySanPham;
    Button btnAdd;
    BottomNavigationView bottom_navigation;

    private ArrayList<sanpham> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgProfile = findViewById(R.id.imgProfile);
        rcySanPham = findViewById(R.id.rcySanPham);
        bottom_navigation = findViewById(R.id.bottom_navigation);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        rcySanPham.setLayoutManager(gridLayoutManager);

        list.add(new sanpham("https://i.pinimg.com/564x/30/35/3b/30353bb86ee1eafa4cc3f977253adefb.jpg", "Hoa quả rất tốt"));
        list.add(new sanpham("https://i.pinimg.com/564x/da/ff/13/daff1353c18c903a0d74a8a3099a7611.jpg", "Hoa quả rất tốt"));
        list.add(new sanpham("https://i.pinimg.com/564x/45/81/d0/4581d091aad4fd513d04c670caf8d39d.jpg", "Hoa quả rất tốt"));
        list.add(new sanpham("https://i.pinimg.com/564x/5a/d5/b3/5ad5b379562fafb26e7ff26476c881b0.jpg", "Hoa quả rất tốt"));
        list.add(new sanpham("https://i.pinimg.com/564x/47/4c/a3/474ca328c060ad456c8e8cd274dae7cc.jpg", "Hoa quả rất tốt"));
        list.add(new sanpham("https://i.pinimg.com/564x/da/b5/c9/dab5c9b748bdd004cf2668590b86bac4.jpg", "Hoa quả rất tốt"));
        sanphamadapter adapter = new sanphamadapter(this, list);
        rcySanPham.setAdapter(adapter);

        ActivityResultLauncher<Intent> getdl = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == 1) {
                    Intent intent = result.getData();
                    if (intent != null) {
                        Bundle bundle = intent.getExtras();
                        String img = bundle.getString("img");
                        String ten = bundle.getString("ten");
                        list.add(new sanpham(img, ten));
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);
            }
        });
        bottom_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.navigation_home) {
                    return true;
                } else if (item.getItemId()==R.id.navigation_cart) {
                    startActivity(new Intent(getApplicationContext(), Profile.class));

                    return true;
                }
                else if (item.getItemId()==R.id.navigation_menu) {
                    startActivity(new Intent(getApplicationContext(), Fayvorite.class));

                    return true;
                }
                else if (item.getItemId()==R.id.navigation_love) {
                    startActivity(new Intent(getApplicationContext(), Fayvorite.class));
                    return true;
                }

                return false;

            }
        });
    }
}
