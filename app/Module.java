import com.google.inject.AbstractModule;

import impl.JPAClientRepository;
import repositories.ClientRepository;

public class Module extends AbstractModule {

    @Override
    public void configure() {        
        bind(ClientRepository.class).to(JPAClientRepository.class).asEagerSingleton();
    }
}


