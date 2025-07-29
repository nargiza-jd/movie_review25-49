package kg.attractor.movie_review2549.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final PasswordEncoder encoder;

    private final DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource);
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(encoder.encode("qwerty"))
                .roles("ADMIN")
                .authorities("FULL")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(encoder.encode("qwe"))
                .roles("USER")
                .authorities("READ_ONLY")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

//    private final DataSource dataSource;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        String userQuery = "select email, PASSWORD, ENABLED\n" +
//                "from USER_TABLE\n" +
//                "where EMAIL = ?;";
//
//        String roleQuery = "select EMAIL, ROLE_NAME\n" +
//                "from USER_TABLE ut,\n" +
//                "     ROLES r\n" +
//                "where ut.EMAIL = ?\n" +
//                "  and ut.ROLE_ID = r.ID;";
//
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(userQuery)
//                .authoritiesByUsernameQuery(roleQuery);
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(AbstractHttpConfigurer::disable)
//                .logout(AbstractHttpConfigurer::disable)
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers(HttpMethod.POST, "/images").hasAuthority("ADMIN")
//                        .requestMatchers("/movies/**").fullyAuthenticated()
//                        .anyRequest().permitAll()
//                );
//        return http.build();
//    }
//
}
