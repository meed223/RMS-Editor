package com.meed223.rms_editor.utils;

import java.util.ArrayList;

import com.meed223.rms_editor.map.RMS;
import com.meed223.rms_editor.map.elements.*;
import com.meed223.rms_editor.map.elements.Object;




    public class RmsBuilder {
        /* Object Info */
        public String mapName;

        /* RMS Map Constants */
        //public ArrayList<mapDefinition> mapDefs;      // For random at start of maps, for deciding if snowy, etc.
        public ArrayList<MapConst> mapConsts;
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
            mapConsts = new ArrayList<>();
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
            map.setMapConsts(mapConsts);
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
            this.mapName = mapName;
        }

        public String getMapName() {
            return mapName;
        }

        public void addMapConst(MapConst mc) {
            mapConsts.add(mc);
        }

        public void removeMapConst(MapConst mc) {
            mapConsts.remove(mc);
        }

        public ArrayList<MapConst> getMapConsts() {
            return mapConsts;
        }

        public void emptyMapConsts() {
            for (MapConst mc : mapConsts) {
                mapConsts.remove(mc);
            }
        }

        public void setBaseTerrain(String baseTerrain) {
            this.baseTerrain = baseTerrain;
        }

        public String getBaseTerrain() {
            return baseTerrain;
        }

        public void setPlayer(Player player) {
            this.player = player;
        }

        public Player getPlayer() {
            return player;
        }

        public void addLand(Land land) {
            landGeneration.add(land);
        }

        public void removeLand(Land land) {
            landGeneration.remove(land);
        }

        public ArrayList<Land> getLandGeneration() {
            return landGeneration;
        }

        public void emptyLandGeneration() {
            for (Land land : landGeneration) {
                landGeneration.remove(land);
            }
        }

        public void addTerrain(Terrain terrain) {
            terrainGeneration.add(terrain);
        }

        public void removeTerrain(Terrain terrain) {
            terrainGeneration.remove(terrain);
        }
}
