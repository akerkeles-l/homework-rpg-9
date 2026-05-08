package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;

public class EnchantmentPowerVisitor implements ArtifactVisitor {
    private int totalEnchantmentPower = 0;
    
    @Override
    public void visit(Weapon weapon) {
        totalEnchantmentPower += weapon.getAttackBonus();
        System.out.printf("  Weapon enchantment: %s (power: +%d)%n",
            weapon.getName(), weapon.getAttackBonus());
    }
    
    @Override
    public void visit(Potion potion) {
        totalEnchantmentPower += potion.getHealing() / 10;
        System.out.printf("  Potion potency: %s (power: %d)%n",
            potion.getName(), potion.getHealing() / 10);
    }
    
    @Override
    public void visit(Scroll scroll) {
        totalEnchantmentPower += scroll.getSpellEffect().length();
        System.out.printf("  Scroll complexity: %s (power: %d)%n",
            scroll.getName(), scroll.getSpellEffect().length());
    }
    
    @Override
    public void visit(Ring ring) {
        totalEnchantmentPower += ring.getMagicBonus();
        System.out.printf("  Ring enchantment: %s (power: +%d)%n",
            ring.getName(), ring.getMagicBonus());
    }
    
    @Override
    public void visit(Armor armor) {
        totalEnchantmentPower += armor.getDefenseBonus();
        System.out.printf("  Armor enchantment: %s (power: +%d)%n",
            armor.getName(), armor.getDefenseBonus());
    }
    
    public int getTotalEnchantmentPower() {
        return totalEnchantmentPower;
    }
}