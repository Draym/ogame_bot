package core.webcontrol_deprecated.directives.navigate;

import core.webcontrol_deprecated.directives.DirectiveParameters;

public class NavigateToDirectiveParameters extends DirectiveParameters {
    public String searchName;
    public ENavigateType searchType;

    public NavigateToDirectiveParameters(String searchName, ENavigateType searchType) {
        this.searchName = searchName;
        this.searchType = searchType;
    }
}
