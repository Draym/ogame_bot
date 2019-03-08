package core.webcontrol_deprecated.directives.navigate;

public enum ENavigateType {
    PLANET("a.planetlink.tooltipRight.tooltipClose.js_hideTipOnMobile"),
    MENU("a.menubutton");

    String webId;

    ENavigateType(String webId){
        this.webId = webId;
    }
}
