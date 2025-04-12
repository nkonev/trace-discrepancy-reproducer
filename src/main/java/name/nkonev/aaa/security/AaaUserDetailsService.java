package name.nkonev.aaa.security;

import name.nkonev.aaa.dto.UserAccountDetailsDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Provides Spring Security compatible UserAccountDetailsDTO.
 */
@Service
public class AaaUserDetailsService implements UserDetailsService {


    /**
     * load UserAccountDetailsDTO from database, or throws UsernameNotFoundException
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserAccountDetailsDTO loadUserByUsername(String username) throws UsernameNotFoundException {
        throw new RuntimeException("BOOM!");
    }

}
