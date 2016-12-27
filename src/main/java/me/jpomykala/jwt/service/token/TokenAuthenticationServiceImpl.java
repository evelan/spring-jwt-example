package me.jpomykala.jwt.service.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import me.jpomykala.jwt.model.user.User;
import me.jpomykala.jwt.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Service;

/**
 * Created by Evelan on 26/12/2016.
 */
@Slf4j
@Service
public class TokenAuthenticationServiceImpl implements TokenAuthenticationService {

    private String secret = "mySuperSecretToken";

    @Autowired
    private UserService userService;

    @Override
    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    @Override
    public String createToken(User user, Device device) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    @Override
    public User getUserFromToken(String token) {
        final String username = getUsernameFromToken(token);
        return userService.findUser(username);
    }
}