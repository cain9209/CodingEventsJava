package org.launchcode.codingevents.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

import java.util.Objects;

public class Event {

    private int ID;

    private static int nextId = 1;

    @NotBlank(message = "Name is required!")
    @Size(min = 3,max = 50,message = "Name must be between 3 and 50 Characters!")
    private String name;

    @Size(max = 500, message = "Description to Long! Must be under 500 Characters!")
    private String description;

    @NotBlank(message = "Field is required!")
    @Email(message = "Invalid email. Try again")
    private String contactEmail;

    private EventType type;


    public Event(String name, String description, String contactEmail, EventType type) {
        this();
        this.name = name;
        this.description = description;
        this.type = type;
        this.contactEmail = contactEmail;

    }
    public Event() {
        this.ID = nextId;
        nextId++;
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public @Email(message = "Invalid email. Try again") String getContactEmail() {
        return contactEmail;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public void setContactEmail(@Email(message = "Invalid email. Try again") String contactEmail) {
        this.contactEmail = contactEmail;

    }


    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
//need to understand this more //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return ID == event.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ID);
    }
}
