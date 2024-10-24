package com.example.duanandroid.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanandroid.R;

import java.util.ArrayList;
import java.util.List;

//import Adapter.ReviewAdapter;
import Adapter.ReviewAdapter;
import Model.Review;
import Model.User;

public class ChitietsanphamActivity extends AppCompatActivity {
    private RecyclerView reviewRecyclerView;
    private ReviewAdapter reviewAdapter;
    private List<Review> reviewList;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietsanpham);

        // Nhận dữ liệu từ Intent
        String productName = getIntent().getStringExtra("productName");
        float productPrice = getIntent().getFloatExtra("productPrice", 0);
        String productImageResource = getIntent().getStringExtra("imageURL");

        // Tham chiếu đến các view trong layout chitietsanpham
        TextView nameTextView = findViewById(R.id.product_description);
        TextView priceTextView = findViewById(R.id.product_price);
        ImageView imageView = findViewById(R.id.product_image);

        // Hiển thị dữ liệu vào các view
        nameTextView.setText(productName);
        priceTextView.setText(String.format("₫%,.0f", productPrice)); // Định dạng giá thành chuỗi
        imageView.setImageResource(R.drawable.ao); // Hiển thị hình ảnh (placeholder)

        // Khởi tạo RecyclerView
        reviewRecyclerView = findViewById(R.id.review_list);
        reviewRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Tạo danh sách đánh giá (ví dụ tạm thời)
        reviewList = new ArrayList<>();
        reviewList.add(new Review("imageUrl", "Great product!", 4.5f, 0));
        reviewList.add(new Review("imageUrl", "Very satisfied!", 5.0f, 0));
        reviewList.add(new Review("imageUrl", "Good quality.", 4.0f, 0));

        // Tạo danh sách người dùng (ví dụ tạm thời)
        userList = new ArrayList<>();
        userList.add(new User(1, "John Doe", "Address", "0123456789", "john@example.com", 1, null, "john", "password", "active", 0, 0));
        userList.add(new User(2, "Jane Smith", "Address", "0123456789", "jane@example.com", 1, null, "jane", "password", "active", 0, 0));
        userList.add(new User(3, "Alice Brown", "Address", "0123456789", "alice@example.com", 1, null, "alice", "password", "active", 0, 0));


        // Thiết lập Adapter cho RecyclerView
        reviewAdapter = new ReviewAdapter(reviewList, userList);
        reviewRecyclerView.setAdapter(reviewAdapter);

        TextView btn=  findViewById(R.id.btn_add_to_cart);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChitietsanphamActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
        TextView btn1=  findViewById(R.id.btn_buy_now);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChitietsanphamActivity.this, BuyandpaymentActivity.class);
                startActivity(intent);
            }
        });

        ImageView imv=  findViewById(R.id.chat);
        imv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChitietsanphamActivity.this, chatUserActivity.class);
                startActivity(intent);
            }
        });

        ImageView shoppingcart=  findViewById(R.id.shopping_cart);
        shoppingcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChitietsanphamActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }
}
