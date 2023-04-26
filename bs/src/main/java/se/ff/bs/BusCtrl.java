package se.ff.bs;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class BusCtrl {



    @RequestMapping("/bus/{station}/{nr}")
    public BusInfo bus(@PathVariable String station, @PathVariable String nr) {
        Integer eta = getEtaBasedOnGpsAndOtherAdcancedStuff();
        BusInfo b = new BusInfo(station, nr, eta);
        return b;
    }

    private Integer getEtaBasedOnGpsAndOtherAdcancedStuff() {
        Random rn = new Random();
        int min = 1;
        int max = 7;
        int eta = rn.nextInt(max - min + 1) + min;
        //return ""+eta;
        return rn.nextInt(max - min + 1) + min;
    }


}