package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.OrderLine;

public class OrderLineDaoMysql implements LineDao<OrderLine> {

	public static final Logger LOGGER = Logger.getLogger(OrderLineDaoMysql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public OrderLineDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://35.246.58.104:3306/ims";
		this.username = username;
		this.password = password;
	}

	public OrderLineDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	OrderLine orderLineFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderLineId = resultSet.getLong("order_line_id");
		Long orderId = resultSet.getLong("order_id");
		Long itemId = resultSet.getLong("item_id");
		Long quantity = resultSet.getLong("quantity");
		return new OrderLine(orderLineId, orderId, itemId, quantity);
	}

	@Override
	public List<OrderLine> readAll(Long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_line WHERE order_line_id =" + id);) {
			ArrayList<OrderLine> orderLine = new ArrayList<>();
			while (resultSet.next()) {
				orderLine.add(orderLineFromResultSet(resultSet));
			}
			return orderLine;
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public OrderLine readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM order_line ORDER BY order_line_id DESC LIMIT 1");) {
			resultSet.next();
			return orderLineFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderLine create(OrderLine t) {
		// TODO Auto-generated method stub
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO order_line(order_id, item_id, quantity) values('" + t.getOrderId()
					+ "','" + t.getItemId() + "','" + t.getQuantity() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public OrderLine readOrderLine(Long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_line where order_line_id = " + id);) {

//			line.add(orderLineFromResultSet(resultSet));

		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderLine update(OrderLine t) {
		// TODO Auto-generated method stub
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("UPDATE order_line SET order_id =" + t.getOrderId() + ", item_id = " + t.getItemId()
					+ ", quantity = " + t.getQuantity() + " WHERE order_line_id = " + t.getOrderLineId());
			return readOrderLine(t.getOrderLineId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void delete(long line_id) {
		// TODO Auto-generated method stub
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("DELETE FROM order_line WHERE order_id = " + line_id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}

	}

}
