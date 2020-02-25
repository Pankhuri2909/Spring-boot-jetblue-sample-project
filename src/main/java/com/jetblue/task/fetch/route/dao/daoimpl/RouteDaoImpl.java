package com.jetblue.task.fetch.route.dao.daoimpl;

import com.jetblue.task.fetch.route.dao.RouteDao;
import com.jetblue.task.fetch.route.model.Route;
import com.jetblue.task.fetch.route.utils.RouteCSVReader;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RouteDaoImpl implements RouteDao {

    @Override
    public List<Route> getAllRoutes() {
        List<Route> listOfRoutes = RouteCSVReader.getCSVRouteData();
        return listOfRoutes;
    }

}
