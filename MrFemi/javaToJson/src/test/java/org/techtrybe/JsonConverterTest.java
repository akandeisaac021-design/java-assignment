package org.techtrybe;

import org.junit.jupiter.api.Test;
import org.techtrybe.data.Transaction;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonConverterTest {


    @Test
    void testCanSerializeTransactionToJson() {
        LocalDateTime testTime = LocalDateTime.of(2026, 6, 15, 12, 0, 0);

        String expected = "{\"id\":\"1\",\"sender\":\"Ene\",\"recipient\":\"Victor\",\"amount\":\"10\",\"time\":\"2026-06-15T12:00:00\"}";

        Transaction transaction = new Transaction();
        transaction.setId("1");
        transaction.setAmount(BigDecimal.TEN.toString());
        transaction.setSender("Ene");
        transaction.setRecipient("Victor");
        transaction.setTime(testTime);

        String json = JsonConverter.serialize(transaction);

        assertNotNull(json);
        assertEquals(expected, json);
        assertTrue(json.contains("{") && json.contains("id") && json.contains("1") && json.contains("}"));
    }


    @Test
    void testCanDeSerializeJsonToTransaction(){
        String json = "{\"id\":\"1\",\"sender\":\"Ene\",\"recipient\":\"Victor\",\"amount\":\"10\"}";
        Transaction transaction = JsonConverter.deserialize(json);
        assertNotNull(transaction);
        assertEquals("10", transaction.getAmount());
        assertEquals("Ene", transaction.getSender());
    }


    @Test
    void testCanDeserializeJsonFile(){
        String jsonFilePath = "/Users/dee/Desktop/json";
        Path path = Paths.get(jsonFilePath, "transactions.json");
        List<Transaction> transactions = JsonConverter.deserialize(path);
        assertNotNull(transactions);
        assertEquals(3, transactions.size());
    }

}