package ru.job4j.jdbc;

import jdk.jfr.EventSettings;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {

    public static Connection getConnection() throws Exception {

        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream inputStream = loader.getResourceAsStream("app.properties")) {
            settings.load(inputStream);
        }
        String url = settings.getValue("hibernate.connection.url");
        String login = settings.getValue("hibernate.connection.username");
        String password = settings.getValue("hibernate.connection.password");

        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, login, password);
    }
}

//    public static void main(String[] args) throws Exception {
//
//        Settings settings = new Settings();
//        ClassLoader loader = Settings.class.getClassLoader();
//        try (InputStream inputStream = loader.getResourceAsStream("app.properties")) {
//            settings.load(inputStream);
//        }
//        String url = settings.getValue("hibernate.connection.url");
//        String login = settings.getValue("hibernate.connection.username");
//        String password = settings.getValue("hibernate.connection.password");
//
//        Class.forName("org.postgresql.Driver");
////        String url = "jdbc:postgresql://localhost:5432/job4j_database";
////        String login = "postgres";
////        String password = "password";
//        try (Connection connection = DriverManager.getConnection(url, login, password)) {
//            DatabaseMetaData metaData = connection.getMetaData();
//            System.out.println(metaData.getUserName());
//            System.out.println(metaData.getURL());
//        }
//    }
//}