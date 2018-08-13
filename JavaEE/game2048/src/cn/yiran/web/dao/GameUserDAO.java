package cn.yiran.web.dao;

import cn.yiran.web.domain.GameUser;
import cn.yiran.web.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public interface GameUserDAO {
    QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    // 注册账号
    int register(GameUser user);

    // 激活账号
    int userActivate(String username);

    // 登录，返回数据
    GameUser login(String username,String password);

    // 查询所有用户
    List selectAll();

    // 根据规则(ruler)查询用户
    List selectRuler(int isActivate,String sort,String username);

    // 根据id查询用户
    GameUser selectById(int id);

    // 修改用户信息
    int updateUser(GameUser user);

    // 修改用户等级
    int updateLevel(String username,int userLevel);

    // 登记最高分数，当前分数与用户之前最高分数的判定在servlet中判定，若当前分数大于数据库中最高分数，则调用该方法
    int updateGoal(String username,int goal);

    // 修改密码，判断原密码输入是否正确，在servlet中比较，session存储User
    int updatePassword(String username,String password);

    // 修改邮箱
    int updateEmail(String username,String email);
}