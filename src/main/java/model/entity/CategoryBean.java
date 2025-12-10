package model.entity;  // エンティティクラスをまとめるパッケージ

public class CategoryBean {

    // フィールド（カテゴリ情報を保持する変数）
    private int categoryId;       // カテゴリID（数値）
    private String categoryName;  // カテゴリ名（文字列）

    // デフォルトコンストラクタ（引数なし）
    // JavaBeansでは必ず用意するのが慣習
    public CategoryBean() {}

    // Getter（値を取り出すメソッド）
    public int getCategoryId() {
        return categoryId;  // フィールド categoryId の値を返す
    }

    // Setter（値をセットするメソッド）
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;  // フィールドに値を代入
    }

    // Getter（カテゴリ名を取り出す）
    public String getCategoryName() {
        return categoryName;  // フィールド categoryName の値を返す
    }

    // Setter（カテゴリ名をセットする）
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;  // フィールドに値を代入
    }
}