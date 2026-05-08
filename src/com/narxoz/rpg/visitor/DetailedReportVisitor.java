package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;

public class DetailedReportVisitor implements ArtifactVisitor {
    private int weaponCount = 0;
    private int potionCount = 0;
    private int scrollCount = 0;
    private int ringCount = 0;
    private int armorCount = 0;
    
    @Override
    public void visit(Weapon weapon) {
        weaponCount++;
        System.out.printf("  [WEAPON] %s: attack=%+d, value=%d, weight=%d%n",
            weapon.getName(), weapon.getAttackBonus(), 
            weapon.getValue(), weapon.getWeight());
    }
    
    @Override
    public void visit(Potion potion) {
        potionCount++;
        System.out.printf("  [POTION] %s: healing=%d, value=%d, weight=%d%n",
            potion.getName(), potion.getHealing(),
            potion.getValue(), potion.getWeight());
    }
    
    @Override
    public void visit(Scroll scroll) {
        scrollCount++;
        System.out.printf("  [SCROLL] %s: spell='%s', value=%d, weight=%d%n",
            scroll.getName(), scroll.getSpellEffect(),
            scroll.getValue(), scroll.getWeight());
    }
    
    @Override
    public void visit(Ring ring) {
        ringCount++;
        System.out.printf("  [RING] %s: magic=%+d, value=%d, weight=%d%n",
            ring.getName(), ring.getMagicBonus(),
            ring.getValue(), ring.getWeight());
    }
    
    @Override
    public void visit(Armor armor) {
        armorCount++;
        System.out.printf("  [ARMOR] %s: defense=%+d, value=%d, weight=%d%n",
            armor.getName(), armor.getDefenseBonus(),
            armor.getValue(), armor.getWeight());
    }
    
    public void printSummary() {
        System.out.println("\n--- Inventory Summary ---");
        System.out.printf("Weapons: %d%n", weaponCount);
        System.out.printf("Potions: %d%n", potionCount);
        System.out.printf("Scrolls: %d%n", scrollCount);
        System.out.printf("Rings: %d%n", ringCount);
        System.out.printf("Armor: %d%n", armorCount);
        System.out.printf("Total items: %d%n", 
            weaponCount + potionCount + scrollCount + ringCount + armorCount);
    }
}