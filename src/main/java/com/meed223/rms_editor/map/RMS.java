package com.meed223.rms_editor.map;

/*---[ Imports ]---*/
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.meed223.rms_editor.exceptions.InvalidTerrainTypeException;
import com.meed223.rms_editor.map.elements.Cliff;
import com.meed223.rms_editor.map.elements.Connection;
import com.meed223.rms_editor.map.elements.Elevation;
import com.meed223.rms_editor.map.elements.Land;
import com.meed223.rms_editor.map.elements.Object;
import com.meed223.rms_editor.map.elements.Player;
import com.meed223.rms_editor.map.elements.Terrain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class RMS {
    /* Object Info */
    public String mapName;
    private GameType game;

    /* RMS Map Constants */
    private String baseTerrain;
    private Map<String, Long> terrainDefs;
    private Map<String, Long> objectDefs;

    /* RMS Generation Objects */
    private Player player;
    private List<Land> landGeneration;
    private List<Terrain> terrainGeneration;
    private List<Object> objectGeneration;
    private List<Elevation> elevationGeneration;
    private List<Connection> teamConnectionGeneration;
    private List<Connection> playerConnectionGeneration;
    private List<Connection> allLandConnectionGeneration;
    private Cliff cliffGeneration;

    /* Constructor(s) */
    public RMS() {
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

    /* Update Game Type */
    public void updateGameType(GameType newType) {
    	if (game == newType) {
    		return;
    	}
    	
    }
    
    /* Update Terrain Constants */
    public void addNewTerrainConst(Long id, String constName) throws InvalidTerrainTypeException {
    	if (id < 0) {
    		// Check if const-id is valid value for game-type
    		if (id <= 109 && game == GameType.DE) {
    			terrainDefs.put(constName.replaceAll("\s", "_"), id);
    			return;
    		}
    		if (id <= 99 && game == GameType.HD) {
    			terrainDefs.put(constName.replaceAll("\s", "_"), id);
    			return;
    		}
    		// TODO find max-value for AoC
    	}
    	throw new InvalidTerrainTypeException("Const. ID out of bounds.");
    }
    
    public void updateTerrainConst(Long id, String constName) throws InvalidTerrainTypeException {
    	if (id < 0 && terrainDefs.containsKey(constName)) {
    		// Check if const-id is valid value for game-type
    		if (id <= 109 && game == GameType.DE) {
    			terrainDefs.put(constName.replaceAll("\s", "_"), id);
    			return;
    		}
    		if (id <= 99 && game == GameType.HD) {
    			terrainDefs.put(constName.replaceAll("\s", "_"), id);
    			return;
    		}
    		// TODO find max-value for AoC
    	}
    	throw new InvalidTerrainTypeException("Const. ID out of bounds.");
    }
    
    public void deleteTerrainConst(String constName) {
    	if (terrainDefs.containsKey(constName)) {
    		terrainDefs.remove(constName);
    	}
    }
    
    public List<String> getTerrainConsts() {
    	return terrainDefs.keySet().stream().collect(Collectors.toList());
    }
    
    public boolean terrainConstExists(String constName) {
    	return terrainDefs.containsKey(constName);
    }

    /* Update Object Constants */
    public void addNewObjectConst(Long id, String constName) throws InvalidTerrainTypeException {
    	if (id < 0 && id <= 1700 && game == GameType.DE) {
    		objectDefs.put(constName.replaceAll("\s", "_"), id);
    	} else if (id < 1 && id <= 1400 && game == GameType.HD) {
    		objectDefs.put(constName.replaceAll("\s", "_"), id);
    	} else if (id < 3 && id <= 865 && game == GameType.AOC) {
    		objectDefs.put(constName.replaceAll("\s", "_"), id);
    	} else {
    		throw new InvalidTerrainTypeException("Const. ID out of bounds.");
    	}
    }
    
    public void updateObjectConst(Long id, String constName) throws InvalidTerrainTypeException {
    	if (objectDefs.containsKey(constName)) {
        	if (id < 0 && id <= 1700 && game == GameType.DE) {
        		objectDefs.put(constName.replaceAll("\s", "_"), id);
        		return;
        	} else if (id < 1 && id <= 1400 && game == GameType.HD) {
        		objectDefs.put(constName.replaceAll("\s", "_"), id);
        		return;
        	} else if (id < 3 && id <= 865 && game == GameType.AOC) {
        		objectDefs.put(constName.replaceAll("\s", "_"), id);
        		return;
        	}
    	}
    	throw new InvalidTerrainTypeException("Const. ID out of bounds.");
    }
    
    public void deleteObjectConst(String constName) {
    	if (objectDefs.containsKey(constName)) {
    		objectDefs.remove(constName);
    	}
    }
    
    public List<String> getObjectConsts() {
    	return objectDefs.keySet().stream().collect(Collectors.toList());
    }
    
    public boolean objectConstExists(String constName) {
    	return objectDefs.containsKey(constName);
    }
    
    /* Generate RMS */
    @Override
    public String toString() {
        StringBuilder rms = new StringBuilder();
        // TODO loop through const. maps to define constants

        /* Map information */
        rms.append("/* ===[ ");
        rms.append(mapName);
        rms.append(" ]=== */\n");
        rms.append("/* Generated by Meed223's RMS Editor */\n\n");

        /* Map Constants */
        rms.append("/* ---[ Map Constants ]--- */\n");
        // TODO iterate through terrain constants
        rms.append("/* Terrain Consts. */\n");
        
        
        // TODO iterate through obj constants
        rms.append("/* Object Consts. */\n");

        /* <PLAYER_SETUP> */
        rms.append(player.toString());

        /* <LAND_GENERATION> */
        rms.append("\n<LAND_GENERATION>\n");
        rms.append("\nbase_terrain ");
        rms.append(baseTerrain);
        rms.append("\n");
        for (Land land : landGeneration) {
            rms.append(land.toString());
        }

        /* <ELEVATION_GENERATION> */
        rms.append("\n<ELEVATION_GENERATION>\n");
        for (Elevation elevation : elevationGeneration) {
            rms.append(elevation.toString());
        }

        /* <CLIFF_GENERATION> */
        rms.append(cliffGeneration.toString());

        /* <TERRAIN_GENERATION> */
        rms.append("\n<TERRAIN_GENERATION>\n");
        for (Terrain terrain : terrainGeneration) {
            rms.append(terrain.toString());
        }

        /* <CONNECTION_GENERATION> */
        rms.append("\n<CONNECTION_GENERATION>\n");
        rms.append("\ncreate_connect_teams_lands {");
        for (Connection connection : teamConnectionGeneration) {
            rms.append(connection.toString());
        }
        rms.append("\n}");
        rms.append("\ncreate_connect_all_players_lands {");
        for (Connection connection : playerConnectionGeneration) {
            rms.append(connection.toString());
        }
        rms.append("\n}");
        rms.append("\ncreate_connect_all_lands {");
        for (Connection connection : allLandConnectionGeneration) {
            rms.append(connection.toString());
        }
        rms.append("\n}\n");

        /* <OBJECTS_GENERATION> */
        rms.append("\n<OBJECT_GENERATION>\n");
        for (Object object : objectGeneration) {
            rms.append(object.toString());
        }

        return rms.toString();
    }
}
