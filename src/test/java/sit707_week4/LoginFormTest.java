package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * Author: Bidhan Babu Gupta
 */
public class LoginFormTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "223623837";
        Assert.assertNotNull("Student ID should not be null", studentId);
        Assert.assertEquals("223623837", studentId); // Verify the student ID value
    }

    @Test
    public void testStudentName() {
        String studentName = "Bidhan Babu Gupta";
        Assert.assertNotNull("Student name should not be null", studentName);
        Assert.assertEquals("Bidhan Babu Gupta", studentName); // Verify the student name value
    }

    @Test
    public void testLoginWithEmptyUsernameAndEmptyPassword() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testLoginWithEmptyUsernameAndCorrectPassword() {
        LoginStatus status = LoginForm.login(null, "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testLoginWithCorrectUsernameAndEmptyPassword() {
        LoginStatus status = LoginForm.login("ahsan", null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testLoginWithCorrectUsernameAndCorrectPasswordButIncorrectValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertFalse(status.getErrorMsg().contains("123456"));
    }

    @Test
    public void testLoginWithWrongUsernameAndCorrectPassword() {
        LoginStatus status = LoginForm.login("abc", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testLoginWithCorrectUsernameAndWrongPassword() {
        LoginStatus status = LoginForm.login("ahsan", "xyz");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testLoginWithCorrectUsernameAndCorrectPasswordAndCorrectValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertEquals("123456", status.getErrorMsg()); // Assuming error message contains validation code
    }

    @Test
    public void testValidateCodeWithNullCode() {
        boolean isValid = LoginForm.validateCode(null);
        Assert.assertFalse(isValid);
    }

    @Test
    public void testValidateCodeWithIncorrectCode() {
        boolean isValid = LoginForm.validateCode("abcd");
        Assert.assertFalse(isValid);
    }

    @Test
    public void testValidateCodeWithCorrectCode() {
        boolean isValid = LoginForm.validateCode("123456");
        Assert.assertTrue(isValid);
    }

    // Add more test methods to cover remaining scenarios

    @Test
    public void testLoginWithEmptyUsernameAndCorrectPasswordAndIncorrectValidationCode() {
        LoginStatus status = LoginForm.login("", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testLoginWithIncorrectUsernameAndEmptyPassword() {
        LoginStatus status = LoginForm.login("abc", "");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testLoginWithIncorrectUsernameAndCorrectPasswordAndIncorrectValidationCode() {
        LoginStatus status = LoginForm.login("abc", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

}
