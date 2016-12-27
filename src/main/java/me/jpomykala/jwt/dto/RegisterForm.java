package me.jpomykala.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Evelan on 27/12/2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterForm extends LoginForm implements Serializable {

    private static final long serialVersionUID = -8800975420336756399L;
    private String firstName;
    private String lastName;
}
