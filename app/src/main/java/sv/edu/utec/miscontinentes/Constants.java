package sv.edu.utec.miscontinentes;

public final class Constants {

    /**
     * Constants for filter types
     */
    public static final int SHOW_RADIO_GROUPS = 0;
    public static final int SHOW_CHECKBOX = 1;

    /**
     * Constants for possible natural destinations
     */
    public static final int SHOW_LAKES = 0;
    public static final int SHOW_RIVERS = 1;
    public static final int SHOW_VOLCANOES = 2;

    /**
     * Constants to pass trough intent, to switch and display correct info
     */
    public static final String SELECTED_FILTER_TYPE = "selected_filter_type";
    public static final String SELECTED_NATURAL_DESTINATION = "selected_natural_destination";
    public static final String SELECTED_CONTINENT = "selected_continent";
}
