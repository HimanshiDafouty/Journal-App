package com.ridafouty.journalApp.controller;

import com.ridafouty.journalApp.entity.JournalEntry;
import com.ridafouty.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
    @Autowired
    private JournalEntryService journalEntryService;


    @GetMapping
    public  List<JournalEntry> getAll(){
        return  journalEntryService.getAll();
    }


    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;

    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId){
        return  journalEntryService.getJournalEntryById(myId).orElse(null);


    }


    @DeleteMapping("/delete/{myId}")
    public boolean deleteJournalEntry(@PathVariable ObjectId myId){
        journalEntryService.deleteEntryById(myId);
        return true;

     }

     @PutMapping("/update/{myId}")
     public JournalEntry updateJournalEntry( @PathVariable ObjectId myId , @RequestBody JournalEntry newEntry){
        JournalEntry prevJournalEntry = journalEntryService.getJournalEntryById(myId).orElse(null);
        if(prevJournalEntry!=null){
            prevJournalEntry.setDate(LocalDateTime.now());
            prevJournalEntry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : prevJournalEntry.getTitle());
            prevJournalEntry.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : prevJournalEntry.getContent());

            journalEntryService.saveEntry(prevJournalEntry);
            return prevJournalEntry;
        }
        return  null;
        
     }

}
