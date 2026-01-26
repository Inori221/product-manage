package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.entity.CategoryBean;

@WebServlet("/category-register")
public class CategoryRegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String idStr = request.getParameter("id");
        String name = request.getParameter("categoryName");

        // ===== バリデーション =====
        if (idStr == null || idStr.isEmpty() ||
            name == null || name.isEmpty()) {

            request.setAttribute("error", "すべて必須入力です");
            request.getRequestDispatcher("category-register.jsp")
                   .forward(request, response);
            return;
        }

        int categoryId;
        try {
            categoryId = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "カテゴリIDは数値で入力してください");
            request.getRequestDispatcher("category-register.jsp")
                   .forward(request, response);
            return;
        }

        // ===== 登録処理 =====
        CategoryBean category = new CategoryBean();
        category.setCategoryId(categoryId);
        category.setCategoryName(name);

        CategoryDAO dao = new CategoryDAO();
        dao.insert(category);

        // ===== 一覧へリダイレクト =====
        response.sendRedirect("category-list");
    }
}
