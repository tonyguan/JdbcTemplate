import java.sql.*;

public class Main {

    public static void main(String[] args) {

        //查询数据
        read();
        //数据插入
        create();
        //数据更新
        update();
        //删除数据
        delete();

    }

    /**
     * 查数据
     */
    private static void read() {

        // 载数据库驱动
        loadDBDriver();

        String sql = "select name, userid from user where userid > ? order by userid";

        Connection connection = null;
        PreparedStatement ps = null;
        try {
            // 创建数据库连接
            connection = getConnection();

            // 创建语句对象
            ps = connection.prepareStatement(sql);

            // 绑定参数
            ps.setInt(1, 0);
            ResultSet rs = ps.executeQuery();

            //遍历结果集
            while (rs.next()) {
                System.out.printf("name: %s     id: %d \n",
                        rs.getString("name"),
                        rs.getInt("userid"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 插入数据
     */
    private static void create() {

        // 载数据库驱动
        loadDBDriver();

        String sql = "insert into user (userid, name) values (?, ?)";

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            // 建数据库连接
            connection = getConnection();

            // 创建语句对象
            ps = connection.prepareStatement(sql);

            // 绑定参数
            ps.setInt(1, 999);
            ps.setString(2, "Tony999");
            // 执行SQL语句
            int count = ps.executeUpdate();

            System.out.printf("成功插入%d条数据.\n", count);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 更新数据
     */
    private static void update() {

        // 载数据库驱动
        loadDBDriver();

        String sql = "update user set name=? where userid =?";

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            // 创建数据库连接
            connection = getConnection();

            // 创建语句对象
            ps = connection.prepareStatement(sql);

            // 绑定参数
            ps.setString(1, "Tom999");
            ps.setInt(2, 999);
            // 执行SQL语句
            int count = ps.executeUpdate();

            System.out.printf("成功更新%d条数据.\n", count);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 删除数据
     */
    private static void delete() {

        // 载数据库驱动
        loadDBDriver();

        String sql = "delete from user where userid = ?";

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            // 创建数据库连接
            connection = getConnection();

            // 创建语句对象
            ps = connection.prepareStatement(sql);

            // 绑定参数
            ps.setInt(1, 999);
            // 执行SQL语句
            int count = ps.executeUpdate();

            System.out.printf("成功删除%d条数据.\n", count);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 建立数据库连接
     *
     * @return 返回数据库连接对象
     * @throws SQLException
     */
    private static Connection getConnection() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/mydb?verifyServerCertificate=false&useSSL=false";
        String user = "root";
        String password = "12345";

        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    /**
     * 加载数据库驱动
     */
    private static void loadDBDriver() {
        // 1.
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
