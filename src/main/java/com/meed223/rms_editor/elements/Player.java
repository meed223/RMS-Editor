package com.meed223.rms_editor.elements;

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
    		break;
    	case AOC:
    		this.gameType = GameType.AOC;
    		this.playerType = PlayerPlacementType.RANDOM;
    		break;
    	default:
    		this.gameType = GameType.DE;
    	}
    }

    /* Hash Code */
    @Override
    public int hashCode() {
        int hash = 31;
        hash = 7 * hash + (playerType == null ? 0 : playerType.hashCode());
        return hash;
    }

    /* Convert to RMS */
    @Override
    public String toString() {
        return "<PLAYER_SETUP>\n" + playerType.getPlacementType();
    }

    /* Getters & Setters */
    public PlayerPlacementType getType() {
        return playerType;
    }

    public void setPlacementType(PlayerPlacementType type) {
        // TODO - remove or repurpose InvalidPlayerTypeException
        this.playerType = type;
    }
}
