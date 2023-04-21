# Safety Routing for Wales

## GraphHopper Routing Engine

GraphHopper is a fast and memory efficient Java routing engine. It can import OpenStreetMap data and calculate routes.
By default it uses OpenStreetMap data and calculates the fastest route. 
It can also be used to calculate the shortest route or the route with the least elevation changes. Used to calculate routes for bicycles, cars, trucks, scooters, pedestrians, boats and even airplanes.

See [this website](https://github.com/graphhopper/graphhopper) more information

## Fresh Docker Image

```
apt-get update
apt-get -y install sudo
sudo apt-get install git-all
sudo apt-get install maven
sudo apt-get install openjdk-11-jdk
```

# Installation

```
git clone https://github.com/eernestas13/RoadRouting
./graphhopper.sh -a import -i wales-latest.osm.pbf -o walesMapIncident-gh
./graphhopper.sh clean
./graphhopper.sh -a import -i wales-latest.osm.pbf -o walesMapIncident-gh
./graphhopper.sh build
java -Xms1g -Xmx1g -Dgraphhopper.datareader.file=wales-latest.osm.pbf -Dgraphhopper.graphhopper.crash.location=data/crashDataRetry.json -Dgraphhopper.graphhopper.graph.location=walesMapIncident-gh -jar web/target/graphhopper-web-0.12-SNAPSHOT.jar server config-example.yml

```


Get fresh map data from OpenStreetMap, e.g. download [the PBF file here](http://download.geofabrik.de/europe.html).
