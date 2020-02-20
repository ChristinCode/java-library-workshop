package org.wecancodeit.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.library.models.Campus;
import org.wecancodeit.library.storage.CampusStorage;

@Controller
public class CampusController {

    private final CampusStorage campusStorage;

    public CampusController(CampusStorage campusStorage) {
        this.campusStorage = campusStorage;
    }


    @RequestMapping("/campuses")
    public String displayCampuses(Model model) {
        model.addAttribute("campuses", campusStorage.findAllCampuses());
        return "campusesView";
    }

    @RequestMapping("/campuses/{campusLocation}")
    public String displaySingleCampus(@PathVariable String campusLocation, Model model) {
        Campus retrievedCampus = campusStorage.findCampusByLocation(campusLocation);
        model.addAttribute("campus", retrievedCampus);

        return "campusView";
    }
}
