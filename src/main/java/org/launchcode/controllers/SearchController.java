package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }
 /*   @RequestMapping(value = "results")
    public String listColumnValue(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {

        if (searchType.equals("all")) {
            ArrayList<HashMap<String, String>> jobs = JobData.findAll();
            model.addAttribute("title", "All Jobs");
            model.addAttribute("jobs", jobs);
            return "list-jobs";
        } else {
            ArrayList<HashMap<String,String>> items = JobData.findByColumnAndValue(searchType, searchTerm);
            model.addAttribute("title", items.size() + " Results");
            model.addAttribute("column", searchType);
            model.addAttribute("items", items);
            return "list-column";
        }
    }*/
    @RequestMapping(value = "results")
    public String listJobsByColumnAndValue(Model model,
                                                          @RequestParam String searchType, @RequestParam String searchTerm) {
        ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        model.addAttribute("title", jobs.size()+" Results Found");
        model.addAttribute("position type", jobs.);

        return "search";
    }

    // TODO #1 - Create handler to process search request and display results

}
