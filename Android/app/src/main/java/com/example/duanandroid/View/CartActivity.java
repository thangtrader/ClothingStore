package com.example.duanandroid.View;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanandroid.R;

import Adapter.CartAdapter;
import Model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerCartItems;
    private CartAdapter cartAdapter;
    private List<CartItem> cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerCartItems = findViewById(R.id.recycler_cart_items);
        recyclerCartItems.setLayoutManager(new LinearLayoutManager(this));

        // Sample cart items data
        cartItems = new ArrayList<>();
        cartItems.add(new CartItem("Áo thun ngắn tay nữ", "trắng, size M", "200.000đ", "image_url"));

        cartAdapter = new CartAdapter(cartItems);
        recyclerCartItems.setAdapter(cartAdapter);
    }
}