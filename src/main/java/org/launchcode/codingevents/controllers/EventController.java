package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
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

    // displays form at//
    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("events", EventData.getAll());
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
        EventData.add(new Event(eventName, eventDescription));
        return "redirect:/events";
    }

    @GetMapping("/delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "/events/delete";
    }

    @PostMapping("/delete")
    public String processDeleteEventForm(@RequestParam int[] eventIds) {
        for (int id : eventIds) {
            EventData.remove(id);
        }
        return "redirect:/events";
    }
}
