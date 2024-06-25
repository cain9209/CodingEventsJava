package org.launchcode.codingevents.controllers;

import jakarta.validation.Valid;
import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("/events")
public class EventController {

    // displays form at//
    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("events", EventData.getAll());
        return "/events/index";
    }

    // displays create event form //
    @GetMapping("/create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title","Create Event");
        model.addAttribute(new Event());
        return "events/create";
    }

    @PostMapping("/create")
    public String createEvent(@ModelAttribute @Valid Event newEvent,
                              BindingResult errors, Model model) {
        if (errors.hasErrors()){
            model.addAttribute("title", "Crete Event");
            return("events/create");
        }
        EventData.add(newEvent);
        return "redirect:/events";
    }

    @GetMapping("/delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "/events/delete";
    }

    @PostMapping("/delete")
    public String processDeleteEventForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:/events";
    }
}
