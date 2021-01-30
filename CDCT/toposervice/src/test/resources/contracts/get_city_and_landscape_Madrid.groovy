package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description('''
                given:
                    The city of Madrid
                when:
                    Get the topographic details
                then:
                    The city (Madrid) and the landscape (Flat) should be returned
                ''')

    request {
        url "/api/topographicdetails/Madrid"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                [
                        id       : "Madrid",
                        landscape: "Flat"
                ]
        )
    }
}