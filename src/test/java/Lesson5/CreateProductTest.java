package Lesson5;

import com.github.javafaker.Faker;
import Lesson5.api.ProductService;
import Lesson5.dto.Product;
import Lesson5.utils.RetrofitUtils;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class CreateProductTest {

    static ProductService productService;
    Product product = null;
    Faker faker = new Faker();
    int id;

    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);

    }

    @BeforeEach
    void setUp() {
        product = new Product()
                .withTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withPrice((int) (Math.random() * 10000));
    }

    @Test
    void createProduct() throws IOException {
        Response<Product> response = productService.createProduct(product)
                .execute();

        assert response.body() != null;
        id = response.body().getId();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }

    @Test
    void modifyProduct() throws IOException {
        product.setId(id);
        Response<Product> response = productService.modifyProduct(product)
                .execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));

    }

    @Test
    void getProducts() throws IOException {
        Response<ResponseBody> response = productService.getProducts()
                .execute();

        assertThat(response.isSuccessful(), CoreMatchers.is(true));

    }

    @Test
    void getProduct() throws IOException {
        Response<Product> response = productService.getProductById(id)
                .execute();

        assertThat(response.isSuccessful(), CoreMatchers.is(true));

    }

}