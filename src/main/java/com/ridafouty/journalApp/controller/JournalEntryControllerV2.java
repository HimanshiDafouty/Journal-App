package com.ridafouty.journalApp.controller;

import com.ridafouty.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {


    @GetMapping
    public  List<JournalEntry> getAll(){
        return  null;
    }


    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        return true;

    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        return  null;


    }


    @DeleteMapping("/delete/{myId}")
    public boolean deleteJournalEntry(@PathVariable Long myId){
        return true;

     }

     @PutMapping("/update/{myId}")
     public JournalEntry updateJournalEntry( @PathVariable Long myId , @RequestBody JournalEntry myEntry){
        return  null;
        
     }

}
