package pl.codepot.prezentatr.present

import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pl.codepot.prezentatr.services.PresentService
import pl.codepot.prezentatr.state.State

import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

@Slf4j
@RestController
@RequestMapping('/present')
@TypeChecked
@Api(value = "present", description = "API for GUI")
class PresentController {

    private PresentService presentService;

    @Autowired
    PresentController(PresentService presentService) {
        this.presentService = presentService
    }

    @RequestMapping(
            value = "/order",
            method = POST,
            produces = "application/json")
    @ApiOperation(value = "sends an order to agregatr")
    public String order(HttpEntity<String> body) {
        presentService.order(body)
    }

    @RequestMapping(value = "/dojrzewatr", method = GET)
    public String dojrzewatr() {
        presentService.dojrzewatr()
    }

    @RequestMapping(value = "/butelkatr", method = GET)
    public String butelkatr() {
        presentService.butelkatr()
    }

    @RequestMapping(value = "/bottles", method = GET)
    public String bottles() {
        presentService.bottles()
    }
}
