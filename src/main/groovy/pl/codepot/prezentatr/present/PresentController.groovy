package pl.codepot.prezentatr.present

import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

@Slf4j
@RestController
@RequestMapping('/present')
@TypeChecked
@Api(value = "present", description = "API for GUI")
class PresentController {

    @RequestMapping(
            value = "/order",
            method = POST,
            produces = "application/json")
    @ApiOperation(value = "sends an order to agregatr")
    public  Map<String, List<Ingredient>> order(HttpEntity<String> body) {
        List<Ingredient> ingredients = [new Ingredient("MALT", 200),
                new Ingredient("WATER", 200),
                new Ingredient("HOP", 200),
                new Ingredient("YIEST", 200)]
        Map<String, List<Ingredient>> map = new HashMap<>()
        map.put("ingredients", ingredients)
        map
    }

    @RequestMapping(value = "/dojrzewatr", method = GET)
    public String dojrzewatr() {
        log.trace "dojrzewatr() invoke"
        log.info "dojrzewatr 0"
        "0"
    }

    @RequestMapping(value = "/butelkatr", method = GET)
    public String butelkatr() {
        "0"
    }

    @RequestMapping(value = "/bottles", method = GET)
    public String bottles() {
        "0"
    }
}
