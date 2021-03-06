package com.example.demo11_11.chitietphim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.demo11_11.R;
import com.example.demo11_11.bl;
import com.example.demo11_11.chamdiem;
import com.example.demo11_11.lichchieu;
import com.example.demo11_11.video;
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

public class chitietphimMain extends AppCompatActivity {

    private ImageButton imageButton;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietphim);

        chitietpdc();
    }
    public void chitietpdc() {
        final RecyclerView rvUsers = (RecyclerView) findViewById(R.id.rv_chitietphimdangchieu);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient client = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
        Moshi moshi = new Moshi.Builder().build();
        Type usersType = Types.newParameterizedType(List.class, chitietphim.class);
        final JsonAdapter<List<chitietphim>> jsonAdapter = moshi.adapter(usersType);

        // Tạo request lên server.
        Request request = new Request.Builder()
                .url("http://10.5.50.144/api1/chitietphim1.php")
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
                final List<chitietphim> users = jsonAdapter.fromJson(json);

                // Cho hiển thị lên RecyclerView.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rvUsers.setAdapter(new chitietphimAdapter(users, chitietphimMain.this));
                    }
                });
            }
        });
    }

    public void xemvideo(View view) {
        Intent intent = new Intent(chitietphimMain.this, video.class);
        startActivity(intent);
    }


    public void chamdiem(View view) {
        Intent intent = new Intent(chitietphimMain.this , chamdiem.class);
        startActivity(intent);
    }

    public void lichchieu(View view) {
        Intent intent = new Intent(chitietphimMain.this , lichchieu.class);
        startActivity(intent);
    }


    public void binhLuan(View view) {
        Intent intent = new Intent(chitietphimMain.this , bl.class);
        startActivity(intent);
    }
}