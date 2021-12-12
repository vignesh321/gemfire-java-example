# Gemfire Example - Docker & Java Client

### Running Docker image

Only initiates the docker image with gfsh terminal started (but doesn't get the container to be exposed to external usage)
``` 
docker run -it apachegeode/geode
```

Expose the container running to localhost - to be consumed by Clients

```
docker run -it -p 10334:10334 -p 1099:1099 -p 7070:7070 -p 8080:8080 -p 40404:40404 apachegeode/geode
```


> ### Gemfire with gfsh CLI 

- Starting a locator: ```start locator --hostname-for-clients=localhost```
- Starting a member server: ```start server --hostname-for-clients=localhost```
- Listing Members: ```list members``` 
- Display member server log ``` show log --member=<member_id> ```
- Create Regions ```create region --name=r1 --type=REPLICATE```
- Insert a Key-Value into Region ```put --region=r1 --key="1" --value="one"```
- Describe a Region ```describe region --name=r1```
- Query data from a region ```query --query="select * from /r1"```
- Remove all Keys from a Region ```remove --region=/Test --all=true ```

> #### Query on GemFire
- Gives the list of all entries 
 ```query --query="SELECT * FROM /jsonRegion"```
- Filter Queries 
 ``` query --query="SELECT * FROM /jsonRegion WHERE id> 5" ```
- List all the Keys in a given Region  ``` query --query="select * from /jsonRegion.keySet()" ``` 

>> Adding JSON Documents- Refer this [file](./src/main/java/main/GemfireJSON.java)

> #### Deploy a jar to gemfire (processing directly on data)  
  
- This feaure is used to process data directly on the GemFire Server - rather than bringing it to the application layer and doing the processing and returning the data back (avoiding network calls and reducing latency)
- ```deploy --jar=/tmp/deploy/apache-geode.jar```
- To list the deployed artefacts ```list deployed``` 


  
**NOTE** - use the below configuration commands before starting the cache server, for the serialization effect to take place
- configure pdx --read-serialized=true (for PDX serializations)
- configure pdx --disk-store=DEFAULT
- show metric ( will show the cluster-wide metrics)

## Pulse login  
http://localhost:7070/pulse/clusterDetail.html  
Credentials - (admin, admin)



