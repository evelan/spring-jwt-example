package me.jpomykala.jwt.dto;

import lombok.*;

import java.io.Serializable;

/**
 * Created by Evelan on 27/12/2016.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm implements Serializable {

    private static final long serialVersionUID = -3737834250293389666L;

    protected String username;
    protected String password;
}
