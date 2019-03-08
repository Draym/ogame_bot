package core.webcontrol_deprecated.directives.fleet;

public enum EMoveType {
    EXPEDITION("EXPEDITION", "a#missionButton15"),
    COLONISER("COLONISER", "a#missionButton7"),
    RECYCLER("RECYCLER", "a#missionButton8"),
    TRANSPORTER("TRANSPORTER", "a#missionButton3"),
    STATIONNER("STATIONNER", "a#missionButton4"),
    ESPIONNER("ESPIONNER", "a#missionButton6"),
    STATIONNER_AMIS("STATIONNER_AMIS", "a#missionButton5"),
    ATTAQUER("ATTAQUER", "a#missionButton1"),
    ATTAUQE_GROUPE("ATTAQUE_GROUPE", "a#missionButton2"),
    DETRUIRE("DETRUIRE", "a#missionButton9");

    public String id;
    public String web_id;

    EMoveType(String id, String web_id) {
        this.id = id;
        this.web_id = web_id;
    }

}
