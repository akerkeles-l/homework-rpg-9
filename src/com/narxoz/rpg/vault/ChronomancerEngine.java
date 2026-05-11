package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.combatant.HeroMemento;
import com.narxoz.rpg.memento.Caretaker;
import com.narxoz.rpg.visitor.*;

public class ChronomancerEngine {
    
    public VaultRunResult runVault(Hero hero, Inventory vaultInventory) {
        System.out.println("\n=== Chronomancer's Vault Run ===");
        System.out.println("Hero entering vault: " + hero.getName());
        System.out.println("Initial hero state: " + hero);
        
        int artifactsAppraised = 0;
        int mementosCreated = 0;
        int restoredCount = 0;
        
        Caretaker caretaker = new Caretaker();
        
        System.out.println("\n[Phase 1: Saving initial timeline]");
        HeroMemento initialState = hero.createMemento();
        caretaker.save(initialState);
        mementosCreated++;
        
        System.out.println("\n[Phase 2: Appraising artifacts]");
        
        ValueCalculatorVisitor valueVisitor = new ValueCalculatorVisitor();
        System.out.println("\n--- Appraising Artifact Values ---");
        vaultInventory.accept(valueVisitor);
        System.out.printf("Total inventory value: %d gold%n", valueVisitor.getTotalValue());
        artifactsAppraised = vaultInventory.size();
        
        WeightCalculatorVisitor weightVisitor = new WeightCalculatorVisitor();
        System.out.println("\n--- Weighing Artifacts ---");
        vaultInventory.accept(weightVisitor);
        System.out.printf("Total inventory weight: %d units%n", weightVisitor.getTotalWeight());
        
        DetailedReportVisitor reportVisitor = new DetailedReportVisitor();
        System.out.println("\n--- Detailed Inventory Report ---");
        vaultInventory.accept(reportVisitor);
        reportVisitor.printSummary();
        
        System.out.println("\n[Phase 3: The vault's trap activates!]");
        System.out.println("  A time crystal shatters, damaging the hero...");
        
        caretaker.save(hero.createMemento());
        mementosCreated++;
        
        hero.takeDamage(40);
        hero.spendMana(30);
        hero.spendGold(100);
        System.out.println("  After trap:");
        System.out.println("    HP: " + hero.getHp() + "/" + hero.getMaxHp());
        System.out.println("    Mana: " + hero.getMana());
        System.out.println("    Gold: " + hero.getGold());
        
        System.out.println("\n[Phase 4: Chronomancer rewinds time!]");
        System.out.println("  The vault's guardian offers to reverse the damage...");
        
        HeroMemento savedState = caretaker.undo();
        if (savedState != null) {
            hero.restoreFromMemento(savedState);
            restoredCount++;
            System.out.println("  Time reversed! Hero restored to previous state:");
            System.out.println("    HP: " + hero.getHp() + "/" + hero.getMaxHp());
            System.out.println("    Mana: " + hero.getMana());
            System.out.println("    Gold: " + hero.getGold());
        }
        
        System.out.println("\n[Phase 5: Advanced Artifact Analysis]");
        EnchantmentPowerVisitor powerVisitor = new EnchantmentPowerVisitor();
        System.out.println("--- Calculating Enchantment Power ---");
        vaultInventory.accept(powerVisitor);
        System.out.printf("Total enchantment power: %d%n", powerVisitor.getTotalEnchantmentPower());
        
        System.out.println("\n=== Vault Run Complete ===");
        System.out.println("Final hero state: " + hero);
        
        return new VaultRunResult(artifactsAppraised, mementosCreated, restoredCount);
    }
}