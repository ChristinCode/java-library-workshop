package org.wecancodeit.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CampusController {

    private CampusStorage campusStorage;

    public CampusController(CampusStorage campusStorage){
        this.campusStorage = campusStorage;
    }


    @RequestMapping("/campuses")
    public String displayCampuses(Model model){
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
