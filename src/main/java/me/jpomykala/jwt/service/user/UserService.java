package me.jpomykala.jwt.service.user;

import me.jpomykala.jwt.dto.RegisterForm;
import me.jpomykala.jwt.model.user.User;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Evelan on 26/12/2016.
 */
public interface UserService extends UserDetailsService {
    User findUser(String email);

    User register(RegisterForm registerForm, Device device);
}
