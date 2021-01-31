import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description('''
                given:
                    The city of Barcelona
                when:
                    Get the topographic details
                then:
                    The city (Barcelona) and the landscape (Flat) should be returned
                ''')
    request {
        url "/api/topographicdetails/Barcelona"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                [
                        id       : "Barcelona",
                        landscape: "Flat"
                ]
        )
    }
}