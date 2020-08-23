package vn.tphan.jhipster.service.dto;

import vn.tphan.jhipster.config.Constants;

import vn.tphan.jhipster.domain.Authority;
import vn.tphan.jhipster.domain.User;

import javax.validation.constraints.*;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

public class UserRegisterDTO {
    private Long id;

    @NotBlank
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    private String login;

    @Size(min = 1, max = 50)
    private String password;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

    @Email
    @Size(min = 5, max = 254)
    private String email;

    @Size(max = 256)
    private String imageUrl;

    public UserRegisterDTO(Long id, @NotBlank @Pattern(regexp = Constants.LOGIN_REGEX) @Size(min = 1, max = 50) String login, @Size(min = 1, max = 50) String password, @Size(max = 50) String firstName, @Size(max = 50) String lastName, @Email @Size(min = 5, max = 254) String email, @Size(max = 256) String imageUrl, @Size(min = 2, max = 10) String langKey) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.imageUrl = imageUrl;
        this.langKey = langKey;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Size(min = 2, max = 10)
    private String langKey;

    public UserRegisterDTO() {
        // Empty constructor needed for Jackson.
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getLangKey() {
        return langKey;
    }

    @Override
    public String toString() {
        return "UserRegisterDTO{" +
            "id=" + id +
            ", login='" + login + '\'' +
            ", password='" + "********" + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", imageUrl='" + imageUrl + '\'' +
            ", langKey='" + langKey + '\'' +
            '}';
    }
}
