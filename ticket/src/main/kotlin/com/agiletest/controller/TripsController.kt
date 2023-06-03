package com.agiletest.controller

import com.agiletest.Result.Result
import com.agiletest.pojo.Trips
import com.agiletest.service.TripsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
class TripsController {
    @Autowired
    private lateinit var tripsService: TripsService

    /**
     * get aim trips
     * @return
     */
    @PostMapping("/getAimtrips")
    @ResponseBody
    fun getAimtrips(@RequestBody trips: Trips): Result {
        val result = tripsService.getAimtrips(trips)
        return result
    }

    /**
     * get all trips
     * @return
     */
    @PostMapping("/getalltrips")
    @ResponseBody
    fun getAlltrips(@RequestBody trips: Trips): Result {
        val result = tripsService.getAlltrips(trips)
        return result
    }
}