package cn.yiran.web.dao.impl;

import cn.yiran.web.dao.GameUserDAO;
import cn.yiran.web.domain.GameUser;
import com.mchange.v1.util.ArrayUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.ArrayList;
import java.util.List;

public class GameUserDAOImpl implements GameUserDAO {
    @Override
    // 注册
    public int register(GameUser user) {
        String select = "select * from GameUser where username = ?";
        String register = "insert into GameUser(username,password,email) values(?,?,?)";
        int i = 0;
        try {
            GameUser gameUser = qr.query(select,new BeanHandler<>(GameUser.class),user.getUsername());
            if (gameUser == null){
                i = qr.update(register,user.getUsername(),user.getPassword(),user.getEmail());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    // 账号激活
    public int userActivate(String username) {
        String sql = "update GameUser set activate = true where username = ?";
        int i = 0;
        try {
            i = qr.update(sql,username);
        } catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    // 账号登录
    public GameUser login(String username,String password) {
        String login = "select * from GameUser where username=? and password=?";
        try {
            return qr.query(login,new BeanHandler<>(GameUser.class),username,password);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List selectAll() {
        String selectAll = "select * from GameUser";
        List<GameUser> userList = new ArrayList<>();
        try {
            userList = qr.query(selectAll,new BeanListHandler<>(GameUser.class));
        } catch (Exception e){
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public List selectRuler(int isActivate,String sort,String username) {
        String selectRuler = "select * from GameUser where activate = ? ";
        // 参数列表
        List objs = new ArrayList();

        // 第一个参数
        objs.add(isActivate);

        // 如果用户名模糊查询参数不为空
        if (!username.equals("")){
            // 模糊查询
            selectRuler = selectRuler + "and username like ? ";
            objs.add("%"+username+"%");
        }

        // 如果排序参数不为空
        if (!sort.equals("")){
            // ? 占位符用于防止sql注入，而排序 asc desc只有两种选择，不存在这个问题，所以不支持 ? 占位符
            selectRuler = selectRuler + "order by id "+sort;
        }

        List<GameUser> userList = new ArrayList<>();
        try {
            // 将数组转为字符串
            Object[] params = new Object[objs.size()];
            objs.toArray(params);

            userList = qr.query(selectRuler,new BeanListHandler<>(GameUser.class),params);
        } catch (Exception e){
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public GameUser selectById(int id) {
        String sql = "select * from GameUser where id=?";
        try {
            return qr.query(sql,new BeanHandler<>(GameUser.class),id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateUser(GameUser user) {
        String sql = "update GameUser set password=?,email=?,activate=?,userLevel=? where id=?";
        try {
            return qr.update(sql,user.getPassword(),user.getEmail(),user.isActivate(),user.getUserLevel(),user.getId());
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateLevel(String username, int userLevel) {
        return 0;
    }

    @Override
    public int updateGoal(String username, int goal) {
        String updateGoal = "update GameUser set max_goal = ? where username = ?";
        int i = 0;
        try {
            i = qr.update(updateGoal,goal,username);
        } catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int updatePassword(String username, String password) {
        return 0;
    }

    @Override
    public int updateEmail(String username, String email) {
        return 0;
    }
}
