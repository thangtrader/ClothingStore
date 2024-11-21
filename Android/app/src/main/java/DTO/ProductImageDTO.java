package DTO;

import com.google.gson.annotations.SerializedName;

public class ProductImageDTO {
    private int id;
    @SerializedName("product_id")
    private int productId;
    @SerializedName("image_url")
    private String imageUrl;

    public ProductImageDTO(int productId) {
        this.productId = productId;
    }

    public ProductImageDTO(int id, int productId, String imageUrl) {
        this.id = id;
        this.productId = productId;
        this.imageUrl = imageUrl;
    }


    public ProductImageDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
