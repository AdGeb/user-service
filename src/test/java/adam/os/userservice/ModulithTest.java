package adam.os.userservice;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

class ModulithTest {
    @Test
    void createApplicationModuleModel() {
        ApplicationModules modules = ApplicationModules.of(UserServiceApplication.class);
        modules.verify();
    }
}
