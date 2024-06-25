package org.launchcode.codingevents.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

import java.util.Objects;

public class Event {

    private int ID;

    private static int nextId = 1;

    @NotBlank
    @Size(min = 3,max = 20)
    private String name;

    @Size(max = 500)
    private String description;

    @Email(message = "Invalid email. Try again")
    private String contactEmail;

    public Event(String name, String description, String contactEmail) {
        this.name = name;
        this.description = description;
        this.ID = nextId++;
        this.contactEmail = contactEmail;
    }

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
