package com.jetblue.task.fetch.route.controller;

import com.jetblue.task.fetch.route.model.Route;
import com.jetblue.task.fetch.route.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/jb")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping(value = "/route")
    public List<Route> get() {
        return routeService.get();
    }

    @GetMapping(value = "/route/{name}")
    public List<Route> getSpecificRoute(@PathVariable(value = "name") String city) {
        System.out.println("CITY : " + city);
        List<Route> listOfAllRoutes = routeService.get();
        List<Route> routes = new ArrayList<Route>();
        for (int indexRoutes = 0; indexRoutes < listOfAllRoutes.size(); indexRoutes++) {
            if (city.equals(listOfAllRoutes.get(indexRoutes).getCity1())) {
                routes.add(listOfAllRoutes.get(indexRoutes));
            }
        }
        System.out.println("COUNT OF SPECIFIC CITY :"+routes.size());

        return routes;
    }
}

