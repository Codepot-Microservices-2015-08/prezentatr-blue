io.codearte.accurest.dsl.GroovyDsl.make {
    request {
        method 'GET'
        url $(client(regex('^/present/butelkatr$')), server('/present/butelkatr'))
    }
    response {
        status 200
        body (
                $(client(regex('[0-9]+')), server('0'))
        )
    }
}