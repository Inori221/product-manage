package model.dao;  // DAOクラスが入るパッケージ

import java.sql.Connection;        // DB接続用
import java.sql.PreparedStatement; // SQLを安全に実行するためのクラス
import java.sql.ResultSet;         // SQLの結果を受け取るクラス
import java.util.ArrayList;        // 可変長リスト
import java.util.List;             // Listインターフェース

import model.entity.CategoryBean;  // データを入れるエンティティクラス

public class CategoryDAO {

    // categoriesテーブルの全データを取得するメソッド
    public List<CategoryBean> findAll() throws Exception {

        // CategoryBeanを入れるリストを用意
        List<CategoryBean> list = new ArrayList<>();

        // 実行するSQL文（カテゴリIDと名前をID順に取得）
        String sql = "SELECT id, category_name FROM categories ORDER BY id";

        // try-with-resources構文でDB接続やステートメントを自動クローズ
        try (Connection conn = ConnectionManager.getConnection(); // DB接続を取得
             PreparedStatement ps = conn.prepareStatement(sql);   // SQLを準備
             ResultSet rs = ps.executeQuery()) {                  // SQLを実行して結果を取得

            // 結果セットを1行ずつ処理
            while (rs.next()) {
                // 1行分のデータをCategoryBeanに詰める
                CategoryBean cb = new CategoryBean();
                cb.setCategoryId(rs.getInt("id"));       // id列を取得
                cb.setCategoryName(rs.getString("category_name")); // category_name列を取得

                // リストに追加
                list.add(cb);
            }
        }

        // 全件分のCategoryBeanリストを返す
        return list;
    }
}