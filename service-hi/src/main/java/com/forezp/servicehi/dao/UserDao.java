package com.forezp.servicehi.dao;

import com.alibaba.fastjson.JSONObject;
import com.forezp.servicehi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @Author MSI
     * @Description 添加用户
     * @Date 2018/12/24 9:40
     * @Param [user]
     * @return int 返回影响的行数，不大于等于1则说明失败
     **/
    public int addUser(User user) {
        String sql = "insert into user(name,password)values(?,?)";
        return jdbcTemplate.update(sql,user.getUserName(),user.getPassword());
    }

    /**
     * @Author MSI
     * @Description 删除用户
     * @Date 2018/12/24 9:51
     * @Param [id]
     * @return int 返回影响的行数，不大于等于1则说明失败
     **/
    public int deleteUser(Integer id) {
        String sql = "delete from user where id = ?";
        return jdbcTemplate.update(sql,id);
    }

    /**
     * @Author MSI
     * @Description 修改用户
     * @Date 2018/12/24 10:02
     * @Param [user]
     * @return int 返回影响行数，不大于等于1则说明失败
     **/
    public int updateUser(User user) {
        String sql = "update user set name = ?,password =? where id = ?";
        return jdbcTemplate.update(sql,user.getUserName(),user.getPassword(),user.getId());
    }

    /**
     * @Author MSI
     * @Description 根据用户名查询用户详情
     * @Date 2018/12/24 18:06
     * @Param [userName] 用户名
     * @return com.forezp.servicehi.model.User  如果存在就返回用户，不存在就返回NULL
     **/
    public String detail(String name) {
        String sql = "select * from user where name = ?";
        User user = jdbcTemplate.queryForObject(sql,new UserRowMapper(),name);
        return user == null
                ? null
                :JSONObject.toJSONString(user);
    }

    /**
     * @Author MSI
     * @Description 查询用户列表
     * @Date 2018/12/24 11:04
     * @Param [userName]
     * @return java.util.List<com.forezp.servicehi.model.User>
     **/
    public List<User> getListUser() {
        List userList = jdbcTemplate.queryForList("select * from user ");
        return userList;
    }

    class UserRowMapper implements RowMapper<User> {
        //rs为返回结果集，以每行为单位封装着
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    }

}
