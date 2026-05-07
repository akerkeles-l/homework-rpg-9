package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;

public class ValueCalculatorVisitor implements ArtifactVisitor {
    private int totalValue = 0;
    
    @Override
    public void visit(Weapon weapon) {
        totalValue += weapon.getValue();
        System.out.printf("  Appraised weapon: %s (value: %d, attack: +%d)%n",
            weapon.getName(), weapon.getValue(), weapon.getAttackBonus());
    }
    
    @Override
    public void visit(Potion potion) {
        totalValue += potion.getValue();
        System.out.printf("  Appraised potion: %s (value: %d, healing: %d)%n",
            potion.getName(), potion.getValue(), potion.getHealing());
    }
    
    @Override
    public void visit(Scroll scroll) {
        totalValue += scroll.getValue();
        System.out.printf("  Appraised scroll: %s (value: %d, spell: %s)%n",
            scroll.getName(), scroll.getValue(), scroll.getSpellEffect());
    }
    
    @Override
    public void visit(Ring ring) {
        totalValue += ring.getValue();
        System.out.printf("  Appraised ring: %s (value: %d, magic: +%d)%n",
            ring.getName(), ring.getValue(), ring.getMagicBonus());
    }
    
    @Override
    public void visit(Armor armor) {
        totalValue += armor.getValue();
        System.out.printf("  Appraised armor: %s (value: %d, defense: +%d)%n",
            armor.getName(), armor.getValue(), armor.getDefenseBonus());
    }
    
    public int getTotalValue() {
        return totalValue;
    }
}