package org.exercise.pizza.initdb;

import org.exercise.pizza.model.Cheese;
import org.exercise.pizza.model.Crust;
import org.exercise.pizza.model.Sauce;
import org.exercise.pizza.service.CheeseService;
import org.exercise.pizza.service.CrustService;
import org.exercise.pizza.service.SauceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class InitDB implements ApplicationListener<ApplicationReadyEvent> {

    private final Logger log = LoggerFactory.getLogger(InitDB.class);

    @Autowired
    private CheeseService cheeseService;

    @Autowired
    private SauceService sauceService;

    @Autowired
    private CrustService crustService;

    public void populateCheese() {
        cheeseService.save(new Cheese("mozzarella"));
        cheeseService.save(new Cheese("parmesan"));
        cheeseService.save(new Cheese("cheddar"));
        log.info("Cheeses populated.");
    }

    public void populateSauces() {
        sauceService.save(new Sauce("bolognese"));
        sauceService.save(new Sauce("ragu"));
        sauceService.save(new Sauce("bechamel"));
        log.info("Sauces populated");
    }

    public void populateCrusts() {
        crustService.save(new Crust("thin"));
        crustService.save(new Crust("thick"));
        crustService.save(new Crust("filled with cheese"));
        log.info("Crusts populated");
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        populateCheese();
        populateSauces();
        populateCrusts();
    }
}
