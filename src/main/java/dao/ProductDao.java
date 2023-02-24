package dao;

import database.PostgreJDBC;
import model.Product;
import model.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public int insert(Product product) {
        int result =0;
        try {
            Connection connection = PostgreJDBC.getConnection();
            String sql_insert ="insert into product(id,name,type,price,date_buy,username)" +
                    "values (?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql_insert);
            pst.setInt(1,product.getId());
            pst.setString(2,product.getName());
            pst.setString(3,product.getType());
            pst.setInt(4,product.getPrice());
            pst.setDate(5,product.getDate_buy());
            pst.setString(6,product.getUser().getUsername());
            result = pst.executeUpdate();
            System.out.println(sql_insert);
            PostgreJDBC.closeConnection(connection);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public List<Product> selectAll(User user) {
        List<Product> productList = new ArrayList<>();
        try {
            Connection connection = PostgreJDBC.getConnection();
            String sql_selectAll ="select * from product where username=?";
            PreparedStatement pst = connection.prepareStatement(sql_selectAll);
            pst.setString(1,user.getUsername());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String type = rs.getString(3);
                int price = rs.getInt(4);
                Date date_buy = rs.getDate(5);
                Product product = new Product();
                product.setId(id);
                product.setName(name);
                product.setType(type);
                product.setPrice(price);
                product.setDate_buy(date_buy);
                productList.add(product);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
    public int delete(int id) {
        int result = 0;
        try {
            Connection connection = PostgreJDBC.getConnection();
            String sql_delete ="delete from product where id=?";
            PreparedStatement pst = connection.prepareStatement(sql_delete);
            pst.setInt(1,id);
            pst.executeUpdate();
            System.out.println(sql_delete);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

//    public int sumPriceProduct(User user) {
//
//        try {
//            Connection connection = PostgreJDBC.getConnection();
//            String sql_selectAll ="select sum(price) from product where username=?";
//            PreparedStatement pst = connection.prepareStatement(sql_selectAll);
//            pst.setString(1,user.getUsername());
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ;
//    }


}
