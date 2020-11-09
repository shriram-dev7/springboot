package com.example.webfluxDemo.router

import com.example.webfluxDemo.handler.AzureHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RequestPredicates.accept
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class AzureRouter {

    @Bean
    fun azureRoute(azureHandler: AzureHandler): RouterFunction<ServerResponse?>? {
        return RouterFunctions
                .route(GET("/functional/test1"),azureHandler::getTest1)
                .andRoute(GET("/functional/test2").and(accept(MediaType.ALL)),azureHandler::getTest2)
               // .route(GET("/functional/azure").and(accept(MediaType.APPLICATION_JSON)), azureHandler::getTest1)
               // .route(GET("/functional/azure"), azureHandler::getTest1)
             //   .andRoute(GET(ITEM_FUNCTIONAL_END_POINT_V1.toString() + "/{id}").and(accept(APPLICATION_JSON)), itemsHandler::getOneItem)
             //   .andRoute(GET("/functional/mono").and(accept(MediaType.APPLICATION_JSON)),azureHandler::mono)
//                .and(route(GET("/employees/{id}"),
//                        req -> ok().body(
//        employeeRepository().findEmployeeById(req.pathVariable("id")), Employee.class)))
                  }
}