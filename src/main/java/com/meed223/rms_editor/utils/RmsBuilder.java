package com.meed223.rms_editor.utils;

import java.util.ArrayList;

import com.meed223.rms_editor.map.RMS;
import com.meed223.rms_editor.map.elements.*;
import com.meed223.rms_editor.map.elements.Object;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class RmsBuilder {
	/* Object Info */
    public String mapName;

    /* RMS Map Constants */
    private String baseTerrain;

    /* RMS Generation Objects */
    private Player player;
    private ArrayList<Land> landGeneration;
    private ArrayList<Terrain> terrainGeneration;
    private ArrayList<Object> objectGeneration;
    private ArrayList<Elevation> elevationGeneration;
    private ArrayList<Connection> teamConnectionGeneration;
    private ArrayList<Connection> playerConnectionGeneration;
    private ArrayList<Connection> allLandConnectionGeneration;
    private Cliff cliffGeneration;

        /* Constructor */
        public RmsBuilder() {
            // Object info
            mapName = null;

            // Map constants
            baseTerrain = null;

            // Generation objects
            player = new Player();
            landGeneration = new ArrayList<>();
            terrainGeneration = new ArrayList<>();
            objectGeneration = new ArrayList<>();
            elevationGeneration = new ArrayList<>();
            teamConnectionGeneration = new ArrayList<>();
            playerConnectionGeneration = new ArrayList<>();
            allLandConnectionGeneration = new ArrayList<>();
            cliffGeneration = new Cliff();
        }

        /* Build Method */
        public RMS build() {
            RMS map = new RMS();
            map.setMapName(mapName);
            map.setBaseTerrain(baseTerrain);
            map.setPlayer(player);
            map.setLandGeneration(landGeneration);
            map.setObjectGeneration(objectGeneration);
            map.setElevationGeneration(elevationGeneration);
            map.setTeamConnectionGeneration(teamConnectionGeneration);
            map.setPlayerConnectionGeneration(playerConnectionGeneration);
            map.setAllLandConnectionGeneration(allLandConnectionGeneration);
            map.setCliffGeneration(cliffGeneration);
            return map;
        }

        /* Getter, Setter & Add, Remove Methods */
        public void setMapName(String mapName) {
        	// TODO name constraints
            this.mapName = mapName;
        }

        // TODO add const-map methods


        public void addLand(Land land) {
            landGeneration.add(land);
        }

        // Land
        public void removeLand(Land land) {
            landGeneration.remove(land);
        }

        public void emptyLandGeneration() {
            landGeneration = new ArrayList<>();
        }

        // Terrains
        public void addTerrain(Terrain terrain) {
            terrainGeneration.add(terrain);
        }

        public void removeTerrain(Terrain terrain) {
            terrainGeneration.remove(terrain);
        }
        
        public void emptyTerrainGeneration() {
        	terrainGeneration = new ArrayList<>();
        }
        
        // Objects
        public void addObject(Object obj) {
        	objectGeneration.add(obj);
        }
        
        public void removeObject(Object obj) {
        	objectGeneration.remove(obj);
        }
        
        public void emptyObjGeneration() {
        	objectGeneration = new ArrayList<>();
        }
        
        // Elevations
        public void addElevation(Elevation elevation) {
        	elevationGeneration.add(elevation);
        }
        
        public void removeElevation(Elevation elevation) {
        	elevationGeneration.remove(elevation);
        }
        
        public void emptyElevationGeneration() {
        	elevationGeneration = new ArrayList<>();
        }
        
        // Connection Generation
        public void addTeamConnection(Connection connection) {
        	teamConnectionGeneration.add(connection);
        }
        
        public void removeTeamConnection(Connection connection) {
        	teamConnectionGeneration.remove(connection);
        }
        
        public void emptyTeamConnection() {
        	teamConnectionGeneration = new ArrayList<>();
        }
        
        public void addPlayerConnection(Connection connection) {
        	playerConnectionGeneration.add(connection);
        }
        
        public void removePlayerConnection(Connection connection) {
        	playerConnectionGeneration.remove(connection);
        }
        
        public void emptyPlayerConnection() {
        	playerConnectionGeneration = new ArrayList<>();
        }
        
        public void addAllConnection(Connection connection) {
        	allLandConnectionGeneration.add(connection);
        }
        
        public void removeAllConnection(Connection connection) {
        	allLandConnectionGeneration.remove(connection);
        }
        
        public void emptyAllConnection() {
        	allLandConnectionGeneration = new ArrayList<>();
        }
}
