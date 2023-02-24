package dao;

import model.Product;
import model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductDaoTest {

    @Test
    void insert() {
        User user = new User();
        user.setUsername("admin");
        Product product = new Product(2,"Tương ót","Gia vị",12000,new Date(System.currentTimeMillis()),user);
        ProductDao dao = new ProductDao();
        int result = dao.insert(product);
        Assertions.assertEquals(1,result);
    }
    @Test
    void selectAll() {
        User user = new User();
        user.setUsername("admin");
        ProductDao dao = new ProductDao();
        List<Product> productList = dao.selectAll(user);
        Assertions.assertEquals(2,productList.size());
    }
}