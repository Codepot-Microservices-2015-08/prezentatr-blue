package pl.codepot.prezentatr.feed

import com.ofg.infrastructure.correlationid.CorrelationIdHolder
import com.wordnik.swagger.annotations.Api
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pl.codepot.prezentatr.state.State

import static org.springframework.web.bind.annotation.RequestMethod.PUT

/**
 * @author dawid
 * @since 28.08.15.
 */
@Slf4j
@RestController
@RequestMapping(value = 'feed', consumes = "application/vnd.pl.codepot.prezentatr.v1+json", produces = MediaType
        .APPLICATION_JSON_VALUE)
@TypeChecked
@Api(value = "feed", description = "api for feeds")
class FeedController {

    final State state

    @Autowired
    FeedController(State state) {
        this.state = state
    }

    @RequestMapping(value = "/dojrzewatr", method = PUT)
    public void dojrzewatr() {
        String cId = CorrelationIdHolder.get()
        state.brewing.add(cId)
        log.info "dojrzewatr; state $state"
    }

    @RequestMapping(value = "/butelkatr", method = PUT)
    public void butelkatr() {
        String cId = CorrelationIdHolder.get()
        state.brewing.remove(cId)
        state.bottling.add(cId)
        log.info "butelkatr; state $state"
    }

    @RequestMapping(value = "/bottles/{quantity}", method = PUT)
    public void bottles(@PathVariable Integer quantity) {
        String cId = CorrelationIdHolder.get()
        state.bottling.remove(cId)
        state.bottles += quantity
        log.info "bottles; state $state"
    }

}
