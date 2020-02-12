package org.wecancodeit.library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
public class CampusController {

    private CampusStorage campusStorage;

    public CampusController(CampusStorage campusStorage) {

        this.campusStorage = campusStorage;
    }

    @RequestMapping("/campuses")
    public String displayCampuses(Model model){
        model.addAttribute("campuses", campusStorage.findAllCampuses());
        return "campusesView";
    }
}
