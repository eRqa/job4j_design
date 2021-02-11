package ru.job4j.jdbc;

import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        connection = ConnectionDemo.getConnection();
    }

    public void createTable(String tableName) throws Exception {
            String query = String.format("CREATE TABLE %s", tableName);
            executeQuery(query);
    }

    public void dropTable(String tableName) throws Exception {
            String query = String.format("DROP TABLE %s", tableName);
            executeQuery(query);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
            String query = String.format("ALTER TABLE %s"
                    + "ADD %s %s", tableName, columnName, type);
            executeQuery(query);
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
            String query = String.format("ALTER TABLE %s"
                    + "DROP COLUMN %s", tableName, columnName);
            executeQuery(query);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
            String query = String.format("ALTER TABLE %s"
                    + "RENAME COLUMN %s TO %s", tableName, columnName, newColumnName);
            executeQuery(query);
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    private void executeQuery(String sql) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}