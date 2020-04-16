package cn.sdut.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addAccount(Account account) {
        String sql = "insert into account(username, balance) value(?,?)";
        Object[] objects = new Object[]{
                account.getUsername(),
                account.getBalance()
        };
        return this.jdbcTemplate.update(sql, objects);
    }

    @Override
    public int updateAccount(Account account) {
        String sql = "update account set username=?,balance=? where id=?";
        Object[] objects = new Object[]{
                account.getUsername(),
                account.getBalance(),
                account.getId()
        };
        return this.jdbcTemplate.update(sql, objects);
    }

    @Override
    public int deleteAccount(int id) {
        String sql = "delete from account where id = ?";
        return this.jdbcTemplate.update(sql, id);
    }

    @Override
    public Account findAccountById(int id) {
        String sql = "select * from account where id = ?";
        /*创建一个新的BeanPropertyRowMapper对象*/
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<>(Account.class);
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public List<Account> findAllAccount() {
        String sql = "select * from account";
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<>(Account.class);
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    /**
     * 转账
     *
     * @param outUser 汇款人
     * @param inUser  收款人
     * @param money   收款金额
     */
    @Override
    public void transfer(String outUser, String inUser, Double money) {
        this.jdbcTemplate.update("update account set balance = balance + ?" +
                "where username = ?", money, inUser);
        //模拟突发问题
//        int i = 1 / 0;
        this.jdbcTemplate.update("update account set balance = balance - ?" +
                "where username = ?", money, outUser);
    }
}
