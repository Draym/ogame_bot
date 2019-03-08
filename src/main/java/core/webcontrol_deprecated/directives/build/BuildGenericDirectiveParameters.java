package core.webcontrol_deprecated.directives.build;

import core.webcontrol_deprecated.directives.DirectiveParameters;

public class BuildGenericDirectiveParameters extends DirectiveParameters {
    EBuildType type;
    String targetBuild;
    int targetQuantity;

    public BuildGenericDirectiveParameters(EBuildType type, String targetBuild, int targetQuantity) {
        this.type = type;
        this.targetBuild = targetBuild;
        this.targetQuantity = targetQuantity;
    }
}
