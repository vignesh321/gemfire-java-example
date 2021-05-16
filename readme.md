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


### Gemfire with gfsh CLI 

- start locator --hostname-for-clients=localhost
- start server --hostname-for-clients=localhost
- list members 
- create region --name=r1 --type=REPLICATE
- put --region=r1 --key="1" --value="one"
- describe region --name=r1
- query --query="select * from /r1"
- remove --region=/Test --all=true  
  
**NOTE** - use the below configuration commands before starting the cache server, for the serialization effect to take place
- configure pdx --read-serialized=true (for PDX serializations)
- configure pdx --disk-store=DEFAULT
- show metric ( will show the cluster-wide metrics)

Pulse login (credentials - admin, admin)  
http://localhost:7070/pulse/clusterDetail.html



