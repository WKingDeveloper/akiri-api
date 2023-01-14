package com.wkd.akiriapi.graphql.configuration

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsRuntimeWiring
import graphql.scalars.ExtendedScalars
import graphql.scalars.java.JavaPrimitives.GraphQLLong
import graphql.scalars.java.JavaPrimitives.GraphQLShort
import graphql.schema.idl.RuntimeWiring
import org.springframework.context.annotation.Configuration

@Configuration
class GraphqlConfiguration {
    @DgsComponent
    class RuntimeWiringRegistration {
        @DgsRuntimeWiring
        fun addScalar(builder: RuntimeWiring.Builder): RuntimeWiring.Builder? {
            return builder.scalar(GraphQLLong).scalar(GraphQLShort).scalar(ExtendedScalars.Json)
        }
    }
}
