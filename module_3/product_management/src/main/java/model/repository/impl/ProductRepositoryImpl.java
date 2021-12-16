package model.repository.impl;

import model.bean.Product;
import model.repository.DBConnection;
import model.repository.ProductRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {

    private static final String SELECT_ALL_PRODUCT =
            "SELECT * FROM product INNER JOIN category ON category.id_category = product.id_category";
    private static final String INSERT_PRODUCT = "INSERT INTO `democ07`.`product` (`name_product`, `price`, `status`, `id_category`) " +
            "VALUES (?,?,?,?)";
    private static final String UPDATE_PRODUCT =
            "UPDATE product SET name_product = ?, price = ?, status = ?, id_category = ? WHERE id_product = ?;";
    private static final String DELETE_PRODUCT =
            "DELETE FROM product WHERE id_product = ?;";
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection()
                    .prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_product");
                String name = resultSet.getString("name_product");
                double price = resultSet.getDouble("price");
                boolean status = resultSet.getBoolean("status");
                int idCategory = resultSet.getInt("id_category");
                String nameCategory = resultSet.getString("name_category");
                products.add(new Product(id, name, price, status, idCategory, nameCategory));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return products;
    }


    @Override
    public void save(Product product) {
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection()
                    .prepareStatement(INSERT_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setBoolean(3, product.isStatus());
            preparedStatement.setInt(4, product.getIdCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection()
                    .prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setBoolean(3, product.isStatus());
            preparedStatement.setInt(4, product.getIdCategory());
            preparedStatement.setInt(5, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.close();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection()
                    .prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.close();
        }
    }

    @Override
    public Product findById(int id) {
        return null;
    }
}
