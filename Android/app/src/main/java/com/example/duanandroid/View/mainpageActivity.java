package com.example.duanandroid.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanandroid.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.ProductAdapter;
import Model.OrderDetail;
import Model.Product;
import Model.ProductImage;

public class mainpageActivity extends AppCompatActivity {

    private RecyclerView productRecyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;
    private List<ProductImage> productImageList; // Danh sách hình ảnh


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagemain);

        // Khởi tạo RecyclerView
        productRecyclerView = findViewById(R.id.items);
        productRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Lấy dữ liệu từ layout
        productList = loadDataFromLayout();
        productImageList = loadProductImages(); // Gọi phương thức tải hình ảnh

        // Tạo Adapter và kết nối với RecyclerView
        productAdapter = new ProductAdapter(productList,productImageList);
        productRecyclerView.setAdapter(productAdapter);
    }

    private List<Product> loadDataFromLayout() {
        List<Product> products = new ArrayList<>();
        // Tạo dữ liệu sản phẩm mẫu
        for (int i = 0; i < 12; i++) {
            // Chỉ cần tên sản phẩm và giá
            products.add(new Product("Tên sản phẩm " + (i + 1), "M", (i + 1) * 100000));
        }
        return products;
    }

    private List<ProductImage> loadProductImages() {
        List<ProductImage> productImages = new ArrayList<>();
        // Tạo dữ liệu hình ảnh mẫu
        for (int i = 0; i < 12; i++) {
            // Giả sử bạn có hình ảnh tương ứng trong drawable với tên aokhoac1, aokhoac2, ...
            String imageName = "ao" ; // Giả sử bạn có ba hình ảnh aokhoac1, aokhoac2, aokhoac3
            int imageResId = getResources().getIdentifier(imageName, "drawable", getPackageName());
            productImages.add(new ProductImage(i, i, String.valueOf(imageResId))); // Tạo sản phẩm hình ảnh
        }
        return productImages;
    }
}