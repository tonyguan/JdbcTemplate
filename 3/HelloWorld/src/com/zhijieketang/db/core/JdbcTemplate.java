package com.zhijieketang.db.core;

import java.sql.*;

public abstract class JdbcTemplate {

    public final void query() {

        // 1、载数据库驱动
        loadDBDriver();

        Connection connection = null;
        PreparedStatement ps = null;
        try {
            // 2、创建数据库连接
            connection = getConnection();

            // 3、创建语句对象 4、绑定参数
            ps = createPreparedStatement(connection);

            // 5、执行查询
            ResultSet rs = ps.executeQuery();

            // 6、遍历结果集
            while (rs.next()) {
                processRow(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 7、释放资源
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

    public final void update() {

        // 1、载数据库驱动
        loadDBDriver();

        Connection connection = null;
        PreparedStatement ps = null;
        try {
            // 2、创建数据库连接
            connection = getConnection();

            // 3、创建语句对象 4、绑定参数
            ps = createPreparedStatement(connection);

            // 5、执行SQL语句
            int count = ps.executeUpdate();

            System.out.printf("成功修改%d条数据.\n", count);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6、释放资源
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
     * 遍历结果集时，处理结果集
     * @param rs 结果集
     * @throws SQLException
     */
    public abstract void processRow(ResultSet rs) throws SQLException;

    /**
     * 创建语句对象，其中包括指定SQL语句，绑定参数。
     * @param conn 连接对象
     * @return 语句对象
     * @throws SQLException
     */
    public abstract PreparedStatement createPreparedStatement(Connection conn)
            throws SQLException;

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
