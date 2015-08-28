package pl.codepot.prezentatr.feed

import com.wordnik.swagger.annotations.Api
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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


    @RequestMapping(value = "/dojrzewatr", method = PUT)
    public void dojrzewatr() {
    }

    @RequestMapping(value = "/butelkatr", method = PUT)
    public void butelkatr() {
    }

    @RequestMapping(value = "/bottles/{quantity}", method = PUT)
    public void bottles(@PathVariable Integer quantity) {
    }

}
