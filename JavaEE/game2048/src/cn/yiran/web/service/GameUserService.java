package cn.yiran.web.service;

import cn.yiran.web.dao.GameUserDAO;
import cn.yiran.web.dao.impl.GameUserDAOImpl;
import cn.yiran.web.domain.GameUser;

import java.util.List;

public interface GameUserService {
    GameUserDAO gameUserDAO = new GameUserDAOImpl();

    // 注册账号
    boolean register(GameUser user);

    // 激活账号
    boolean userActivate(String username);

    // 登录，返回数据
    GameUser login(String username,String password);

    // 查询所有用户
    List selectAll();

    // 根据规则(ruler)查询用户
    List selectRuler(int isActivate,String sort,String username);

    // 根据id查询用户
    GameUser selectById(int id);

    Boolean updateUser(GameUser user);

    // 修改用户等级
    boolean updateLevel(String username,int userLevel);

    // 登记最高分数，当前分数与用户之前最高分数的判定在servlet中判定，若当前分数大于数据库中最高分数，则调用该方法
    boolean updateGoal(String username,int goal);

    // 修改密码，判断原密码输入是否正确，在servlet中比较，session存储User
    boolean updatePassword(String username,String password);

    // 修改邮箱
    boolean updateEmail(String username,String email);
}
