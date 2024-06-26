package org.example.Hotel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class HotelsIndexer {
    /**
     * reads the dataset for indexing it into the solr
     * @return
     * @throws IOException
     */
    public static ArrayList<Hotel> readHotels() throws IOException {
        String hotelsData = new String(Files.readAllBytes(Paths.get("hotels.json")));
//        System.out.println(String.valueOf(hotelsData));
        ObjectMapper objectmap = new ObjectMapper();
        ArrayList<Hotel> hotels = objectmap.readValue(hotelsData, new TypeReference<ArrayList<Hotel>>() {});
        return hotels;
    }
    public static void main(String[] args) throws IOException, SolrServerException {
        ArrayList<Hotel> results = readHotels();
//        System.out.println(results.get(0));
        SolrClient solrClient = new HttpSolrClient.Builder("http://localhost:8983/solr/hotels").build();
        solrClient.addBeans(results);
        solrClient.commit();
        System.out.println("Indexing Hotels Data Is Successfully Completed!!!");
    }
}

