import com.zhijieketang.db.core.JdbcTemplate;

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

        String sql = "select name, userid from user where userid > ? order by userid";

        JdbcTemplate template = new JdbcTemplate() {

            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                // 绑定参数
                PreparedStatement ps = conn.prepareStatement(sql);
                // 绑定参数
                ps.setInt(1, 0);

                return ps;
            }

            @Override
            public void processRow(ResultSet rs) throws SQLException {
                System.out.printf("name: %s     id: %d \n",
                        rs.getString("name"),
                        rs.getInt("userid"));
            }

        };

        template.query();

    }

    /**
     * 插入数据
     */
    private static void create() {

        String sql = "insert into user (userid, name) values (?, ?)";
        JdbcTemplate template = new JdbcTemplate() {

            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                // 绑定参数
                PreparedStatement ps = conn.prepareStatement(sql);
                // 绑定参数
                ps.setInt(1, 999);
                ps.setString(2, "Tony999");

                return ps;
            }

            @Override
            public void processRow(ResultSet rs) throws SQLException {
            }

        };

        template.update();
    }

    /**
     * 更新数据
     */
    private static void update() {

        String sql = "update user set name=? where userid =?";
        JdbcTemplate template = new JdbcTemplate() {

            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                // 绑定参数
                PreparedStatement ps = conn.prepareStatement(sql);
                // 绑定参数
                ps.setString(1, "Tom999");
                ps.setInt(2, 999);

                return ps;
            }

            @Override
            public void processRow(ResultSet rs) throws SQLException {
            }

        };

        template.update();

    }

    /**
     * 删除数据
     */
    private static void delete() {

        String sql = "delete from user where userid = ?";
        JdbcTemplate template = new JdbcTemplate() {

            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                // 绑定参数
                PreparedStatement ps = conn.prepareStatement(sql);
                // 绑定参数
                ps.setInt(1, 999);

                return ps;
            }

            @Override
            public void processRow(ResultSet rs) throws SQLException {
            }

        };

        template.update();
    }

}
