package me.jpomykala.jwt.controller;

import me.jpomykala.jwt.dto.LoginForm;
import me.jpomykala.jwt.dto.RegisterForm;
import me.jpomykala.jwt.model.user.User;
import me.jpomykala.jwt.service.token.TokenAuthenticationService;
import me.jpomykala.jwt.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Evelan on 27/12/2016.
 */
@RestController
public class AuthenticationController {

    private final TokenAuthenticationService tokenAuthenticationService;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationController(TokenAuthenticationService tokenAuthenticationService, UserService userService, AuthenticationManager authenticationManager) {
        this.tokenAuthenticationService = tokenAuthenticationService;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/auth/login")
    public String authorizeUser(@RequestBody LoginForm loginForm, Device device) throws AuthenticationException {
        final String username = loginForm.getUsername();
        final String password = loginForm.getPassword();

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final User user = userService.findUser(username);
        return tokenAuthenticationService.createToken(user, device);
    }

    @PostMapping("/auth/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody RegisterForm registerForm, Device device) throws AuthenticationException {
        return userService.register(registerForm, device);

    }
}
