package me.jpomykala.jwt.service.token;

import me.jpomykala.jwt.model.user.User;
import org.springframework.mobile.device.Device;

/**
 * Created by Evelan on 26/12/2016.
 */
public interface TokenAuthenticationService {
    String getUsernameFromToken(String token);

    String createToken(User user, Device device);

    User getUserFromToken(String token);
}
