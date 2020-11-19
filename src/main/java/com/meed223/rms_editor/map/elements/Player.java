package com.meed223.rms_editor.map.elements;

import com.meed223.rms_editor.map.GameType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Player {

    private PlayerPlacementType playerType;
    private GameType gameType;
    private boolean nomad;

    /* Constructor(s) */
    public Player() {
    	this.gameType = GameType.DE;
        this.playerType = PlayerPlacementType.RANDOM;
        nomad = false;
    }
    
    public Player(GameType gameType) {
    	this.gameType = gameType;
    	this.playerType = PlayerPlacementType.RANDOM;
    	nomad = false;
    }
    
    /* Update Game Type */
    public void updateGameType(GameType type) {
    	if (this.gameType == type) {
    		return;
    	}
    	
    	switch(type) {
    	case DE:
    		this.gameType = GameType.DE;
    		break;
    	case HD:
    		this.gameType = GameType.HD;
    		if (playerType == PlayerPlacementType.DIRECT) {
    			playerType = PlayerPlacementType.RANDOM; // HD doesn't support Direct
    		}
    		break;
    	case AOC:
    		// Enforce compatibility with AoC
    		this.gameType = GameType.AOC;
    		this.playerType = PlayerPlacementType.RANDOM;
    		this.nomad = false;  
    		break;
    	default:
    		this.gameType = GameType.DE;
    	}
    }

    /* Convert to RMS */
    @Override
    public String toString() {
        StringBuilder playerSetup = new StringBuilder();
        playerSetup.append("<PLAYER_SETUP>\n");
        playerSetup.append(playerType);
        playerSetup.append("\n");
        playerSetup.append(gameType); // TODO ???? why is this printed?
        if (nomad) {
        	playerSetup.append("nomad_resources\n");
        }
        return playerSetup.toString();
    }
}
