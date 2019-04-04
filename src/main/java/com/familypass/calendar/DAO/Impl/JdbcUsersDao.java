package com.familypass.calendar.DAO.Impl;

import com.familypass.calendar.DAO.usersDao;
import com.familypass.calendar.Models.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.trimToNull;

@Repository
public class JdbcUsersDao implements usersDao {
    private static final String PROC_NEW_USER = "procNewUser";
    private static final String PROC_GET_USER = "procGetUser";

    private final SimpleJdbcCall addUser;
    private final SimpleJdbcCall getUser;

    public JdbcUsersDao(DataSource dataSource) {
        this.addUser = new SimpleJdbcCall(dataSource)
                .withCatalogName("picsfilmod")
                .withSchemaName("dbo")
                .withProcedureName(PROC_NEW_USER)
                .withReturnValue();
        this.getUser = new SimpleJdbcCall(dataSource)
                .withCatalogName("picsfilmod")
                .withSchemaName("dbo")
                .withProcedureName(PROC_GET_USER)
                .returningResultSet("userInfo", new UserRowMapper());
    }

    @Override
    public User selectUser(long userId, String userName, String userPassword) {
        SqlParameterSource inParams = new MapSqlParameterSource()
                .addValue("UserID", userId)
                .addValue("UserName", userName)
                .addValue("UserPassword", userPassword);
        Map<String, Object> out = getUser.execute(inParams);
        User currentUser = (User) out.get("userInfo");

        return currentUser;
    }

    @Override
    public long addUser(User newUser) {
        SqlParameterSource inParams = new MapSqlParameterSource()
                .addValue("UserName", newUser.getUserName())
                .addValue("FirstName", newUser.getFirstName())
                .addValue("LastName", newUser.getLastName())
                .addValue("UserState", newUser.getUserState())
                .addValue("UserCity", newUser.getUserCity())
                .addValue("UserEmail", newUser.getUserEmail())
                .addValue("UserZip", newUser.getUserZip())
                .addValue("UserPassword", newUser.getUserPassword());
        Map<String, Object> out = addUser.execute(inParams);
        long userId = (long) out.get("UserID");
        return userId;
    }

    private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setFirstName(trimToNull(rs.getString("FirstName")));
            user.setLastName(trimToNull(rs.getString("LastName")));
            user.setUserCity(trimToNull(rs.getString("UserCity")));
            user.setUserState(trimToNull(rs.getString("UserState")));
            user.setUserZip(trimToNull(rs.getString("UserZip")));
            user.setUserEmail(trimToNull(rs.getString("UserEmail")));
            return user;
        }
    }
}
