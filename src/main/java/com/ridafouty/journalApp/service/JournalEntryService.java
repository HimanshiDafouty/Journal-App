package com.ridafouty.journalApp.service;

import com.ridafouty.journalApp.entity.JournalEntry;
import com.ridafouty.journalApp.respository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class JournalEntryService {

    @Autowired // DI
    private JournalEntryRepository journalEntryRepository; // the implementation of this interface will be injected by spring in runtime


    //save entry
    public void saveEntry(JournalEntry journalEntry) {

        journalEntryRepository.save(journalEntry);
    }


    //get list iof journal entries
    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }


    //get entry by id
    public Optional<JournalEntry> getJournalEntryById(ObjectId id) {
        return journalEntryRepository.findById(id);

    }

    //delete entry by id
    public void deleteEntryById(ObjectId id) {
        journalEntryRepository.deleteById(id);
    }

}
