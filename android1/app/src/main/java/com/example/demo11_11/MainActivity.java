package com.example.demo11_11;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


<<<<<<< HEAD
=======
import com.example.demo11_11.dangky.DangKi;
>>>>>>> parent of 4831487... van binh 2h t.5
import com.example.demo11_11.danhsachphim.danhsachphim;
import com.example.demo11_11.danhsachphim.danhsachphimAdapter;
import com.example.demo11_11.danhsachphim.danhsachphimMain;
import com.example.demo11_11.danhsachphim.phimsapchieu;
import com.example.demo11_11.danhsachphim.phimsapchieuAdapter;
import com.example.demo11_11.lichsugiaodich.lichsugiaodich;
import com.example.demo11_11.thongtincaNhan.thongtincanhan;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.danhsachphim:{
                        startActivity(new Intent(MainActivity.this, danhsachphimMain.class));
                        break;
                    }
<<<<<<< HEAD
                    case R.id.trangchu:{
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
=======
                    case R.id.dangky:{
                        startActivity(new Intent(MainActivity.this, DangKi.class));
>>>>>>> parent of 4831487... van binh 2h t.5
                        break;
                    }
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
        psc();
        pdc();

    }
    public void psc()
    {
        //tách hàm ra
        LinearLayoutManager layoutManagers
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView rv_phimsapchieu1  = (RecyclerView) findViewById(R.id.rv_phimsapchieu);
        rv_phimsapchieu1.setLayoutManager(layoutManagers);

        // Tạo request lên server.
        Request sapchieu = new Request.Builder()
                .url("http://192.168.1.150:8080/api1/apiphimsapchieu.php")
                .build();

        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient b = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
        Moshi c = new Moshi.Builder().build();
        Type d = Types.newParameterizedType(List.class, phimsapchieu.class);
        final JsonAdapter<List<phimsapchieu>> jsonAdapters = c.adapter(d);

        // Thực thi request.
        b.newCall(sapchieu).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error", "Network Error");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                // Lấy thông tin JSON trả về. Bạn có thể log lại biến json này để xem nó như thế nào.
                String jsons = response.body().string();
                final List<phimsapchieu> user = jsonAdapters.fromJson(jsons);

                // Cho hiển thị lên RecyclerView.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rv_phimsapchieu1.setAdapter(new phimsapchieuAdapter(user, MainActivity.this));
                    }
                });
            }
        });
    }
    public void pdc() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView rv_phimdangchieu1 = (RecyclerView) findViewById(R.id.rv_phimdangchieu);
        rv_phimdangchieu1.setLayoutManager(layoutManager);

        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient client = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
        Moshi moshi = new Moshi.Builder().build();
        Type usersType = Types.newParameterizedType(List.class, danhsachphim.class);
        final JsonAdapter<List<danhsachphim>> jsonAdapter = moshi.adapter(usersType);

        // Tạo request lên server.
        Request request = new Request.Builder()
                .url("http://192.168.1.150:8080/api1/api.php")
                .build();


        // Thực thi request.
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error", "Network Error");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                // Lấy thông tin JSON trả về. Bạn có thể log lại biến json này để xem nó như thế nào.
                String json = response.body().string();
                final List<danhsachphim> users = jsonAdapter.fromJson(json);

                // Cho hiển thị lên RecyclerView.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rv_phimdangchieu1.setAdapter(new danhsachphimAdapter(users, MainActivity.this));
                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu: {
                drawerLayout.openDrawer(GravityCompat.END);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}