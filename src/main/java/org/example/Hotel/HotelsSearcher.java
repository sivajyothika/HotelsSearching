package org.example.Hotel;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.apache.solr.common.params.SolrParams;

import java.io.IOException;
import java.util.Scanner;

public class HotelsSearcher {
    private static String SOLR_URL = "http://localhost:8983/solr/hotels";
    private static SolrClient solrClient = new HttpSolrClient.Builder(SOLR_URL).build();
    public static SolrDocumentList searchByCity(String city) throws SolrServerException, IOException {
        SolrParams params = new ModifiableSolrParams().set("q","city:"+city);
        QueryResponse response = solrClient.query(params);
        return response.getResults();
    }
    public static SolrDocumentList searchByCountry(String country) throws SolrServerException, IOException {
        SolrParams params = new ModifiableSolrParams().set("q","country:"+country);
        QueryResponse response = solrClient.query(params);
        return response.getResults();
    }
    public static SolrDocumentList searchByHotelName(String hotelname) throws SolrServerException, IOException {
        SolrParams params = new ModifiableSolrParams().set("q","hotelname:"+hotelname);
        QueryResponse response = solrClient.query(params);
        return response.getResults();
    }
    public static SolrDocumentList searchByHotelType(String hoteltype) throws SolrServerException, IOException {
        SolrParams params = new ModifiableSolrParams().set("q","hoteltype:"+hoteltype);
        QueryResponse response = solrClient.query(params);
        return response.getResults();
    }
    public static SolrDocumentList facetByRoomFacility(String facility) throws SolrServerException, IOException {
        SolrParams params = new ModifiableSolrParams()
                .set("q","*:*")
                .set("facet",true)
                .set("facet.field","roomfacilities")
                .set("fq","roomfacilities"+facility);
        QueryResponse response = solrClient.query(params);
        return response.getResults();
    }
    public static SolrDocumentList facetByRoomType(String roomType) throws SolrServerException, IOException {
        SolrParams params = new ModifiableSolrParams()
                .set("q","*:*")
                .set("facet",true)
                .set("facet.field","hoteltype")
                .set("fq","hoteltype"+roomType);
        QueryResponse response = solrClient.query(params);
        return response.getResults();
    }
    public static SolrDocumentList paginateByCity(String city,int start,int rows) throws SolrServerException, IOException {
        SolrParams params = new ModifiableSolrParams()
                .set("q","city:"+city)
                .set("start",start)
                .set("rows",rows);
        QueryResponse response = solrClient.query(params);
        return response.getResults();
    }
    public static void main(String[] args) throws SolrServerException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO THE WORLD OF HOTEL SERVICES!!!!!");
        System.out.println("Please tell us what do you want to search by 1.city\n 2.country\n 3.hotel name\n 4.hotel type\n and you can also facet by 1.Room Facility\n 2.Room Type\n and paginate by City");
        String choice = sc.next();
        if(choice.equals("city")){
            System.out.println("Please enter city name");
            String cityname = sc.next();
            System.out.println(searchByCity(cityname));
        }
        else if(choice.equals("country")){
            System.out.println("Please enter country name");
            String countryName = sc.next();
            System.out.println(searchByCountry(countryName));
        }
        else if(choice.equals("hotelname")){
            System.out.println("Please enter hotel name");
            String hotelName = sc.next();
            System.out.println(searchByHotelName(hotelName));
        }
        else if(choice.equals("hoteltype")){
            System.out.println("Please enter hotel type");
            String hotelType = sc.next();
            System.out.println(searchByHotelType(hotelType));
        }
        else if(choice.equals("roomfacility")){
            System.out.println("Please enter type of facility needed");
            String facility = sc.next();
            System.out.println(facetByRoomFacility(facility));
        }
        else if(choice.equals("roomtype")){
            System.out.println("Please enter type of room needed");
            String room = sc.next();
            System.out.println(facetByRoomType(room));
        }
        else{
            System.out.println("Please enter paginate city");
            String pcity = sc.next();
            System.out.println(paginateByCity(pcity,0,10));
        }
        System.out.println("HAPPY SEARCHING !!!!");
    }
}
