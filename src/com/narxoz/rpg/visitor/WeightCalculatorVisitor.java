package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;

public class WeightCalculatorVisitor implements ArtifactVisitor {
    private int totalWeight = 0;
    
    @Override
    public void visit(Weapon weapon) {
        totalWeight += weapon.getWeight();
        System.out.printf("  Weighed weapon: %s (weight: %d)%n",
            weapon.getName(), weapon.getWeight());
    }
    
    @Override
    public void visit(Potion potion) {
        totalWeight += potion.getWeight();
        System.out.printf("  Weighed potion: %s (weight: %d)%n",
            potion.getName(), potion.getWeight());
    }
    
    @Override
    public void visit(Scroll scroll) {
        totalWeight += scroll.getWeight();
        System.out.printf("  Weighed scroll: %s (weight: %d)%n",
            scroll.getName(), scroll.getWeight());
    }
    
    @Override
    public void visit(Ring ring) {
        totalWeight += ring.getWeight();
        System.out.printf("  Weighed ring: %s (weight: %d)%n",
            ring.getName(), ring.getWeight());
    }
    
    @Override
    public void visit(Armor armor) {
        totalWeight += armor.getWeight();
        System.out.printf("  Weighed armor: %s (weight: %d)%n",
            armor.getName(), armor.getWeight());
    }
    
    public int getTotalWeight() {
        return totalWeight;
    }
}