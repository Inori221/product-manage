package servlet;  // サーブレットクラスをまとめるパッケージ

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;   // JSPへ処理を転送するためのクラス
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; // サーブレットのURLマッピングを指定するアノテーション
import javax.servlet.http.HttpServlet;     // サーブレットの基本クラス
import javax.servlet.http.HttpServletRequest; // クライアントからのリクエスト情報を扱う
import javax.servlet.http.HttpServletResponse; // サーバーからのレスポンス情報を扱う

import model.dao.CategoryDAO;   // DBアクセス用のDAOクラス
import model.entity.CategoryBean; // カテゴリ情報を保持するBeanクラス

// このサーブレットを呼び出すURLを指定
// ※ 本来は "/category-list" のようにパスだけを書くのが正しいです。
//   "http://localhost:8080/..." と書くのは誤りなので注意。
@WebServlet("/category-list")
public class CategoryListServlet extends HttpServlet {

    // GETリクエストを受け取ったときの処理
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // DAOを使ってカテゴリ一覧を取得
            CategoryDAO dao = new CategoryDAO();
            List<CategoryBean> list = dao.findAll();

            // 取得したカテゴリ一覧をリクエストスコープに保存
            request.setAttribute("categoryList", list);

            // JSPに処理を転送（画面表示を任せる）
            RequestDispatcher rd = request.getRequestDispatcher("category-list.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            // 例外が発生した場合はログ出力
            e.printStackTrace();

            // エラーメッセージをリクエストスコープに保存
            request.setAttribute("error", "データベース接続エラー");

            // エラー画面へ転送
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}