package vn.tphan.jhipster.core;

public class Constants {
    public static final String JWT_SECRET = "secret";
    public static final String AUTH_TOKEN_PREFIX = "Bearer ";
    public static final String AUTH_HEADER_STRING = "Authorization";
    public static final String JWT_SCOPE = "scope";

    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";

    public static final String DEFAULT_PASSWORD = "123456";
    public static final Integer BOARD_SIZE = 5;
    public static final Integer RED_STARTING_POSITION = 0;
    public static final Integer BLUE_STARTING_POSITION = 4;
    public enum Color {
        RED, BLUE
    }
    // Error constants
    public static final String PROBLEM_BASE_URL = "http://tphan.jhipster.test/problem";
}
