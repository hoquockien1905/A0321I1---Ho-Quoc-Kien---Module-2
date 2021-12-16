package model.repository.impl;

import model.bean.Category;
import model.bean.Product;
import model.repository.CategoryRepository;
import model.repository.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {

    private static final String SELECT_ALL_CATEGORY = "SELECT * FROM category";

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection()
                    .prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCategory = resultSet.getInt("id_category");
                String nameCategory = resultSet.getString("name_category");
                categories.add(new Category(idCategory, nameCategory));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return categories;
    }
}
