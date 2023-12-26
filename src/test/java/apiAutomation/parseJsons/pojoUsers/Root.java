package apiAutomation.parseJsons.pojoUsers;

import net.minidev.json.annotate.JsonIgnore;

import java.util.ArrayList;

@lombok.Data
public class Root {

    String page;
    String per_page;
    String total;
    String total_pages;
    ArrayList<Data> data;
    Support support;
}
