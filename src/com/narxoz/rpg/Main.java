package com.narxoz.rpg;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;
import com.narxoz.rpg.visitor.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║     Chronomancer's Vault - Visitor + Memento Demo      ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        
        Hero hero1 = new Hero("Sir Gideon", 100, 25, 15);
        Hero hero2 = new Hero("Lady Morgana", 80, 35, 10);
        
        System.out.println("\nCreated Heroes:");
        System.out.println("  " + hero1);
        System.out.println("  " + hero2);
        
        Inventory vaultInventory = new Inventory();
        
        vaultInventory.addArtifact(new Weapon("Dragon's Bane", 500, 15, 25));
        vaultInventory.addArtifact(new Weapon("Elven Dagger", 250, 5, 12));
        vaultInventory.addArtifact(new Potion("Greater Healing Potion", 100, 1, 50));
        vaultInventory.addArtifact(new Potion("Mana Restoration Elixir", 150, 1, 40));
        vaultInventory.addArtifact(new Scroll("Scroll of Fireball", 200, 1, "Fireball (8d6)"));
        vaultInventory.addArtifact(new Scroll("Scroll of Teleportation", 300, 1, "Teleport"));
        vaultInventory.addArtifact(new Ring("Ring of Protection", 400, 1, 5));
        vaultInventory.addArtifact(new Ring("Ring of Wizardry", 600, 1, 8));
        vaultInventory.addArtifact(new Armor("Mithril Chainmail", 800, 25, 15));
        vaultInventory.addArtifact(new Armor("Enchanted Leather", 350, 10, 8));
        
        System.out.println("\nVault Inventory contains " + vaultInventory.size() + " artifacts");
        
        ChronomancerEngine engine = new ChronomancerEngine();
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Running Chronomancer's Vault for " + hero1.getName());
        System.out.println("=".repeat(60));
        
        VaultRunResult result = engine.runVault(hero1, vaultInventory);
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("VAULT RUN RESULTS");
        System.out.println("=".repeat(60));
        System.out.println(result);
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("DEMONSTRATING OPEN/CLOSED PRINCIPLE");
        System.out.println("Adding a new visitor without modifying artifact classes");
        System.out.println("=".repeat(60));
        
        ArtifactVisitor rarityVisitor = new ArtifactVisitor() {
            @Override
            public void visit(Weapon weapon) {
                int rarity = (weapon.getAttackBonus() * weapon.getValue()) / 100;
                System.out.printf("  %s (Weapon): Rarity Score = %d%n", 
                    weapon.getName(), rarity);
            }
            
            @Override
            public void visit(Potion potion) {
                int rarity = (potion.getHealing() * potion.getValue()) / 1000;
                System.out.printf("  %s (Potion): Rarity Score = %d%n",
                    potion.getName(), rarity);
            }
            
            @Override
            public void visit(Scroll scroll) {
                int rarity = scroll.getSpellEffect().length() * scroll.getValue() / 100;
                System.out.printf("  %s (Scroll): Rarity Score = %d%n",
                    scroll.getName(), rarity);
            }
            
            @Override
            public void visit(Ring ring) {
                int rarity = ring.getMagicBonus() * ring.getValue() / 50;
                System.out.printf("  %s (Ring): Rarity Score = %d%n",
                    ring.getName(), rarity);
            }
            
            @Override
            public void visit(Armor armor) {
                int rarity = armor.getDefenseBonus() * armor.getValue() / 100;
                System.out.printf("  %s (Armor): Rarity Score = %d%n",
                    armor.getName(), rarity);
            }
        };
        
        System.out.println("\nCalculating artifact rarity scores (new visitor):");
        vaultInventory.accept(rarityVisitor);
        
        System.out.println("\n✓ Successfully added new visitor without modifying any artifact class!");
        System.out.println("✓ The Visitor pattern follows the Open/Closed Principle.");
        
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║                     DEMO COMPLETE                       ║");
        System.out.println("║  Visitor Pattern: Appraised all artifact types          ║");
        System.out.println("║  Memento Pattern: Saved and restored hero state         ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}