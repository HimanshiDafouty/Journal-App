package com.ridafouty.journalApp.controller;

import com.ridafouty.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

@RestController
@RequestMapping("/journal") // It will be added before , for all the endpoints
public class JournalEntryController {

    private Map<Long , JournalEntry> jornalEntries = new HashMap<>();

    @GetMapping
    //Method inside a controller class should be PUBLIC so that they can be accessed and invoked by the spring frameowrk or external http request
    public  List<JournalEntry> getAll(){ //localhost:8080/journal GET
        return new ArrayList<>(jornalEntries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){   //localhost:8080/journal POST
        // @RequestBody : It is like saying " Hey spring , please  the data from the request and turn it into java object that I can use in my code
        jornalEntries.put(myEntry.getId() , myEntry);
        return true;

    }
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        return jornalEntries.get(myId);

    }


    @DeleteMapping("/delete/{myId}")
    public boolean deleteJournalEntry(@PathVariable Long myId){
        jornalEntries.remove(myId);
        return true;
     }

     @PutMapping("/update/{myId}")
     public JournalEntry updateJournalEntry( @PathVariable Long myId , @RequestBody JournalEntry myEntry){
        jornalEntries.put(myId , myEntry);
        return jornalEntries.get(myId);
     }

}
