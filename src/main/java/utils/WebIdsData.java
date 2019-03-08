package utils;

public class WebIdsData {

    /** LOGIN **/
    public final String btn_loginTab;
    public final String input_loginUsername;
    public final String input_loginPassword;
    public final String btn_loginSubmit;

    /** SERVER **/
    public final String btn_authPlay;
    public final String btn_launchServerAccount;
    public final String search_serverAccountsContainer;
    public final String search_serverAccounts;

    /** BUILD **/
    public final String btn_buildLaunch;
    public final String input_buildQuantity;

    /** FLEET **/
    public final String btn_fleetContinue;
    public final String btn_fleetPosG;
    public final String btn_fleetPosS;
    public final String btn_fleetPosP;
    public final String btn_fleetTypeP;
    public final String btn_fleetTypeM;
    public final String btn_fleetTypeR;
    public final String search_fleetSpeed;
    public final String input_fleetMetal;
    public final String input_fleetCristal;
    public final String input_fleetDeuterium;
    public final String input_fleetAllResources;
    public final String btn_fleetLaunch;

    /** MOVE_TYPE **/
    public final String btn_moveEXPEDITION;
    public final String btn_moveCOLONISER;
    public final String btn_moveRECYCLER;
    public final String btn_moveTRANSPORTER;
    public final String btn_moveSTATIONNER;
    public final String btn_moveESPIONNER;
    public final String btn_moveSTATIONNER_AMIS;
    public final String btn_moveATTAQUER;
    public final String btn_moveATTAQUE_GROUPE;
    public final String btn_moveDETRUIRE;

    /**
     * SINGLETON
     **/

    private static WebIdsData instance;

    private WebIdsData() {

        this.btn_buildLaunch = "a.build-it";
        this.input_buildQuantity = "input#number.amount_input";
        this.btn_authPlay = "button.button.button-primary.button-md";
        this.btn_launchServerAccount = "button.btn.btn-primary";
        this.search_serverAccountsContainer = "myAccounts";
        this.search_serverAccounts = "div.rt-tr-group";
        this.btn_loginTab = "ui-id-1";
        this.input_loginUsername = "usernameLogin";
        this.input_loginPassword = "passwordLogin";
        this.btn_loginSubmit = "loginSubmit";
        this.btn_fleetContinue = "a#continue.on";
        this.btn_fleetPosG = "input#galaxy.galaxy.hideNumberSpin";
        this.btn_fleetPosS = "input#system.system.hideNumberSpin";
        this.btn_fleetPosP = "input#position.planet.hideNumberSpin";
        this.btn_fleetTypeP = "a#pbutton";
        this.btn_fleetTypeM = "a#mbutton";
        this.btn_fleetTypeR = "a#dbutton";
        this.search_fleetSpeed = "div#speedLinks";
        this.input_fleetMetal = "input#metal";
        this.input_fleetCristal = "input#cristal";
        this.input_fleetDeuterium = "input#deuterium";
        this.input_fleetAllResources = "a#allresources";
        this.btn_fleetLaunch = "a#start";
        this.btn_moveEXPEDITION = "a#missionButton15";
        this.btn_moveCOLONISER = "a#missionButton7";
        this.btn_moveRECYCLER = "a#missionButton8";
        this.btn_moveTRANSPORTER = "";
        this.btn_moveSTATIONNER = "";
        this.btn_moveESPIONNER = "";
        this.btn_moveSTATIONNER_AMIS = "";
        this.btn_moveATTAQUER = "";
        this.btn_moveATTAQUE_GROUPE = "";
        this.btn_moveDETRUIRE = "";
    }

    public static WebIdsData get() {
        if (instance == null) {
            instance = new WebIdsData();
        }
        return instance;
    }
}