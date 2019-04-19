package BY.Oreshko.Serv.builder;

import BY.Oreshko.Serv.repository.dbconstsnts.UserTableConstants;
import BY.Oreshko.Serv.exception.RepositoryException;
import BY.Oreshko.Serv.model.User;
import BY.Oreshko.Serv.util.HashPassword;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserBuilderTest {
    private static final Integer ID = 1;
    private static final String LOGIN = "admin";
    private static final byte [] PASSWORD = HashPassword.getHash("admin");
    private User EXPECTED_USER = null;
    @Before
    public void initExpectedUser(){
        EXPECTED_USER = new User(
                ID,
                LOGIN,
                PASSWORD
        );
    }
    //@Ignore
    @Test
    public void shouldBuildAndReturnUserWithParameters() throws SQLException,
            RepositoryException {
        // Arrange
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt(UserTableConstants.ID.getFieldName())).thenReturn(ID);
        when(resultSet.getString(UserTableConstants.LOGIN.getFieldName())).thenReturn(LOGIN);
        when(resultSet.getBytes(UserTableConstants.PASSWORD.getFieldName())).thenReturn(PASSWORD);
        // Act
        UserBuilder userBuilder = new UserBuilder();
        User actualUser = userBuilder.build(resultSet);
        //Assert
        assertEquals(EXPECTED_USER, actualUser);
    }
}