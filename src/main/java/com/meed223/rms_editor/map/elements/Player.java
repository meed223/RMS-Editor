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

    /* Constructor(s) */
    public Player() {
    	this.gameType = GameType.DE;
        this.playerType = PlayerPlacementType.RANDOM;
    }
    
    public Player(GameType gameType) {
    	this.gameType = gameType;
    	this.playerType = PlayerPlacementType.RANDOM;
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
    		this.gameType = GameType.AOC;
    		this.playerType = PlayerPlacementType.RANDOM; // Only type supported
    		break;
    	default:
    		this.gameType = GameType.DE;
    	}
    }

    /* Convert to RMS */
    @Override
    public String toString() {
        return "<PLAYER_SETUP>\n" + playerType.getPlacementType();
    }
}
