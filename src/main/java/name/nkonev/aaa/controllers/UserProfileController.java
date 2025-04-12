package name.nkonev.aaa.controllers;

import jakarta.servlet.http.HttpSession;
import name.nkonev.aaa.Constants;
import name.nkonev.aaa.dto.UserAccountDetailsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import static name.nkonev.aaa.Constants.Headers.X_AUTH_USER_ID;

@Controller
public class UserProfileController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserProfileController.class);

    @ResponseBody
    @PreAuthorize("@aaaPermissionService.checkAuthenticatedInternal(#userAccount, #requestHeaders)")
    @GetMapping(value = {Constants.Urls.INTERNAL_API + Constants.Urls.PROFILE, Constants.Urls.INTERNAL_API + Constants.Urls.PROFILE + Constants.Urls.AUTH}, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpHeaders checkAuthenticatedInternal(@AuthenticationPrincipal UserAccountDetailsDTO userAccount, HttpSession session, @RequestHeader HttpHeaders requestHeaders) {
        LOGGER.info("Requesting internal user profile");
        var responseHeaders = new HttpHeaders();
        responseHeaders.set(X_AUTH_USER_ID, ""+userAccount.getId());
        return responseHeaders;
    }

}
