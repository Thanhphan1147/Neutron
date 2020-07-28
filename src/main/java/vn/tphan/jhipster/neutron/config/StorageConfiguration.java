package vn.tphan.jhipster.neutron.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.tphan.jhipster.neutron.models.Board;
import vn.tphan.jhipster.neutron.models.utils.RandomStringGenerator;

import java.util.HashMap;
import java.util.Map;

// Create a storage unit-type bean. Not sure if this is the way to go
@Configuration
public class StorageConfiguration {
    @Bean
    public HashMap<String, Board> hashMap(){
        return new HashMap<>();
    }

    @Bean
    public RandomStringGenerator randomStringGenerator() {
        return new RandomStringGenerator();
    }
}
