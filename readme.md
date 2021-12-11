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
- create region --name=r1 --type=REPLICATE
- put --region=r1 --key="1" --value="one"
- describe region --name=r1
- query --query="select * from /r1"
- remove --region=/Test --all=true 

> #### Query on GemFire
- Gives the list of all entries 
 query --query="SELECT * FROM /jsonRegion"
- To filter out 
 ``` query --query="SELECT * FROM /jsonRegion WHERE id> 5" ```
- List all the Keys in a given Region ```
 ``` query --query="select * from /jsonRegion.keySet()" ``` 
> Deploy a jar to gemfire (processing directly on data)
- ```deploy --jar=/tmp/deploy/apache-geode.jar```
- To list the deployed artefacts ```list deployed``` 


  
**NOTE** - use the below configuration commands before starting the cache server, for the serialization effect to take place
- configure pdx --read-serialized=true (for PDX serializations)
- configure pdx --disk-store=DEFAULT
- show metric ( will show the cluster-wide metrics)

Pulse login (credentials - admin, admin)  
http://localhost:7070/pulse/clusterDetail.html



