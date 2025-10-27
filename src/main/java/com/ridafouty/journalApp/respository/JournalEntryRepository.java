package com.ridafouty.journalApp.respository;
import com.ridafouty.journalApp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface JournalEntryRepository extends MongoRepository<JournalEntry,String> {
}
