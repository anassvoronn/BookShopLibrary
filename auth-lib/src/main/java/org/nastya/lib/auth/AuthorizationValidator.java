package org.nastya.lib.auth;

import org.nastya.lib.auth.exception.UserAuthorizationValidationException;

public class AuthorizationValidator {
    private final UserAuthorizationChecker authorizationChecker;

    public AuthorizationValidator(UserAuthorizationChecker authorizationChecker) {
        this.authorizationChecker = authorizationChecker;
    }

    public void validateUserAuthorization(String sessionId) throws UserAuthorizationValidationException {
        if (!authorizationChecker.isUserAuthorized(sessionId)) {
            throw new UserAuthorizationValidationException("User is not authorized to perform this action");
        }
    }

    public Integer getUserIdIfAuthorized(String sessionId) throws UserAuthorizationValidationException {
        validateUserAuthorization(sessionId);
        Integer userId = authorizationChecker.getUserIdBySessionId(sessionId);

        if (userId == null) {
            throw new UserAuthorizationValidationException("User ID not found for session ID: " + sessionId);
        }

        return userId;
    }
}
