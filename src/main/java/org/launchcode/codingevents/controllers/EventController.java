package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("/events")
public class EventController {
    // create a collection to store the data which is linked to the Model//
    private static List<Event> events = new ArrayList<>();
// displays form at//
    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("events", events);
        return "/events/index";
    }
// displays create event form //
    @GetMapping("/create")
    public String displayCreateEventForm() {
        return "events/create";
    }

    @PostMapping("/create")
    public String createEvent(@RequestParam String eventName,
                              @RequestParam String eventDescription) {
        events.add(new Event(eventName, eventDescription));
        return "redirect:/events";
    }

}
