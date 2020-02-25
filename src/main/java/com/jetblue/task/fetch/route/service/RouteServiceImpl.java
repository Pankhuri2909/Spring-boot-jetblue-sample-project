package com.jetblue.task.fetch.route.service;

import com.jetblue.task.fetch.route.dao.RouteDao;
import com.jetblue.task.fetch.route.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteDao routeDao;

    @Transactional
    @Override
    public List<Route> get() {
        return routeDao.getAllRoutes();
    }
}
