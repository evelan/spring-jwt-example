package me.jpomykala.jwt.model.user;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * Created by Evelan on 08/12/2016.
 */
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@AllArgsConstructor
public class User implements Serializable, UserDetails {

    private static final long serialVersionUID = 2427238057150579366L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true, length = 512)
    @Email
    private String email;

    @NotBlank
    private String password;

    @Column(name = "profile_image", length = 2048)
    private String profileImage;

    @CreatedDate
    private Date registered;

    private Boolean enabled;

    @Version
    @Column(name = "version")
    private long version = 0L;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
