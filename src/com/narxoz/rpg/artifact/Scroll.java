package com.narxoz.rpg.artifact;

public class Scroll extends Artifact {
    private final String spellEffect;
    
    public Scroll(String name, int value, int weight, String spellEffect) {
        super(name, value, weight);
        this.spellEffect = spellEffect;
    }
    
    public String getSpellEffect() {
        return spellEffect;
    }
    
    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }
}