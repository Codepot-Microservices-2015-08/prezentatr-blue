package pl.codepot.prezentatr.base

import com.ofg.infrastructure.base.IntegrationSpec
import pl.codepot.prezentatr.Application
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [Application], loader = SpringApplicationContextLoader)
class MicroserviceIntegrationSpec extends IntegrationSpec {
}
