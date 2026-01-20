package model.dao;  // DAO関連のクラスをまとめるパッケージ

import java.sql.Connection;     // DB接続を表すクラス
import java.sql.DriverManager;  // JDBCで接続を作るためのクラス

public class ConnectionManager {

    // DB接続を取得するメソッド
    public static Connection getConnection() throws Exception {

        // JDBCドライバをロード
        // MySQL用のドライバクラスをメモリに読み込む
        Class.forName("com.mysql.cj.jdbc.Driver");

        // DriverManagerを使ってDBに接続を確立
        // 引数は (接続URL, ユーザー名, パスワード)
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/product_management?useSSL=false&characterEncoding=UTF-8",
                "root",       // DBユーザー名
                "Araki221");  // DBパスワード
    }
}