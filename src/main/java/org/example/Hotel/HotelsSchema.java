package org.example.Hotel;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.beans.Field;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.schema.SchemaRequest;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HotelsSchema {
    public static void main(String[] args) throws SolrServerException, IOException {
        SolrClient solrClient = new HttpSolrClient.Builder("http://localhost:8983/solr/hotels").build();
        schemaAddField(solrClient,"city","string",true,true,false);
        schemaAddField(solrClient,"state","string",true,true,false);
        schemaAddField(solrClient,"country","string",true,true,false);
        schemaAddField(solrClient,"uid","string",true,true,false);
        schemaAddField(solrClient,"facilities","text_general",true,true,true);
        schemaAddField(solrClient,"roomfacilities","text_general",true,true,true);
        schemaAddField(solrClient,"reviewcount","pint",true,true,false);
        schemaAddField(solrClient,"reviewscore","pfloat",true,true,false);
        schemaAddField(solrClient,"hotelname","string",true,true,false);
        schemaAddField(solrClient,"hoteltype","string",true,true,false);
    }
    public static void schemaAddField(SolrClient solrClient,String fieldName,String filedType,boolean stored,boolean indexed,boolean multivalued) throws SolrServerException, IOException {
        Map<String,Object> schemaFields = new LinkedHashMap<>();
        schemaFields.put("name",fieldName);
        schemaFields.put("type",filedType);
        schemaFields.put("stored",stored);
        schemaFields.put("indexed",indexed);
        schemaFields.put("multiValued",multivalued);
        SchemaRequest.AddField addFileds = new SchemaRequest.AddField(schemaFields);
        addFileds.process(solrClient);
    }
}
