package core.webcontrol_deprecated.directives.build;


import utils.Pair;

import java.util.*;

public enum EBuildType {
    FLEET("Flotte", new ArrayList<Pair<String, String>>() {
        {
            add(new Pair<String, String>("Petit transporteur", "div.item_box.civil202"));
            add(new Pair<String, String>("Grand transporteur", "div.item_box.civil203"));
            add(new Pair<String, String>("Vaisseau de colonisation", "div.item_box.civil208"));
            add(new Pair<String, String>("Recycleur", "div.item_box.civil209"));
            add(new Pair<String, String>("Sonde d'espionnage", "div.item_box.civil210"));
            add(new Pair<String, String>("Satellite solaire", "div.item_box.civil212"));
            add(new Pair<String, String>("Chasseur léger", "div.item_box.military204"));
            add(new Pair<String, String>("Chasseur lourd", "div.item_box.military205"));
            add(new Pair<String, String>("Croiseur", "div.item_box.military206"));
            add(new Pair<String, String>("Vaisseau de bataille", "div.item_box.military207"));
            add(new Pair<String, String>("Traqueur", "div.item_box.military215"));
            add(new Pair<String, String>("Bombardier", "div.item_box.military211"));
            add(new Pair<String, String>("Destructeur", "div.item_box.military213"));
            add(new Pair<String, String>("Étoile de la mort", "div.item_box.military214"));
        }
    }, true),
    DEFENSE("Défense", new ArrayList<Pair<String, String>>() {
        {
            add(new Pair<String, String>("Lanceur de missiles", "div.item_box.defense401"));
            add(new Pair<String, String>("Artillerie laser légère", "div.item_box.defense402"));
            add(new Pair<String, String>("Artillerie laser lourd", "div.item_box.defense403"));
            add(new Pair<String, String>("Canon de Gauss", "div.item_box.defense404"));
            add(new Pair<String, String>("Artillerie à ions", "div.item_box.defense405"));
            add(new Pair<String, String>("Lanceur de plasma", "div.item_box.defense406"));
            add(new Pair<String, String>("Petit bouclier", "div.item_box.defense407"));
            add(new Pair<String, String>("Grand bouclier", "div.item_box.defense408"));
            add(new Pair<String, String>("Missile d'interception", "div.item_box.defense502"));
            add(new Pair<String, String>("Misile interplanétaire", "div.item_box.defense503"));
        }
    }, true),
    ECONOMY("Ressources", new ArrayList<Pair<String, String>>() {
        {
            add(new Pair<String, String>("Mine de métal", "div.supply1"));
            add(new Pair<String, String>("Mine de cristal", "div.supply2"));
            add(new Pair<String, String>("Synthétiseur de deutérium", "div.supply3"));
            add(new Pair<String, String>("Central électrique solaire", "div.supply4"));
            add(new Pair<String, String>("Central électrique de fusion", "div.supply12"));
            add(new Pair<String, String>("Hangar de métal", "div.supply22"));
            add(new Pair<String, String>("Hangar de cristal", "div.supply23"));
            add(new Pair<String, String>("Réservoir de deutérium", "div.supply24"));
        }
    }, false),
    INSTALLATION("Installations", new ArrayList<Pair<String, String>>() {
        {
            add(new Pair<String, String>("Usine de robots", "div.item_box.station14"));
            add(new Pair<String, String>("Chantier spatiale", "div.item_box.station21"));
            add(new Pair<String, String>("Laboratoire de recherche", "div.item_box.station31"));
            add(new Pair<String, String>("Dépôt de ravitaillement", "div.item_box.station34"));
            add(new Pair<String, String>("Silo de missiles", "div.item_box.station44"));
            add(new Pair<String, String>("Usine de nanites", "div.item_box.station15"));
            add(new Pair<String, String>("Terraformeur", "div.item_box.station33"));
            add(new Pair<String, String>("Dock spatial", "div.item_box.station36"));
        }
    }, false),
    RESEARCH("Recherches", new ArrayList<Pair<String, String>>() {
        {
            add(new Pair<String, String>("Technologie énergétique", "div.item_box.research113"));
            add(new Pair<String, String>("Technologie Laser", "div.item_box.research120"));
            add(new Pair<String, String>("Technologie à ions", "div.item_box.research121"));
            add(new Pair<String, String>("Technologie hyperespace", "div.item_box.research114"));
            add(new Pair<String, String>("Technologie Plasma", "div.item_box.research122"));
            add(new Pair<String, String>("Réacteur à combustion", "div.item_box.research115"));
            add(new Pair<String, String>("Réacteur à impulsion", "div.item_box.research117"));
            add(new Pair<String, String>("Propulsion hyperespace", "div.item_box.research118"));
            add(new Pair<String, String>("Technologie Espionnage", "div.item_box.research106"));
            add(new Pair<String, String>("Technologie Ordinateur", "div.item_box.research108"));
            add(new Pair<String, String>("Astrophysique", "div.item_box.research124"));
            add(new Pair<String, String>("Réseau de recherche intergalactique", "div.item_box.research123"));
            add(new Pair<String, String>("Technologie Graviton", "div.item_box.research199"));
            add(new Pair<String, String>("Technologie Armes", "div.item_box.research109"));
            add(new Pair<String, String>("Technologie Bouclier", "div.item_box.research110"));
            add(new Pair<String, String>("Technologie Protection des vaisseaux spatiaux", "div.item_box.research111"));
        }
    }, false);

    public final String location;
    public final List<Pair<String, String>> targets;
    public final boolean hasQuantity;

    EBuildType(String location, List<Pair<String, String>> targets, boolean hasQuantity) {

        this.location = location;
        this.targets = targets;
        this.hasQuantity = hasQuantity;
    }

    public Pair<String, String> getTarget(String id) {
        for (Pair<String, String> command : targets) {
            if (command.key.toLowerCase().equals(id.toLowerCase()))
                return command;
        }
        return null;
    }
}
