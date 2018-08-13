package cn.yiran.web.service.impl;

import cn.yiran.web.domain.GameUser;
import cn.yiran.web.service.GameUserService;

import java.util.List;

public class GameUserServiceImpl implements GameUserService {
    @Override
    public boolean register(GameUser user) {
        if (gameUserDAO.register(user) == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean userActivate(String username) {
        if (gameUserDAO.userActivate(username) == 1){
            return true;
        }
        return false;
    }

    @Override
    public GameUser login(String username, String password) {
        return gameUserDAO.login(username,password);
    }

    @Override
    public List selectAll() {
        return gameUserDAO.selectAll();
    }

    @Override
    public List selectRuler(int isActivate, String sort, String username) {
        return gameUserDAO.selectRuler(isActivate,sort,username);
    }

    @Override
    public GameUser selectById(int id) {
        return gameUserDAO.selectById(id);
    }

    @Override
    public Boolean updateUser(GameUser user) {
        if (gameUserDAO.updateUser(user) == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateLevel(String username, int userLevel) {
        return false;
    }

    @Override
    public boolean updateGoal(String username, int goal) {
        if (gameUserDAO.updateGoal(username,goal) == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePassword(String username, String password) {
        return false;
    }

    @Override
    public boolean updateEmail(String username, String email) {
        return false;
    }
}
