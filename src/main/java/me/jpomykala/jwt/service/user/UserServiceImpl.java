package me.jpomykala.jwt.service.user;

import me.jpomykala.jwt.dto.RegisterForm;
import me.jpomykala.jwt.model.user.User;
import me.jpomykala.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Evelan on 26/12/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findOneByEmail(s);
    }

    @Override
    public User findUser(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public User register(RegisterForm registerForm, Device device) {

        Optional<User> userOptional = Optional.ofNullable(userRepository.findOneByEmail(registerForm.getUsername()));
        if (userOptional.isPresent()) {
            throw new IllegalArgumentException("User exists by email");
        }

        User user = User.builder()
                .email(registerForm.getUsername())
                .password(registerForm.getPassword())
                .firstName(registerForm.getFirstName())
                .lastName(registerForm.getFirstName())
                .enabled(Boolean.TRUE) // TODO - MOCKED
                .build();

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }
}
