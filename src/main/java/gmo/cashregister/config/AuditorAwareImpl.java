package gmo.cashregister.config;

import gmo.cashregister.entity.test.Test;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<Test> {
    @Override
    public Optional<Test> getCurrentAuditor() {
        return Optional.of(new Test());
    }
}
