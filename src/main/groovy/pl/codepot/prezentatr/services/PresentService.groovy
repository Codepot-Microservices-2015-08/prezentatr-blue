package pl.codepot.prezentatr.services

import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import pl.codepot.prezentatr.state.State

import static org.springframework.web.bind.annotation.RequestMethod.GET

/**
 * @author dawid
 * @since 28.08.15.
 */
@Slf4j
@Component
class PresentService {


    private State state;

    @Autowired
    PresentService(State state) {
        this.state = state
    }

    @Autowired
    private ServiceRestClient serviceRestClient;

    public String order(HttpEntity<String> body) {
        return serviceRestClient.forService("aggregatr")
                .post()
                .onUrl("ingredients").httpEntity(body)
                .andExecuteFor()
                .anObject()
                .ofType(String.class)
//                .anObject()
//                .ofType(Ingredients.class).ingredients
//        map
    }

    @RequestMapping(value = "/dojrzewatr", method = GET)
    public String dojrzewatr() {
        def size = state.brewing.size()
        log.info "dojrzewatr() invoke"
        log.info "dojrzewatr " + size
        size
    }

    @RequestMapping(value = "/butelkatr", method = GET)
    public String butelkatr() {
        def size = state.bottling.size()
        log.info "butelkatr() invoke"
        log.info "butelkatr " + size
        size
    }

    @RequestMapping(value = "/bottles", method = GET)
    public String bottles() {
        def size = state.bottles
        log.info "bottles() invoke"
        log.info "bottles " + size
        size
    }
}
