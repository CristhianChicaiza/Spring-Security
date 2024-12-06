package com.app.config;

import com.app.service.UserDetailsServiceImpl;
import com.sun.jdi.PathSearchingVirtualMachine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class SecurityConfig {


//    @Bean
//            public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//            return httpSecurity
//                    .csrf(AbstractHttpConfigurer::disable)
//                    .httpBasic(Customizer.withDefaults())
//                    .sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(http ->{
//                    // configurar endpoints publicos
//                     http.requestMatchers(HttpMethod.GET, "/auth/get").permitAll();
//                    // configurar endpoints privados  se puede configurar con los permisos o los roles
//                     http.requestMatchers(HttpMethod.POST, "/auth/post").hasAnyAuthority("CREATE","READ");
//                     http.requestMatchers(HttpMethod.PATCH, "/auth/patch").hasRole("ADMIN");
//
//                    // configurar el resto de endpoints
//                     http.anyRequest().denyAll();
//                })
//                .build();


     //autorizacion con anotaciones
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
            return httpSecurity
                    .csrf(AbstractHttpConfigurer::disable)
                    .httpBasic(Customizer.withDefaults())
                    .sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .build();
 }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsServiceImpl userDetailsService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        List<UserDetails> userDetailsList = new ArrayList<>();
//
//        userDetailsList.add(User.withUsername("David")
//                .password("1234")
//                .roles("ADMIN")
//                .authorities("READ", "CREATE")
//                .build());
//
//        userDetailsList.add(User.withUsername("Cristhian")
//                .password("1234")
//                .roles("USER")
//                .authorities("READ")
//                .build());
//
//        return new InMemoryUserDetailsManager(userDetailsList);
//
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // creacion de contraseñas encriptadas
//    public static void main(String[] args) {
//        System.out.println(new BCryptPasswordEncoder().encode("1234"));
//    }
}









