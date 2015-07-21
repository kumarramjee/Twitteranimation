package twitter.mobimedia.com.twitteranimationnn.utility;

/**
 * Created by ram on 21/7/15.
 */
public class Validation {
    public String signUpValidation(String email) {
        String message = "";
        if (email.trim().length() == 0) {
            return message = "Please enter First Name";
        }
        return message;
    }
}
