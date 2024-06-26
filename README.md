**#ABOUT PROJECT**

In this particular project , trying to read hotels json data in java using pojo and jackson as pojo client , index the data in solr search engine , search data from solr search engine and also adding additional solr component called faceting to enhance the search capability
For reference hotels data is created using the python **FAKER Library**

Below is the code for generating the data 

**import json
from faker import Faker
import random

# Initialize Faker
faker = Faker()

# Number of records you want to generate
num_records = 500

# List of possible facilities and room facilities
facilities_list = ["Bar", "Board Room", "Gym", "Spa", "Swimming Pool"]
room_facilities_list = ["Dining Table", "Free Internet", "Air Conditioning", "Free WiFi", "Television"]

# List to hold generated hotel records
hotel_data = []

# Generate random hotel data
for _ in range(num_records):
    record = {
        "city": faker.city(),
        "state": faker.state(),
        "country": faker.country(),
        "uid": faker.uuid4(),
        "facilities": random.sample(facilities_list, k=random.randint(1, len(facilities_list))),
        "roomfacilities": random.sample(room_facilities_list, k=random.randint(1, len(room_facilities_list))),
        "reviewcount": random.randint(0, 5000),
        "reviewscore": round(random.uniform(1, 5), 1),
        "hotelname": faker.company(),
        "hoteltype": random.choice(["Standard", "Deluxe"])
    }
    hotel_data.append(record)

# Save generated data to a JSON file
with open('hotels.json', 'w') as json_file:
    json.dump(hotel_data, json_file, indent=4)

print(f"{num_records} records generated and saved to 'hotels.json'.")
**
# Pre-Requisites
Java Version : 17

SolrJ Version : 8.11.0 (maven dependency)

Editor : IntelliJ Idea

Commands To Start and Stop the Solr Server :

To start the solr server : solr start

To stop the solr server : solr stop -p port:no

Command to create solr core : solr create -c core_name
