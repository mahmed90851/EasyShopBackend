package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.ShoppingCartDao;
import org.yearup.models.ShoppingCart;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.yearup.data.mysql.MySqlProductDao.mapRow;

@Component
public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao {
    public MySqlShoppingCartDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public ShoppingCart getByUserId(int userId) {
        String sql = "SELECT * FROM shopping_cart WHERE user_id = ?";

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

            } else {
                return null; // Category not found
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }


    @Override
    public void addItemToCart(int userId) {

    }

    @Override
    public void updateCart(int cartId, int productId, int quantity) {

    }

    @Override
    public void clearCart(int cartId) {

    }
}
